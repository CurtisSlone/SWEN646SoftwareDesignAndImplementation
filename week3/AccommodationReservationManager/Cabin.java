
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Cabin extends Reservation implements ToXML {

    /**
     * Default constructor
     */
    public Cabin() {
    }

    /**
     * Bool if Cabin has full kitchen
     */
    public boolean hasFullKitchen;

    /**
     * Bool if Cabin has lost
     */
    public boolean hasLoft;

    /**
     * hasFullKitchen ? ( 20 + ( 5 * numberOfRooms) ) : (5 * numberOfRooms)
     */
    public float cabinFee;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * Constructor
     * super(reservationID, account, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize)
     * 
     * cabinFee =  hasFullKitchen ? ( 20 + ( 5 * numberOfRooms) ) : (5 * numberOfRooms)
     * @param hasFullKitchen 
     * @param hasLoft
     */
    public void Cabin(void hasFullKitchen, boolean hasLoft) {
        // TODO implement here
    }

}