package reservationmanager;

import java.util.Date;
import java.util.List;

public class House extends Reservation {

    protected int numberOfFloors;
    protected final ReservationType resType = ReservationType.HOUSE;

    public House( String reservationID, String accountID, List<Address> addresses, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, int numberOfFloors){

        super(reservationID, accountID, addresses, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize);

        this.numberOfFloors = numberOfFloors;
        this.priceTotal = calculatePriceTotal(this.lodgingSizeFee, 0);
        
    }

    @Override
    public String toString(){
        return "";
    }
}