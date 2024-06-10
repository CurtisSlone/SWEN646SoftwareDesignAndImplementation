
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
    protected boolean hasKitchenette;

    /**
     * ( numberOfBeds == 2 && numberOfRooms == 1 && numberOfBaths == 1 ) ? true : false
     */
    protected boolean isValidHotel;

    /**
     * @param accountId
     */
    public void Hotel(String accountId) {
        // TODO implement here
    }

    /**
     * @param type 
     * @param accountId
     */
    public void Hotel(ReservationType type, String accountId) {
        // TODO implement here
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

    /**
     * @param identifierString 
     * @return
     */
    public void loadObjectFromFile(String identifierString) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void saveCurrentObject() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

}