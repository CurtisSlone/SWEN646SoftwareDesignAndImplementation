package reservationmanager;

import java.util.Date;

public class House extends Reservation {

    protected int numberOfFloors;
    protected final ReservationType resType = ReservationType.HOUSE;

    public House( String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, int numberOfFloors){

        super(reservationID, accountID, physicalAddress, mailingAddress, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize);

        this.numberOfFloors = numberOfFloors;
        this.priceTotal = calculatePriceTotal(this.lodgingSizeFee, 0);
        
    }

    @Override
    public String toString(){
        return "";
    }
}
