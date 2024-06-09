package reservationmanager;

import java.util.*;

/**
 * 
 */
public class Cabin extends Reservation {

    /**
     * Default constructor
     */
    public Cabin() {
    }

    /**
     * 
     */
    protected boolean hasFullKitchen;

    /**
     * 
     */
    protected boolean hasLoft;

    /**
     * 
     */
    private float cabinFee;

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
     * @param hasFullKitchen 
     * @param hasLoft
     */
    public void Cabin(String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, boolean hasFullKitchen, boolean hasLoft) {
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