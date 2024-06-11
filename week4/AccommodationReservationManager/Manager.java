
import java.io.IOException;
import java.util.*;

/**
 * Manager Class
 * @author Curtis Slone
 */
public class Manager {

    private List<String> allAccounts; //List of all known accounts
    private List<String> currentAccountReservations; // Current Account Selected
    private Account currentAccount; // Current Account Selected 
    private Contact currentContact; // Current Account Contact
    private List<Address> currentAddresses; // Current Account addresses
    private Reservation currentReservation; // Current Resrvation Selected
    /**
     * Default constructor
     */
    public Manager() throws Exception {
        /*
         
            this._loadAllAccounts();
            this.currentAddresses = new ArrayList<Address>();
            this.currentAccountReservations = new ArrayList<String>();

        */
    }

    /**
     * @return
     */
    private void _loadAllAccounts() throws IOException {
        /*
         Instantiate new ArrayList
         Get all directory names as Account IDs as String
         add name as String to ArrayList

            this.allAccounts = new ArrayList<String>();

            // Interface this out
            String accounts[];
            File accountsDir = new File("./accounts");
            if(!accountsDir.exists())
                accountsDir.mkdir();
            accounts = accountsDir.list();
            if(accounts.length != 0)
                for(String account : accounts)
                    this.allAccounts.add(account);
        */
    }

    public String listAllAccounts(){
        return this.allAccounts.toString();
    }

    public String viewCurrentContactObject(){
        return this.currentContact.toString();
    }
    
    public String viewAddressObject(int typeIdx){
        return this.currentAddresses.get(typeIdx).toString();
    }

    public String viewCurrentAccountObject() {
        return this.currentAccount.toString();
    }

    public String viewCurrentReservationObject(){
        return this.currentReservation.toString();
    }

    public String viewAllCurrentAccountReservations(){
        return this.currentAccountReservations.toString();
    }

    public void selectAccountFromAll(int accountIndex) throws Exception {
        /*
         *  Sets current account by calling Account.loadFromObjectFile
         */
        String selectedAccountID = this.allAccounts.get(accountIndex);
        this.currentAccount = new Account();
        this.currentAccount.loadObjectFromFile(selectedAccountID);
    }

    public void selectReservationFromAll(int reservationIndex) {
        /*
         *  Selects reservation from reservations list by index of list
         * Regex to select correct reservation type
         * generates empty reservation object to be filled by loadObjectFromFile method
         */
        String selectedReservationID = this.currentAccountReservations.get(reservationIndex);
        String accountID = this.currentAccount.getAccountId();
        String hotelTypePattern = "^HOT.*";
        String houseTypePattern = "^HOU.*";
        String cabinTypePattern = "^CAB.*";
        if( selectedReservationID.matches(hotelTypePattern)){
            this.currentReservation = new Hotel(accountID);

        } else if(selectedReservationID.matches(houseTypePattern)){
            this.currentReservation = new House(accountID);

        } else if(selectedReservationID.matches(cabinTypePattern)){
            this.currentReservation = new Cabin(accountID);

        }

        this.currentReservation.loadObjectFromFile(selectedReservationID);
    }

    public Contact loadCurrentContactObject(String xml) {
        /*
         *  Takes File Xml and Parses for Contact Parameters
         * Creates new Object using gathered parameters
         */
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(xml.substring(xml.indexOf("<firstName>") + 11, xml.indexOf("</firstName>")));
        parameters.add(xml.substring(xml.indexOf("<lastName>") + 10, xml.indexOf("</lastName>")));
        parameters.add(xml.substring(xml.indexOf("<email>") + 7, xml.indexOf("</email>")));
        parameters.add(xml.substring(xml.indexOf("<phone>") + 7, xml.indexOf("</phone>")));

        return new Contact(parameters);
    }

    public List<Address> loadCurrentAccountAddresses(String xml) {
        /*
        *  Load addresses into AddressList using XML from file
        */
        List<Object> parameters = new ArrayList<Object>();
        List<Address> tmpAddresses = new ArrayList<Address>();
        
        String addresses[] = {
            xml.substring(xml.indexOf("<PhysicalAddress>") + 17, xml.indexOf("</PhysicalAddress")),
            xml.substring(xml.indexOf("<MailingAddress>") + 16, xml.indexOf("</MailingAddress")),
        };

        for( String address : addresses){
            parameters.add(address.substring(address.indexOf("<street1>") + 9, address.indexOf("</street1>")));
            parameters.add(address.substring(address.indexOf("<street2>") + 9, address.indexOf("</street2>")));
            parameters.add(address.substring(address.indexOf("<city>") + 6, address.indexOf("</city>")));
            parameters.add(address.substring(address.indexOf("<state>") + 7, address.indexOf("</state>")));
            parameters.add(address.substring(address.indexOf("<zip>") + 5, address.indexOf("</zip>")));
            tmpAddresses.add(new Address(parameters));
            parameters.clear();
        }
        
        return tmpAddresses;
    }

    public void updateAccount(List<Object> parameters){ 
        /* 
         * 
         * calls this.currentReservation.saveCurrentObject()
         */
    
    }

    public void updateReservation(List<Object> parameters){
        /*
         * creates new Reservation using blank object constructor ChildReservation(accountID) for this.currentReservation
         * iterates and saves properties of ChildReservation using List<Object> parameters for ChildReservation properties
         * calls this.currentReservation.saveCurrentObject()
         */
     }

    public void saveAddresses(){
        /*
         * Updates this.currentObject addresses iterating through this.currentAddresses List
         * Calls this.currentAccount.saveCurrentObject()
         */
     }

    public void saveContact(){
        /*
         * Updates this.currentObject contact by directly changing this.currentAccount.acctContact with this.currentContact
         * Calls this.currentAccount.saveCurrentObject()
         */
     }
}