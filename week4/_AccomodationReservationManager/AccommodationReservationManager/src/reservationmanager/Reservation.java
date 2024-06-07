package reservationmanager;

import java.util.Date;

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

    public Reservation(String reservationID, String accountID, Address physicalAddress, Address mailingAddress ,Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize){
        this.reservationID = reservationID;
        this.accountID = accountID;
        this.startDate = startDate;
        this.physicalAddress = physicalAddress;
        this.mailingAddress = mailingAddress;
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

    public String updateLodgingSize(int newSize){
        String msg = "";
        try {
            this.lodgingSize = newSize;
            this.lodgingSizeFee = this._calculateLodgingSizeFee();
            msg = "Lodging size update successful!";
        } catch (Exception e) {
            msg = e.toString();
        }
        
        return msg;
    }

    public int getLodgingSize(){
        return this.lodgingSize;
    }

    private float _calculateLodgingSizeFee(){
        return this.lodgingSize > 900 ? (this.lodgingSize - 900 ) * 15 : 0;
    }

    public String getAcountID(){
        return this.accountID;
    }

    public String getReservationID(){
        return this.reservationID;
    }

}
