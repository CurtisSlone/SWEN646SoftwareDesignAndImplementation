
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Hotel extends Reservation {

    /**
     * Default constructor
     */
    public Hotel() {
    }

    /**
     * Bool if Hotel as Kitchenette
     */
    public boolean hasKitchenette;

    /**
     * hasKitchenette ? 60.00 : 50.00
     */
    public float hotelFee;

    /**
     * ( numberOfBeds == 2 && numberOfRooms == 1 && numberOfBaths == 1 ) ? true : false
     */
    public boolean isValidHotelRoom;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * METHOD OVERLOAD
     * Gets current reservation,
     * isValidHotelRoom ? update : throw Error
     *  updates fields and file
     * returns true on success
     * @return
     */
    public boolean updateReservation() {
        // TODO implement here
        return false;
    }

}