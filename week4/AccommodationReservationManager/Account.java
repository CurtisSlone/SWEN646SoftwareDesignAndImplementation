
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Account implements ToXML {

    /**
     * Default constructor
     */
    public Account() {
    }

    /**
     * Unique Account ID- A followed by 9 characters
     */
    private String accountID = "-99";

    /**
     * Client Object Associated with Account
     */
    private Contact client;

    /**
     * List of reservations associated with account
     */
    private List<String> reservations;

    /**
     * Address Object  for Account
     */
    private Address address;

    /**
     * Account Constructor
     * Take Contact and Address object references as parameters
     * @param accountID 
     * @param contact 
     * @param address
     */
    public void Account(String accountID, Contact contact, Address address) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * Adds string to List<String> of reservations
     * @param reservationFileName 
     * @return
     */
    public void addReservation(String reservationFileName) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getAccountId() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Contact getClientInformation() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<String> getAllReservations() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Address getAccountAddress() {
        // TODO implement here
        return null;
    }

}