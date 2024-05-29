
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Account implements ToXML {

    /**
     * Account Constructor
     * Take Contact and Address object references as parameters
     * @param accountID 
     * @param contact 
     * @param address
     */
    public Account(String accountID, Contact contact, Address address) {
        // TODO implement here
    }

    /**
     * Unique Account ID- A followed by 9 characters
     */
    public String accountID = "-99";

    /**
     * Client Object Associated with Account
     */
    public Contact client;

    /**
     * List of reservations associated with account
     */
    public List<String> reservations;

    /**
     * Address Object  for Account
     */
    public Address address;

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    

}