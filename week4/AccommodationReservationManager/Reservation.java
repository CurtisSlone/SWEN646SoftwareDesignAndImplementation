
import java.util.*;

/**
 * @author Curtis Slone
 */
public abstract class Reservation implements ToXML {

    /**
     * Default constructor
     */
    public Reservation() {
    }

    /**
     * Account ID associated with reservation
     */
    private String reservationAccount;

    /**
     * Unique Reservation ID
     */
    private String reservationID;

    /**
     * Physical Address of Reservation
     */
    private Address physicalAddress;

    /**
     * Mailing Address of Reservation
     */
    private Address mailingAddress;

    /**
     * Start Date of Reservation
     */
    protected Date startDate;

    /**
     * Number of Nights For Reservation
     */
    protected int numberOfNights;

    /**
     * Number of Beds in Reservation
     */
    protected int numberOfBeds = 2;

    /**
     * Number of Rooms in Reservation
     */
    protected int numberOfRooms = 1;

    /**
     * Number of Baths in Reservation
     */
    protected int numberOfBaths = 1;

    /**
     * Reservation Lodging Size in SqFt
     */
    protected int lodgingSize;

    /**
     * Reservation Status using Reservation Status Enum. Default DRAFT
     */
    protected ReservationStatus reservationStatus = ReservationStatus.DRAFT;

    /**
     * Reservation Price Total in Dollars As Float
     */
    protected float priceTotal;

    /**
     * Reservation type using ReservationType Enum
     */
    private ReservationType reservationType;

    /**
     * lodgingSize > 900 ? 120 + ((lodgingSize - 900) * 15) : 120
     */
    protected float basePrice = 120;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
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
     * @param reservationID 
     * @param accountID 
     * @param startDate 
     * @param numberOfNights 
     * @param numberofBeds 
     * @param numberOfRooms 
     * @param numberOfBaths 
     * @param lodgingSize
     */
    private void Reservation(String reservationID, String accountID, String startDate, int numberOfNights, int numberofBeds, int numberOfRooms, int numberOfBaths, float lodgingSize) {
        // TODO implement here
    }

    /**
     * @param startDate 
     * @param numberOfNights 
     * @param numberOfBeds 
     * @param numberOfRooms 
     * @param numberOfBaths 
     * @param lodgingSize 
     * @param reservationStatus 
     * @return
     */
    public boolean updateReservation(Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize, ReservationStatus reservationStatus) {
        // TODO implement here
        return false;
    }

}