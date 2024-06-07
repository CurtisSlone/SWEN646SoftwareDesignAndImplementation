
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Hotel extends Reservation implements ToXML {

    /**
     * Default constructor
     */
    public Hotel() {
    }

    /**
     * Bool if Hotel as Kitchenette
     */
    protected boolean hasKitchenette;

    /**
     * hasKitchenette ? 60.00 : 50.00
     */
    protected float hotelFee;

    /**
     * ( numberOfBeds == 2 && numberOfRooms == 1 && numberOfBaths == 1 ) ? true : false
     */
    protected boolean isValidHotelRoom;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * Method Overload
     * super( Reservation Parameters)
     * @param startDate 
     * @param numberOfNights 
     * @param numberOfBeds 
     * @param numberOfRooms 
     * @param numberOfBaths 
     * @param lodgingSize 
     * @param reservationStatus 
     * @param hasKitchenette 
     * @param isValidHotelRoom 
     * @return
     */
    public boolean updateReservation(Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, ReservationStatus reservationStatus, boolean hasKitchenette, boolean isValidHotelRoom) {
        // TODO implement here
        return false;
    }

    /**
     * Constructor
     * super(reservationID, account, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize)
     * 
     * hotelFee = hasKitchenette ? 60.00 : 50.00
     * @param hasKitchenette
     */
    public void Hotel(boolean hasKitchenette) {
        // TODO implement here
    }

}