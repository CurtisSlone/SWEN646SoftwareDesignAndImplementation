
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Cabin extends Reservation {

    /**
     * Default constructor
     */
    public Cabin() {
    }

    /**
     * Bool if Cabin has full kitchen
     */
    protected boolean hasFullKitchen;

    /**
     * Bool if Cabin has lost
     */
    protected boolean hasLoft;

    /**
     * Constructor
     * super(reservationID, account, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize)
     * 
     * cabinFee =  hasFullKitchen ? ( 20 + ( 5 * numberOfRooms) ) : (5 * numberOfRooms)
     * @param accountId
     */
    public void Cabin(String accountId) {
        // TODO implement here
    }

    /**
     * @param type 
     * @param accountId
     */
    public void Cabin(ReservtionType type, String accountId) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float calculatePriceTotal() {
        // TODO implement here
        return 0.0f;
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
    public String toString() {
        // TODO implement here
        return "";
    }

}