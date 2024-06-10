package reservationmanager;

import java.util.List;

public class Cabin extends Reservation {
    protected boolean hasFullKitchen;
    protected boolean hasLoft;
    private float cabinFee;

    public Cabin( ReservationType type, String accountID, List<Address> addresses, List<Object> reservationParameters){

        super(type, accountID, addresses, reservationParameters);

        this.hasFullKitchen = (boolean)reservationParameters.get(6);
        this.hasLoft = (boolean)reservationParameters.get(7);
        this.cabinFee = this.hasFullKitchen ? (20 + (5 * this.numberOfRooms)) : (5 * this.numberOfRooms);
        this.priceTotal = this.calculatePriceTotal(this.lodgingSizeFee, this.cabinFee);
    }
    

    @Override
    public String toString(){

        return String.format("<CabinReservation>\n%s\n<hasFullKitchen>%s</hasFullKitchen>\n<hasLoft>%s</hasLoft>\n</Cabinreservation>", super.toString(), String.valueOf(this.hasFullKitchen), String.valueOf(this.hasLoft));
    }
}