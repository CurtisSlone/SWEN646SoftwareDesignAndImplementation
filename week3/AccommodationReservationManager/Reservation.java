
import java.util.*;

/**
 * @author Curtis Slone
 */
public abstract class Reservation {

    /**
     * @param reservationID 
     * @param account 
     * @param startDate 
     * @param numberOfNights 
     * @param numberofBeds 
     * @param numberOfRooms 
     * @param numberOfBaths 
     * @param lodgingSize
     */
    public void Reservation(String reservationID, Account account, String startDate, int numberOfNights, int numberofBeds, int numberOfRooms, int numberOfBaths, float lodgingSize) {
        // TODO implement here
    }

    /**
     * Account ID associated with reservation
     */
    public String reservationAccount;

    /**
     * Unique Reservation ID
     */
    public String reservationID;

    /**
     * Physical Address of Reservation
     */
    public Address physicalAddress;

    /**
     * Mailing Address of Reservation
     */
    public Address mailingAddress;

    /**
     * Start Date of Reservation
     */
    public Date startDate;

    /**
     * Number of Nights For Reservation
     */
    public int numberOfNights;

    /**
     * Number of Beds in Reservation
     */
    public int numberOfBeds = 2;

    /**
     * Number of Rooms in Reservation
     */
    public int numberOfRooms = 1;

    /**
     * Number of Baths in Reservation
     */
    public int numberOfBaths = 1;

    /**
     * Reservation Lodging Size in SqFt
     */
    public int lodgingSize;

    /**
     * Reservation Status using Reservation Status Enum. Default DRAFT
     */
    public ReservationStatus reservationStatus = ReservationStatus.DRAFT;

    /**
     * Reservation Price Total in Dollars As Float
     */
    public float priceTotal;

    /**
     * Reservation type using ReservationType Enum
     */
    private ReservationType reservationType;

    /**
     * lodgingSize > 900 ? 120 + ((lodgingSize - 900) * 15) : 120
     */
    public float basePrice = 120;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * Gets current reservation,
     *  updates fields and file
     * returns true on success
     * @return
     */
    public boolean updateReservation() {
        // TODO implement here
        return false;
    }

    /**
     * Calculates Price using base price and additional fees from child classes
     * @param basePrice 
     * @param additionalFees 
     * @return
     */
    public float getFullPrice(float basePrice, float additionalFees) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * getFullPrice / numberOfNights
     * @return getFullPrice / numberOfNights
     */
    public float getDailyPrice() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return creates reservation file
     */
    public boolean createReservation() {
        // TODO implement here
        return false;
    }

    

}