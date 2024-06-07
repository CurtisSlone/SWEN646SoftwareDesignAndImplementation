
import java.util.*;

/**
 * @author Curtis Slone
 */
public class House extends Reservation implements ToXML, ToXML {

    /**
     * Default constructor
     */
    public House() {
    }

    /**
     * Number of Floors in House
     */
    protected int numberOfFloors;

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
     * @param numberOfFloors
     */
    public void House(int numberOfFloors) {
        // TODO implement here
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
     * @param numberOfFloors 
     * @return
     */
    public boolean updateReservation(Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, ReservationStatus reservationStatus, int numberOfFloors) {
        // TODO implement here
        return false;
    }

}