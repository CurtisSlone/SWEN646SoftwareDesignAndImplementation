package reservationmanager;

import java.util.*;

/**
 * 
 */
public class Manager {

    /**
     * Default constructor
     */
    public Manager() {
    }

    /**
     * 
     */
    private Set<String> allAccounts;

    /**
     * 
     */
    private Set<String> currentAccountReservations;

    /**
     * 
     */
    private Map currentAddressMap;

    /**
     * 
     */
    public void Manager() {
        // TODO implement here
    }

    /**
     * @return
     */
    private Set<String> _loadAllAccounts() {
        // TODO implement here
        return null;
    }

    /**
     * Instantiate new ArrayList
     * Get all directory names as Account IDs as String
     * add name as String to ArrayList
     * @return
     */
    public String loadAllReservatonsFromAccount() {
        // TODO implement here
        return "";
    }

    /**
     * this.currentAccount.getAccountReservations() = this.currentAccountReservations
     * change msg based on success or error
     * @return
     */
    private boolean _isCurrentAccountSaved() {
        // TODO implement here
        return false;
    }

    /**
     * Get accountID from currentAccount Account Object if accountID
     * if -99, return true
     * Check if accountID is in allAccounts ArrayList
     * change isSaved value
     * @return
     */
    public String saveCurrentAccount() {
        // TODO implement here
        return "";
    }

    /**
     * Check if currentAccount ID is in allAccounts ArrayList and accountID != -99
     * If not new, update deltas,
     * If new, create directory and file
     * change msg based on success or error
     * @return
     */
    public String saveCurrentReservation() {
        // TODO implement here
        return "";
    }

    /**
     * Find reservation file by ID
     * Update Deltas
     * @param accountID 
     * @return
     */
    public String loadAccount(String accountID) {
        // TODO implement here
        return "";
    }

    /**
     * Find account based on account ID
     * Open account file, load parse xml
     * currentContact = new Contact(Parameters from XML)
     * addressMap.put("PhysicalAddress", new Address(Parameters from XML))
     * addressMap.put("MailingAddress", new Address(Parameters from XML))
     * currentAccount = new Account(Parameters from XML, currentContact,currentAddressMap )
     * reset currentAddressMap values to null
     * change msg based on success or error
     * @param reservationID 
     * @return
     */
    public String loadReservation(String reservationID) {
        // TODO implement here
        return "";
    }

    /**
     * Find account based on account ID
     * Open account file, load parse xml
     * currentContact = new Contact(Parameters from XML)
     * addressMap.put("PhysicalAddress", new Address(Parameters from XML))
     * addressMap.put("MailingAddress", new Address(Parameters from XML))
     * currentAccount = new Account(Parameters from XML, currentContact,currentAddressMap )
     * change msg based on success or error
     * @return
     */
    private String _generateNewAccountID() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    private String _generateNewReservationID() {
        // TODO implement here
        return "";
    }

    /**
     * @param id 
     * @return
     */
    public String loadAddressForEdit(String id) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String loadContactForEdit() {
        // TODO implement here
        return "";
    }

    /**
     * Get contact from current account object
     * @param id 
     * @param addressType 
     * @return
     */
    public String saveAddress(String id, String addressType) {
        // TODO implement here
        return "";
    }

    /**
     * @param AccountId 
     * @return
     */
    public String saveContact(String AccountId) {
        // TODO implement here
        return "";
    }

}