
import java.util.*;

/**
 * Manager Class
 * @author Curtis Slone
 */
public class Manager {

    /**
     * Default Constructor takes no parameters
     */
    public void Manager() {
        // TODO implement here
    }


    /**
     * List of all known accounts
     */
    public List<Account> allAccounts;

    /**
     * Reservation Listing from selected Account
     */
    public List<Reservation> reservationListing;

    /**
     * Current Account Selected
     */
    public Account currentAccount;

    /**
     * Current client object
     */
    public Contact currentClient;

    /**
     * 
     */
    public Address currentAddress;

    /**
     * 
     */
    public Reservation currentReservation;

    /**
     * @param account Add Account
     */
    public void addAccount(Account account) {
        // TODO implement here
    }

    /**
     * Select Account using AccountID
     * @param accountID 
     * @return Returns Account by selected AccountID
     */
    public Account selectAccount(String accountID) {
        // TODO implement here
        return null;
    }

    /**
     * Selects Reservation for modification
     * @param reservationID 
     * @return
     */
    public Reservation selectReservation(String reservationID) {
        // TODO implement here
        return null;
    }

    /**
     * Return List of Reservations from Selected Account
     * @param selectedAccount 
     * @return
     */
    public List<Reservation> getAllReservations(Account selectedAccount) {
        // TODO implement here
        return null;
    }

    /**
     * Generates new client object from first name string, last name string, email string, and phone number string
     * @param firstName 
     * @param lastName 
     * @param email 
     * @param phoneNumber 
     * @return
     */
    public Contact generateNewContact(String firstName, String lastName, String email, String phoneNumber) {
        // TODO implement here
        return null;
    }

    /**
     * @param street1 
     * @param street2 
     * @param city 
     * @param state 
     * @param zip 
     * @return
     */
    public Address generateNewAddress(String street1, String street2, String city, String state, String zip) {
        // TODO implement here
        return null;
    }

    /**
     * Generates new account number, validates that Account ID is unique,  generates Account directory with account file
     * @param newContact 
     * @param clientAddress 
     * @return returns true if successful, returns false if fail
     */
    public boolean generateNewAccount(Contact newContact, Address clientAddress) {
        // TODO implement here
        return false;
    }

    /**
     * Gets current Account, generates new reservationID, filename and attributes
     * @return
     */
    public boolean generateNewReservation() {
        // TODO implement here
        return false;
    }

    
}