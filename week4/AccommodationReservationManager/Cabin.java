
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
    protected boolean hasFullKitchen;

    /**
     * Bool if Cabin has lost
     */
    protected boolean hasLoft;

    /**
     * hasFullKitchen ? ( 20 + ( 5 * numberOfRooms) ) : (5 * numberOfRooms)
     */
    protected float cabinFee;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * Method Overload
     * super( Reservation Parameters, )
     * @param startDate 
     * @param numberOfNights 
     * @param numberOfBeds 
     * @param numberOfRooms 
     * @param numberOfBaths 
     * @param lodgingSize 
     * @param reservationStatus 
     * @param hasFullKitchen 
     * @param hasLoft 
     * @return
     */
    public boolean updateReservation(Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, ReservationStatus reservationStatus, boolean hasFullKitchen, boolean hasLoft) {
        // TODO implement here
        return false;
    }

    /**
     * Constructor
     * super(reservationID, account, startDate, numberOfNights, numberOfBeds, numberOfRooms, numberOfBaths, lodgingSize)
     * 
     * cabinFee =  hasFullKitchen ? ( 20 + ( 5 * numberOfRooms) ) : (5 * numberOfRooms)
     * @param hasFullKitchen 
     * @param hasLoft
     */
    public void Cabin(boolean hasFullKitchen, boolean hasLoft) {
        // TODO implement here
    }

}