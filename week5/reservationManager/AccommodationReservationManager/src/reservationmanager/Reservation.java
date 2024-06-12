package reservationmanager;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class Reservation implements ParseXML, ParameterValidator {
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
    public static List<Object> validationParameters = Arrays.asList(new Address(), new Address() ,new Date(),false,0,0,0,0,0,0);

    /*
     * Default constructor
     */
    public Reservation(ReservationType type, String accountID){
        this.reservationID = type == ReservationType.HOTEL ? this.generateUniqueID("HOT") : type == ReservationType.HOUSE ? this.generateUniqueID("HOU") : this.generateUniqueID("CAB");
        this.accountID = accountID;
        this.numberOfBeds = 2;
        this.numberOfRooms = 1;
        this.status = ReservationStatus.DRAFT;
        this.addressList = new ArrayList<>();
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
         * else throw IllegalOperationException()
         */
        if(!this.cancellable)
            throw new IllegalOperationException("This reservation is not cancellable");
        this.status = ReservationStatus.CANCELLED;
    }

     /*
     * Save Current Object from ParseXML interface
     */
    public void saveCurrentObject() throws Exception {
        /*
         * If current ReservationStatus = CANCELLED
         * Throw IllegalStateException
         */
        if(this.status == ReservationStatus.CANCELLED)
            throw new IllegalStateException("Can not save or update current Reservation due to CANCELLED status");
        /*
        * Local Attributes
        */
        String reservationDir = String.format("./accounts/%s",this.accountID);
        String reservationFileName = String.format("%s/res-%s.xml", reservationDir, this.reservationID);
        char foutReservationInfo[] = this.toString().toCharArray();

        /*
        * Find File based on reservation ID
        * Write XML as string to file
        */
        File accountInfo = new File(reservationDir);
        if(!accountInfo.exists())
            throw new DuplicateObjectException("Reservation already exists");

        FileOutputStream writeReservationToFile = new FileOutputStream(reservationFileName, true);

        for(char c : foutReservationInfo)
            writeReservationToFile.write(c);

        writeReservationToFile.close();        
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
        List<String> parameters = new ArrayList<>();
            
            /*
             * Locate and load reservation as XML string
             */
            String reservationFile = String.format("./accounts/%s/res-%s.xml", this.accountID, identifierString);
            String reservationXmlAsString = new String(Files.readAllBytes(Paths.get(reservationFile)));

            /*
             * Check if Reservation File Exists
             * If not throw IllegalLoadException
             */
            File fileCheck = new File(reservationFile);
            if(!fileCheck.exists())
                throw new IllegalLoadException("Reservation does not exist");
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
            parameters = Arrays.asList(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<PhysicalAddress>") + "<PhysicalAddress>".length(), reservationXmlAsString.indexOf("</PhysicalAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x.equals(""));
            this.addressList.add(new Address(parameters));

            /*
             * Parse Mailing Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            parameters = Arrays.asList(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<MailingAddress>") + "<MailingAddress>".length(), reservationXmlAsString.indexOf("</MailingAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x.equals(""));
            this.addressList.add(new Address(parameters));

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

    };

    /*
     * Update object from parameters
     */
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {

        if(!this.validateParameters(Reservation.validationParameters, parameters))
            throw new IllegalArgumentException("The included parameters were incorrect.");
        this.addressList.add(0, (Address)parameters.get(0));
        this.addressList.add(1, (Address)parameters.get(1));
        this.startDate = (Date)(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse((String)parameters.get(2)));
        this.cancellable = (Boolean)parameters.get(3);
        this.numberOfNights = (Integer)parameters.get(4);
        this.numberOfBeds = (Integer)parameters.get(5);
        this.numberOfRooms = (Integer)parameters.get(6);
        this.numberOfBaths = (Integer)parameters.get(7);
        this.lodgingSize = (Integer)parameters.get(8);
        this.cancellable = java.time.LocalDate.now().isBefore(this.startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    /*
     * Delete Object from ParseXML interface
     */
    public void deleteFileFromID(String identifierString) throws Exception {
        /*
         * Check if Reservation is Cancelleable
         * If not throw IllegalStateException
         */
        if(!this.cancellable)
            throw new IllegalStateException("Reservation is not cancellable");
        /*
        * Set status to cancelled
        */ 
        this.status = ReservationStatus.CANCELLED;
    }

    //Reservation ID getter
    public String getReservationID(){
        return this.reservationID;
    }

    @Override
    public String toString(){
        return String.format("<reservationID>%s</reservationID>\n<accountID>%s</accountID>\n<reservationStatus>%s</reservationStatus>\n<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<date>%s</date>\n<numberOfNights>%s</numberOfNights>\n<numberOfBeds>%s</numberOfBeds>\n<numberOfRooms>%s</numberOfRooms>\n<numberOfBaths>%s</numberOfBaths>\n<lodgingSize>%s</lodgingSize>", this.reservationID, this.accountID, this.status.toString(),this.addressList.get(0).toString(),this.addressList.get(1).toString(), this.startDate.toString(),String.valueOf(this.numberOfNights),String.valueOf(this.numberOfBeds), String.valueOf(this.numberOfRooms), String.valueOf(this.numberOfBaths), String.valueOf(this.lodgingSize));
    }
}
