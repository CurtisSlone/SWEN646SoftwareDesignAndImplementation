
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Account implements ParseXML {

    /**
     * Default constructor
     */
    public Account() {
    }

    /**
     * Unique Account ID- A followed by 9 characters
     */
    private String acctId;

    /**
     * Client Object Associated with Account
     */
    protected Contact actClient;

    /**
     * Address Object  for Account
     */
    public Address physicalAddress;

    /**
     * 
     */
    protected Address mailingAddress;

    /**
     * List of reservations associated with account
     */
    protected List<String> acctReservations;

    /**
     * 
     */
    public void Account() {
        // TODO implement here
    }

    /**
     * Account Constructor
     * Take Contact and Address object references as parameters
     * @param parameters
     */
    public void Account(List<Object> parameters) {
        // TODO implement here
    }

    /**
     * @return
     */
    protected String getAccountId() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    protected List<String> getAccountReservations() {
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
    public String generateUniqueID(String prefix) {
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