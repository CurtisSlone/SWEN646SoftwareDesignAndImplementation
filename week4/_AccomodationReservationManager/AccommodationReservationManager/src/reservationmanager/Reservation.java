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

    public Reservation(String reservationID, String accountID, List<Address> addresses, List<Object> reservationParameters){
        this.reservationID = reservationID;
        this.accountID = accountID;
        this.physicalAddress = addresses.get(0);
        this.mailingAddress = addresses.get(1);
        this.startDate = (Date)reservationParameters.get(0);
        this.numberOfNights = (Integer)reservationParameters.get(1);
        this.numberOfBeds = (Integer)reservationParameters.get(2);
        this.numberOfRooms = (Integer)reservationParameters.get(3);
        this.numberOfBaths = (Integer)reservationParameters.get(4);
        this.lodgingSize = (Integer)reservationParameters.get(5);
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
        return String.format("<reservationID>%s</reservationID>\n<accountID>%s</accountID>\n<reservationStatus>%s</reservationStatus>\n<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<date>%s</date>\n<numberOfNights>%s</numberOfNights>\n<numberOfBeds>%s</numberOfBeds>\n<numberOfRooms>%s</numberOfRooms>\n<numberOfBaths>%s</numberOfBaths>\n<lodgingSize>%s</lodgingSize>", this.reservationID, this.accountID, this.status.toString(),this.physicalAddress.toString(), this.mailingAddress.toString(), this.startDate.toString(),String.valueOf(this.numberOfNights),String.valueOf(this.numberOfBeds), String.valueOf(this.numberOfRooms), String.valueOf(this.numberOfBaths), String.valueOf(this.lodgingSize));
    }
}