
import java.util.*;

/**
 * @author Curtis Slone
 */
public abstract class Reservation implements ParseXML {

    /**
     * Default constructor
     */
    public Reservation() {
    }

    /**
     * Unique Reservation ID
     */
    private String reservationID;

    /**
     * Account ID associated with reservation
     */
    private String accountID;

    /**
     * 
     */
    protected String childXml;

    /**
     * Physical Address of Reservation
     */
    protected Address physicalAddress;

    /**
     * Mailing Address of Reservation
     */
    protected Address mailingAddress;

    /**
     * Reservation Status using Reservation Status Enum. Default DRAFT
     */
    protected ReservationStatus status;

    /**
     * Reservation type using ReservationType Enum
     */
    protected ReservationType type;

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
    protected int numberOfBeds;

    /**
     * Number of Rooms in Reservation
     */
    protected int numberOfRooms;

    /**
     * Number of Baths in Reservation
     */
    protected int numberOfBaths;

    /**
     * Reservation Lodging Size in SqFt
     */
    protected int lodgingSize;

    /**
     * Reservation Price Total in Dollars As Float
     */
    protected float priceTotal;

    /**
     * lodgingSize > 900 ? 120 + ((lodgingSize - 900) * 15) : 120
     */
    protected float BASEPRICE = 120;

    /**
     * @param accountId
     */
    public void Reservation(String accountId) {
        // TODO implement here
    }

    /**
     * @param type 
     * @param accountId
     */
    public void Reservation(ReservationType type, String accountId) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getReservationID() {
        // TODO implement here
        return "";
    }

    /**
     * Gets current reservation,
     *  updates fields and file
     * returns true on success
     * @return
     */
    public float calculatePriceTotal() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * Calculates Price using base price and additional fees from child classes
     * @return
     */
    public float calculateDailyPrice() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * getFullPrice / numberOfNights
     * @return getFullPrice / numberOfNights
     */
    protected float _calculateLodgingSizeFee() {
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

    /**
     * @return
     */
    public void cancelReservation() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void saveCurrentObject() {
        // TODO implement here
        return null;
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
     * @param prefix 
     * @return
     */
    public String generateUniqueID(void prefix) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public void saveCurrentObject() {
        // TODO implement here
        return null;
    }

    /**
     * @param identifierString 
     * @return
     */
    public void loadCurrentObject(String identifierString) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String generateUniqueID() {
        // TODO implement here
        return "";
    }

}