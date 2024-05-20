
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

}