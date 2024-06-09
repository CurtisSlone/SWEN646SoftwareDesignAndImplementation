package reservationmanager;

import java.util.*;

/**
 * 
 */
public class House extends Reservation {

    /**
     * Default constructor
     */
    public House() {
    }

    /**
     * 
     */
    protected int numberOfFloors;

    /**
     * @param reservationID 
     * @param accountID 
     * @param physicalAddress 
     * @param mailingAddress 
     * @param startDate 
     * @param numberOfNights 
     * @param numberOfBeds 
     * @param numberOfRooms 
     * @param numberOfBaths 
     * @param lodgingSize 
     * @param numberOfFloors
     */
    public void House(String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, int numberOfFloors) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

}