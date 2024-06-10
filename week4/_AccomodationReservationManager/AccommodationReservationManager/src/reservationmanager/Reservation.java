package reservationmanager;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class Reservation implements ParseXML {
    private String reservationID;
    private String accountID;
    protected String childXml;
    protected Address physicalAddress;
    protected Address mailingAddress;
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

    public Reservation(String accountId){ 
        this.accountID = accountId;
        this.numberOfBeds = 2;
        this.numberOfRooms = 1;
        this.status = ReservationStatus.DRAFT;
    }

    public Reservation(ReservationType type, String accountID){
        this.reservationID = type == ReservationType.HOTEL ? this.generateUniqueID("HOT") : type == ReservationType.HOUSE ? this.generateUniqueID("HOU") : this.generateUniqueID("CAB");
        this.accountID = accountID;
        this.numberOfBeds = 2;
        this.numberOfRooms = 1;
        this.status = ReservationStatus.DRAFT;
    }

    public float calculatePriceTotal(float reservationTypeFee){
        
        return this.BASEPRICE + this._calculateLodgingSizeFee() + reservationTypeFee;
    };

    private float _calculateLodgingSizeFee(){
        return this.lodgingSize > 900 ? (this.lodgingSize - 900 ) * 15 : 0;
    }
    
    public void saveCurrentObject() throws Exception{

        String reservationDir = String.format("./accounts/%s",this.accountID);
        String reservationFileName = String.format("%s/res-%s.xml", reservationDir, this.reservationID);
        char foutReservationInfo[] = this.toString().toCharArray();
        try {
            
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

    public void loadObjectFromFile(String identifierString) throws Exception{
        String hotelTypePattern = "^HOT.*";
        String houseTypePattern = "^HOU.*";
        String cabinTypePattern = "^CAB.*";
        List<Object> parameters = new ArrayList<Object>();
        List<Address> addresses = new ArrayList<Address>();
        try {
            if( identifierString.matches(hotelTypePattern)){
                this.type = ReservationType.HOTEL;
    
            } else if(identifierString.matches(houseTypePattern)){
                this.type = ReservationType.HOUSE;
    
            } else if(identifierString.matches(cabinTypePattern)){
                this.type = ReservationType.CABIN;
    
            } else {
                throw new Exception();
            }
            
            String reservationFile = String.format("./accounts/%s/res-%s.xml", this.accountID, identifierString);

            String reservationXmlAsString = new String(Files.readAllBytes(Paths.get(reservationFile)));

            String status = reservationXmlAsString.substring(reservationXmlAsString.indexOf("<reservationStatus>") + 19, reservationXmlAsString.indexOf("</reservationStatus>"));

            switch(status){
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

            String accountAddresses[] = {
                reservationXmlAsString.substring(reservationXmlAsString.indexOf("<PhysicalAddress>") + 17, reservationXmlAsString.indexOf("</PhysicalAddress")),
                reservationXmlAsString.substring(reservationXmlAsString.indexOf("<MailingAddress>") + 16, reservationXmlAsString.indexOf("</MailingAddress")),
            };

            for( String address : accountAddresses){
                parameters.add(address.substring(address.indexOf("<street1>") + 9, address.indexOf("</street1>")));
                
                parameters.add(address.substring(address.indexOf("<street2>") + 9, address.indexOf("</street2>")));
                
                parameters.add(address.substring(address.indexOf("<city>") + 6, address.indexOf("</city>")));
                parameters.add(address.substring(address.indexOf("<state>") + 7, address.indexOf("</state>")));
                parameters.add(address.substring(address.indexOf("<zip>") + 5, address.indexOf("</zip>")));
                
                addresses.add(new Address(parameters));
                parameters.clear();
            }

            this.physicalAddress = addresses.get(0);
            this.mailingAddress = addresses.get(1);
            addresses = null;

            this.startDate = (Date)(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<date>") + 6, reservationXmlAsString.indexOf("</date>"))));

            this.numberOfNights = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfNights>") + 16, reservationXmlAsString.indexOf("</numberOfNights>")));

            this.numberOfBeds = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfBeds>") + 14, reservationXmlAsString.indexOf("</numberOfBeds>")));

            this.numberOfRooms = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfRooms>") + 15, reservationXmlAsString.indexOf("</numberOfRooms>")));

            this.numberOfBaths  = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<numberOfBaths>") + 15, reservationXmlAsString.indexOf("</numberOfBaths>")));

            this.lodgingSize = Integer.valueOf(reservationXmlAsString.substring(reservationXmlAsString.indexOf("<lodgingSize>") + 13, reservationXmlAsString.indexOf("</lodgingSize>")));

            this.childXml = reservationXmlAsString.substring(reservationXmlAsString.indexOf("</lodgingSize>") + 14, reservationXmlAsString.length() - 1);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    public String generateUniqueID(String prefix){
        
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s%s",prefix,random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(10)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };

    public String getReservationID(){
        return this.reservationID;
    }

    @Override
    public String toString(){
        return String.format("<reservationID>%s</reservationID>\n<accountID>%s</accountID>\n<reservationStatus>%s</reservationStatus>\n<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<date>%s</date>\n<numberOfNights>%s</numberOfNights>\n<numberOfBeds>%s</numberOfBeds>\n<numberOfRooms>%s</numberOfRooms>\n<numberOfBaths>%s</numberOfBaths>\n<lodgingSize>%s</lodgingSize>", this.reservationID, this.accountID, this.status.toString(),this.physicalAddress.toString(), this.mailingAddress.toString(), this.startDate.toString(),String.valueOf(this.numberOfNights),String.valueOf(this.numberOfBeds), String.valueOf(this.numberOfRooms), String.valueOf(this.numberOfBaths), String.valueOf(this.lodgingSize));
    }
}
