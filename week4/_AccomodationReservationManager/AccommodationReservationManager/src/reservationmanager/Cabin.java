package reservationmanager;

import java.util.Date;

public class Cabin extends Reservation {
    protected boolean hasFullKitchen;
    protected boolean hasLoft;
    private float cabinFee;
    protected final ReservationType type = ReservationType.CABIN;

    public Cabin( String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, boolean hasFullKitchen, boolean hasLoft){

        super(reservationID, accountID, physicalAddress, mailingAddress, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize);

        this.hasFullKitchen = hasFullKitchen;
        this.hasLoft = hasLoft;
        this.cabinFee = this.hasFullKitchen ? (20 + (5 * this.numberOfRooms)) : (5 * this.numberOfRooms);
        this.priceTotal = this.calculatePriceTotal(this.lodgingSizeFee, this.cabinFee);
    }
    

    @Override
    public String toString(){

        return "";
    }
}
