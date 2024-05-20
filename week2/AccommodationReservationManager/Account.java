
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Account {

    /**
     * Default constructor
     */
    public Account() {
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
    public List<Reservation> reservations;

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

    /**
     * creates Account Directory and file
     * @return
     */
    public boolean createAccount() {
        // TODO implement here
        return false;
    }

}