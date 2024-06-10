package reservationmanager;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.lang.Exception;
import java.io.IOException;

public class Manager {

    private List<String> allAccounts;
    private List<String> currentAccountReservations;
    private Account currentAccount;
    private Contact currentContact;
    private List<Address> currentAddresses;
    private Reservation currentReservation;

    public Manager() throws Exception {
        /*
         *  
         */
        this._loadAllAccounts();
        this.currentAddresses = new ArrayList<Address>();
        this.currentAccountReservations = new ArrayList<String>();
    }

    private void _loadAllAccounts() throws IOException {
        /*
         * Instantiate new ArrayList
         * Get all directory names as Account IDs as String
         * add name as String to ArrayList
         */
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
        // End of Interface
    }

    public String listAllAccounts(){
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        return this.allAccounts.toString();
    }

    public String viewCurrentContactObject(){
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        return this.currentContact.toString();
    }

    public String viewAddressObject(int typeIdx){
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        return this.currentAddresses.get(typeIdx).toString();
    }

    public String viewCurrentAccountObject() {
        /*
         * 
         */
        return this.currentAccount.toString();
    }

    public String viewCurrentReservationObject(){
        /*
         *  
         */
        return this.currentReservation.toString();
    }
    
    public String viewAllReservationsCurrentAccount(){
        /*
         *  
         */
        return this.currentAccountReservations.toString();
    }

    public String viewAllCurrentAccountReservations(){
        /*
        *  
        */
        return this.currentAccountReservations.toString();
    }

    public void selectAccountFromAll(int accountIndex) throws Exception {
        /*
         *  
         */
        String selectedAccountID = this.allAccounts.get(accountIndex);
        this.currentAccount = new Account();
        this.currentAccount.loadObjectFromFile(selectedAccountID);
    }

    public void selectReservationFromAll(int reservationIndex) throws Exception {
        /*
         *  
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

        } else {
            throw new Exception();
        }

        this.currentReservation.loadObjectFromFile(selectedReservationID);
    }
    
    public Contact loadCurrentContactObject(String xml) throws Exception{
        /*
         *  
         */
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(xml.substring(xml.indexOf("<firstName>") + 11, xml.indexOf("</firstName>")));
        parameters.add(xml.substring(xml.indexOf("<lastName>") + 10, xml.indexOf("</lastName>")));
        parameters.add(xml.substring(xml.indexOf("<email>") + 7, xml.indexOf("</email>")));
        parameters.add(xml.substring(xml.indexOf("<phone>") + 7, xml.indexOf("</phone>")));

        return new Contact(parameters);
    }

    // Most recent need to be finished
    public List<Address> loadCurrentAccountAddresses(String xml) throws Exception {
        /*
        *  
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

    public void updateAccount(List<Object> parameters){ }

    public void updateReservation(List<Object> parameters){ }

    public void saveAccount() throws Exception{}

    public void saveReservation() throws Exception{}

    public void saveAddresses(){ }

    public void saveContact(){ }

}