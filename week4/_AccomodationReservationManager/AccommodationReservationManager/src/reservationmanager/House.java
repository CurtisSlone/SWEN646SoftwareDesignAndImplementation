package reservationmanager;

import java.util.List;

public class House extends Reservation {

    protected int numberOfFloors;
    protected final ReservationType resType = ReservationType.HOUSE;

    public House( ReservationType type, String accountID, List<Address> addresses, List<Object> reservationParameters){
        super(type, accountID, addresses,reservationParameters);

        this.numberOfFloors = (Integer)reservationParameters.get(6);
        this.priceTotal = calculatePriceTotal(this.lodgingSizeFee, 0);
        
    }
 
    @Override
    public String toString(){
        return String.format("<HotelReservation>\n%s\n<numberOfFloors>%s</numberOfFloors>\n</HotelReservation>\n", super.toString(), String.valueOf(this.numberOfFloors));
    }
}
