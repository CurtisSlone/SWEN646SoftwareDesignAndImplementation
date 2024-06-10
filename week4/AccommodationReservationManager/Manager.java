
import java.util.*;

/**
 * Manager Class
 * @author Curtis Slone
 */
public class Manager {

    /**
     * Default constructor
     */
    public Manager() {
    }

    /**
     * List of all known accounts
     */
    private List<Account> allAccounts;

    /**
     * Reservation Listing from selected Account
     */
    private List<String> currentAccountReservations;

    /**
     * Current Account Selected
     */
    private Account currentAccount;

    /**
     * Current client object
     */
    private Contact currentClient;

    /**
     * 
     */
    private List<Addresses> currentAddresses;

    /**
     * 
     */
    private Reservation currentReservation;

    /**
     * Default Constructor takes no parameters
     */
    public void Manager() {
        // TODO implement here
    }

    /**
     * @return
     */
    private void _loadAllAccounts() {
        // TODO implement here
        return null;
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
     * @return
     */
    public String listAllAccounts() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String viewCurrentContactObject() {
        // TODO implement here
        return "";
    }

    /**
     * @param typeIdx 
     * @return
     */
    public String viewAddressObject(int typeIdx) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String viewCurrentAccountObject() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String viewCurrentReservationObject() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String viewAllCurrentAccountReservationst() {
        // TODO implement here
        return "";
    }

    /**
     * @param accountIndex 
     * @return
     */
    public void selectAccountFromAll(int accountIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param reservationIndex 
     * @return
     */
    public void selectReservationFromAll(int reservationIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param xml 
     * @return
     */
    public Contact loadCurrentContactObject(String xml) {
        // TODO implement here
        return null;
    }

    /**
     * @param xml 
     * @return
     */
    public List<Address> loadCurrentAccountAddresses(String xml) {
        // TODO implement here
        return null;
    }

    /**
     * @param parameters 
     * @return
     */
    public void updateAccount(List<Object> parameters) {
        // TODO implement here
        return null;
    }

}