package reservationmanager;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Manager {

    private List<String> allAccounts;
    private List<String> currentAccountReservations;
    private Account currentAccount;
    private Contact currentContact;
    private Map<String,Address> currentAddressMap;
    private Reservation currentReservation;

    public Manager(){
        this.allAccounts = this._loadAllAccounts();
        this.currentAddressMap = new HashMap<String,Address>();
        currentAddressMap.put("PhysicalAddress", null);
        currentAddressMap.put("MailingAddress", null);

    }

    private List<String> _loadAllAccounts(){
        /*
         * Instantiate new ArrayList
         * Get all directory names as Account IDs as String
         * add name as String to ArrayList
         */
        return new ArrayList<String>();
    }

    public String loadAllReservatonsFromAccount(){
        String msg = "";
        /*
         * this.currentAccount.getAccountReservations() = this.currentAccountReservations
         * change msg based on success or error
         */
        return msg;
    }

    private boolean _isCurrentAccountSaved(){
        boolean isSaved = false;
        /*
         * Get accountID from currentAccount Account Object if accountID 
         * if -99, return true
         * Check if accountID is in allAccounts ArrayList
         * change isSaved value
         */
        return isSaved;
    }


    public String saveCurrentAccount(){
        String msg = "";

        /* Check if currentAccount ID is in allAccounts ArrayList and accountID != -99
         *  If not new, update deltas,
         * If new, create directory and file
         * change msg based on success or error
         */
        return msg;

    }

    public String saveCurrentReservation(){
        String msg = "";
        /* Find reservation file by ID
         * Update Deltas
        */
        return msg;
    }

    public String loadAccount(String accountID){
        String msg = "";
        /* Find account based on account ID
         * Open account file, load parse xml
         * currentContact = new Contact(Parameters from XML)
         * addressMap.put("PhysicalAddress", new Address(Parameters from XML))
         * addressMap.put("MailingAddress", new Address(Parameters from XML))
         * currentAccount = new Account(Parameters from XML, currentContact,currentAddressMap )
         * reset currentAddressMap values to null
         * change msg based on success or error
         */

        return msg;

    }

    public String loadReservation(String reservationID){
        String msg = "";
        /* Find account based on account ID
         * Open account file, load parse xml
         * currentContact = new Contact(Parameters from XML)
         * addressMap.put("PhysicalAddress", new Address(Parameters from XML))
         * addressMap.put("MailingAddress", new Address(Parameters from XML))
         * currentAccount = new Account(Parameters from XML, currentContact,currentAddressMap )
         * change msg based on success or error
         */

        return msg;

    }

    private String _generateNewAccountID(){
        /*
         * 
         */
        return "";
    }

    private String _generateNewReservationID(){
        /*
         * 
         */
        return "";
    }

    public String loadAddressForEdit( String id ){
        String msg = "";
        /*
         * 
         */
        return msg;
    }

    public String loadContactForEdit(){
        String msg = "";
        /*
         * Get contact from current account object
         *  
         */
        return msg;
    }

    public String saveAddress(String id, String addressType ){
        String msg = "";
        /*
         * 
         */
        return msg;
    }


}
