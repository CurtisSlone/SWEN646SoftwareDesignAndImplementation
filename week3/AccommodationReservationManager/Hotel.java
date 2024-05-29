
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
     * METHOD OVERRIDE
     * Gets current reservation,
     * isValidHotelRoom ? update : throw Error
     *  updates fields and file
     * returns true on success
     * @param isValidHotelRoom 
     * @return
     */
    public boolean updateReservation(boolean isValidHotelRoom) {
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