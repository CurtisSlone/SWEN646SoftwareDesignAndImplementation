package reservationmanager;

import java.util.List;
 
public class Hotel extends Reservation {
    
    protected boolean hasKitchenette;
    private boolean isValidHotel;
    private float hotelFee;
    protected final ReservationType type = ReservationType.HOTEL;

    public Hotel( String reservationID, String accountID, List<Address> addresses, List<Object> reservationParameters){
        super(reservationID, accountID, addresses, reservationParameters);

        this.hasKitchenette = (boolean)reservationParameters.get(6);
        this.isValidHotel = (this.numberOfBeds == 2 && this.numberOfRooms == 1) ? true : false;
        this.hotelFee = this.hasKitchenette ? 60 : 50;
        this.priceTotal = this.calculatePriceTotal( this.lodgingSizeFee, this.hotelFee);
    }

    public boolean checkIfValidHotel(){
        return this.isValidHotel;
    }

    @Override
    public String toString(){

        return String.format("<HotelReservation>\n<isValidHotel>%s</isValidHotel>\n%s\n<hasKitchenette>%s</hasKitchenette>\n</HotelReservation>", String.valueOf(this.isValidHotel),super.toString(), String.valueOf(this.hasKitchenette)) ;
    }
}