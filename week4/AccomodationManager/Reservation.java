package reservationmanager;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class Reservation implements ParseXML {
    /*
     * Object Attributes
     */
    private String reservationID;
    private String accountID;
    protected String childXml;
    protected List<Address> addressList;
    protected Date startDate;
    protected ReservationStatus status;
    private ReservationType type;
    protected boolean cancellable;
    protected int numberOfNights;
    protected int numberOfBeds;
    protected int numberOfRooms;
    protected int numberOfBaths;
    protected int lodgingSize;
    protected float lodgingSizeFee;
    protected float priceTotal;
    protected final float BASEPRICE = 120;

    /*
     * Default constructor
     */
    public Reservation(ReservationType type, String accountID){
        this.reservationID = type == ReservationType.HOTEL ? this.generateUniqueID("HOT") : type == ReservationType.HOUSE ? this.generateUniqueID("HOU") : this.generateUniqueID("CAB");
        this.accountID = accountID;
        this.numberOfBeds = 2;
        this.numberOfRooms = 1;
        this.status = ReservationStatus.DRAFT;
        this.addressList = new ArrayList<Address>();
    }

    /*
     * Calculate Total Price
     */
    public float calculatePriceTotal(){
        return this.BASEPRICE + this._calculateLodgingSizeFee();
    };

    /*
     * Calculate Daily Price
     */
    public float calculateDailyPrice(){
        return (this.calculatePriceTotal()/this.numberOfNights);
    };

    /*
     * Calculate Loding Price
     */
    protected float _calculateLodgingSizeFee(){
        return this.lodgingSize > 900 ? (this.lodgingSize - 900 ) * 15 : 0;
    }
    
    public void cancelReservation() throws Exception {
        /*
         * if Date < Today
         * this.status = CANCELLED
         */
    }

     /*
     * Save Current Object from ParseXML interface
     */
    public void saveCurrentObject() throws Exception{

        /*
        * Local Attributes
        */
        String reservationDir = String.format("./accounts/%s",this.accountID);
        String reservationFileName = String.format("%s/res-%s.xml", reservationDir, this.reservationID);
        char foutReservationInfo[] = this.toString().toCharArray();

        try {
            
            /*
            * Find File based on reservation ID
            * Write XML as string to file
            */
            File accountInfo = new File(reservationDir);
            if(!accountInfo.exists())
                throw new Exception();
            accountInfo = null;

            FileOutputStream writeReservationToFile = new FileOutputStream(reservationFileName, true);

            for(char c : foutReservationInfo)
                writeReservationToFile.write(c);

            writeReservationToFile.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };

    /*
     * Load Object from ParseXML interface
     */
    public void loadObjectFromFile(String identifierString) throws Exception{
        
        // Set current object id to match object to be loaded
        this.reservationID = identifierString;
        
        /*
        * Local Variables
        */
        List<String> parameters = new ArrayList<String>();
        try {
            
            /*
             * Locate and load reservation as XML string
             */
            String reservationFile = String.format("./accounts/%s/res-%s.xml", this.accountID, identifierString);
            String reservationXmlAsString = new String(Files.readAllBytes(Paths.get(reservationFile)));

            /*
            * Let status
            */
            switch(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<reservationStatus>") + "<reservationStatus>".length(), reservationXmlAsString.indexOf("</reservationStatus>"))){
                case "DRAFT":
                    this.status = ReservationStatus.DRAFT;
                    break;
                case "COMPLETED":
                    this.status = ReservationStatus.COMPLETED;
                    break;
                case "CANCELLED":
                    this.status = ReservationStatus.CANCELLED;
                    break;
            }

            /*
             * Parse Physical Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            Collections.addAll(parameters,reservationXmlAsString.substring(reservationXmlAsString.indexOf("<PhysicalAddress>") + "<PhysicalAddress>".length(), reservationXmlAsString.indexOf("</PhysicalAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x == "");
            this.addressList.add(new Address(parameters));
            parameters.clear();

            /*
             * Parse Mailing Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            Collections.addAll(parameters,reservationXmlAsString.substring(reservationXmlAsString.indexOf("<MailingAddress>") + "<MailingAddress>".length(), reservationXmlAsString.indexOf("</MailingAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x == "");
            this.addressList.add(new Address(parameters));
            parameters.clear();

            //Set object date
            this.startDate = (Date)(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<date>") + "<date>".length(), reservationXmlAsString.indexOf("</date>"))));

            // set numebr of nights
            this.numberOfNights = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfNights>") + "<numberOfNights>".length(), reservationXmlAsString.indexOf("</numberOfNights>")));

            //set number of beds
            this.numberOfBeds = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfBeds>") + "<numberOfBeds>".length(), reservationXmlAsString.indexOf("</numberOfBeds>")));

            //set number of rooms
            this.numberOfRooms = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfRooms>") + "<numberOfRooms>".length(), reservationXmlAsString.indexOf("</numberOfRooms>")));

            //set number of baths
            this.numberOfBaths  = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfBaths>") + "<numberOfBaths>".length(), reservationXmlAsString.indexOf("</numberOfBaths>")));

            //set lodging size
            this.lodgingSize = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<lodgingSize>") + "<lodgingSize>".length(), reservationXmlAsString.indexOf("</lodgingSize>")));

            //set xml for child classes to finish in their constructors
            this.childXml = reservationXmlAsString.substring(reservationXmlAsString.indexOf("</lodgingSize>") + "</lodgingSize>".length(), reservationXmlAsString.length() - 1);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    /*
     * Update object from parameters
     */
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        this.addressList.add(0, (Address)parameters.get(0));
        this.addressList.add(1, (Address)parameters.get(1));
        this.startDate = (Date)(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse((String)parameters.get(2)));
        this.cancellable = (Boolean)parameters.get(3);
        this.numberOfNights = (Integer)parameters.get(4);
        this.numberOfBeds = (Integer)parameters.get(5);
        this.numberOfRooms = (Integer)parameters.get(6);
        this.numberOfBaths = (Integer)parameters.get(7);
        this.lodgingSize = (Integer)parameters.get(8);
    }

    /*
     * Delete Object from ParseXML interface
     */
    public void deleteFileFromID(String identifierString) throws Exception {
        // Check if reservation is canceable
        if(!this.cancellable)
            throw new Exception();
        /*
        * Save file as different naming convention to prevent it from being loaded
        */ 
        String reservationFile = String.format("%s/%s/res-%s.xml", this.accountID,this.accountID,this.reservationID);
        String cancelledFile = String.format("%s/%s/res-cancelled-%s.xml", this.accountID,this.accountID,this.reservationID);
        Path file = Paths.get(reservationFile);
        Files.move(file, file.resolveSibling(cancelledFile));
    }

    /*
     * Generate Unique Account ID Operation From ParseXML Interface
     */
    public String generateUniqueID(String prefix){
        /*
         * Create unique ID
         * take prefix as string
         * Stringbuilder to build random charachters
         */
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s%s",prefix,random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(10)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };

    //Reservation ID getter
    public String getReservationID(){
        return this.reservationID;
    }

    @Override
    public String toString(){
        return String.format("<reservationID>%s</reservationID>\n<accountID>%s</accountID>\n<reservationStatus>%s</reservationStatus>\n<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<date>%s</date>\n<numberOfNights>%s</numberOfNights>\n<numberOfBeds>%s</numberOfBeds>\n<numberOfRooms>%s</numberOfRooms>\n<numberOfBaths>%s</numberOfBaths>\n<lodgingSize>%s</lodgingSize>", this.reservationID, this.accountID, this.status.toString(),this.addressList.get(0).toString(),this.addressList.get(1).toString(), this.startDate.toString(),String.valueOf(this.numberOfNights),String.valueOf(this.numberOfBeds), String.valueOf(this.numberOfRooms), String.valueOf(this.numberOfBaths), String.valueOf(this.lodgingSize));
    }
}
