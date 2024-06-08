package reservationmanager;

import java.util.Date;
import java.util.List;

public abstract class Reservation {
    private String reservationID;
    private String accountID;
    protected Address physicalAddress;
    protected Address mailingAddress;
    protected Date startDate;
    protected int numberOfNights;
    protected int numberOfBeds;
    protected int numberOfRooms;
    protected int numberOfBaths;
    private int lodgingSize;
    protected float lodgingSizeFee;
    protected ReservationStatus status;
    protected float priceTotal;
    protected final float BASEPRICE = 120;

    public Reservation(String reservationID, String accountID, List<Address> addresses, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize){
        this.reservationID = reservationID;
        this.accountID = accountID;
        this.startDate = startDate;
        this.physicalAddress = addresses.get(0);
        this.mailingAddress = addresses.get(1);
        this.numberOfNights = numberOfNights;
        this.numberOfBeds = numberOfBeds;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBaths = numberOfBaths;
        this.lodgingSize = lodgingSize;
        this.lodgingSizeFee = this._calculateLodgingSizeFee();
        this.status = ReservationStatus.DRAFT;
    }

    public float calculatePriceTotal(float lodgingSizeFee, float reservationTypeFee){
        
        return this.BASEPRICE + lodgingSizeFee + reservationTypeFee;
    };

    public void updateLodgingSize(int newSize) throws Exception {
            
        this.lodgingSize = newSize;
        this.lodgingSizeFee = this._calculateLodgingSizeFee();
    }

    public int getLodgingSize(){
        return this.lodgingSize;
    }

    private float _calculateLodgingSizeFee(){
        return this.lodgingSize > 900 ? (this.lodgingSize - 900 ) * 15 : 0;
    }

    public String getAccountID(){
        return this.accountID;
    }

    public String getReservationID(){
        return this.reservationID;
    }

    @Override
    public String toString(){
        return String.format("\n<reservationID>%s</reservationID>\n<accountID>%s</accountID>\n<reservationStatus>%s</reservationStatus>\n<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%</MailingAddress>\n<date>%s</date>\n<numberOfNights>%s</numberOfNights>\n<numberOfBeds>%s</numberOfBeds>\n<numberOfRooms>%s</numberOfRooms>\n<numberOfBaths>%s</numberOfBaths>\n<lodgingSize>%s</lodgingSize>\n", this.reservationID, this.accountID, this.status.toString(),this.physicalAddress.toString(), this.mailingAddress.toString(), this.startDate.toString(),String.valueOf(this.numberOfNights),String.valueOf(this.numberOfBeds), String.valueOf(this.numberOfRooms), String.valueOf(this.numberOfBaths), String.valueOf(this.lodgingSize));
    }
}