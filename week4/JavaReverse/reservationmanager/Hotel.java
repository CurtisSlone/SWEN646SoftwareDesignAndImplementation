package reservationmanager;

import java.util.*;

/**
 * 
 */
public class Hotel extends Reservation {

    /**
     * Default constructor
     */
    public Hotel() {
    }

    /**
     * 
     */
    protected boolean hasKitchenette;

    /**
     * 
     */
    private boolean isValidHotel;

    /**
     * 
     */
    private float hotelFee;

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
     * @param hasKitchenette
     */
    public void Hotel(String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, boolean hasKitchenette) {
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