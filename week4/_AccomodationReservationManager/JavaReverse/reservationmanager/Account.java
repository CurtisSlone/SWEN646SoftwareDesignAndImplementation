package reservationmanager;

import java.util.*;

/**
 * 
 */
public class Account {

    /**
     * Default constructor
     */
    public Account() {
    }

    /**
     * 
     */
    private String acctID;

    /**
     * 
     */
    protected Map acctAddresses;

    /**
     * 
     */
    private Set<String> acctReservations;

    /**
     * @param accountID 
     * @param client 
     * @param addresses
     */
    public void Account(String accountID, Contact client, Map addresses) {
        // TODO implement here
    }

    /**
     * @return
     */
    private Set<String> _loadReservations() {
        // TODO implement here
        return null;
    }

    /**
     * create new ArrayList<String>
     * enumerate filenames in account directory if this.acctID != -99
     * add filenames as reservation IDs to ArrayList<String>
     * @return
     */
    public String getAccountId() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Set<String> getAccountReservations() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

}