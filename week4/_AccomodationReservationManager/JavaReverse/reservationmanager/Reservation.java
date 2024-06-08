package reservationmanager;

import java.util.*;

/**
 * 
 */
public abstract class Reservation {

    /**
     * Default constructor
     */
    public Reservation() {
    }

    /**
     * 
     */
    private String reservationID;

    /**
     * 
     */
    private String accountID;

    /**
     * 
     */
    protected Date startDate;

    /**
     * 
     */
    protected int numberOfNights;

    /**
     * 
     */
    protected int numberOfBeds;

    /**
     * 
     */
    protected int numberOfRooms;

    /**
     * 
     */
    protected int numberOfBaths;

    /**
     * 
     */
    private int lodgingSize;

    /**
     * 
     */
    protected float lodgingSizeFee;

    /**
     * 
     */
    protected float priceTotal;

    /**
     * 
     */
    protected final float BASEPRICE = 120;

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
     */
    public void Reservation(String reservationID, String accountID, Address physicalAddress, Address mailingAddress, Date startDate, int numberOfNights, int numberOfBeds, int numberOfRooms, int numberOfBaths, int lodgingSize) {
        // TODO implement here
    }

    /**
     * @param lodgingSizeFee 
     * @param reservationTypeFee 
     * @return
     */
    public float calculatePriceTotal(float lodgingSizeFee, float reservationTypeFee) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param newSize 
     * @return
     */
    public String updateLodgingSize(int newSize) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getLodgingSize() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    private float _calculateLodgingSizeFee() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public String getAcountID() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getReservationID() {
        // TODO implement here
        return "";
    }

}