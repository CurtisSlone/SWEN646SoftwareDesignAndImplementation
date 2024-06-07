package reservationmanager;

import java.util.Date;
 
public class Hotel extends Reservation {
    
    protected boolean hasKitchenette;
    private boolean isValidHotel;
    private float hotelFee;
    protected final ReservationType type = ReservationType.HOTEL;

    public Hotel( String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, boolean hasKitchenette){

        super(reservationID, accountID, physicalAddress, mailingAddress, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize);

        this.isValidHotel = (this.numberOfBeds == 2 && this.numberOfRooms == 1) ? true : false;
        
        this.hasKitchenette = hasKitchenette;
        this.hotelFee = this.hasKitchenette ? 60 : 50;
        this.priceTotal = this.calculatePriceTotal( this.lodgingSizeFee, this.hotelFee);
    }

    @Override
    public String toString(){

        return this.isValidHotel ? "" : "";
    }
}
