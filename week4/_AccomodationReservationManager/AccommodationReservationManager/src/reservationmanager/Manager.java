package reservationmanager;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.lang.Exception;
import java.io.IOException;
import java.util.Scanner;

public class Manager {

    private List<String> allAccounts;
    private List<String> currentAccountReservations;
    private Account currentAccount;
    private Contact currentContact;
    private Map<String,Address> currentAddressMap;
    private Reservation currentReservation;

    public Manager() throws Exception {
        this.allAccounts = this._loadAllAccounts();
        this.currentAddressMap = new HashMap<String,Address>();
        currentAddressMap.put("CurrentAddress", null);
        currentAddressMap.put("PhysicalAddress", null);
        currentAddressMap.put("MailingAddress", null);
    }

    private List<String> _loadAllAccounts() throws IOException {
        /*
         * Instantiate new ArrayList
         * Get all directory names as Account IDs as String
         * add name as String to ArrayList
         */
        List<String> tmp = new ArrayList<String>();
        String accounts[];
        File accountsDir = new File("./accounts");
        if(!accountsDir.exists()){
            accountsDir.mkdir();
        }
        accounts = accountsDir.list();
        if(accounts.length != 0)
            for(String account : accounts)
                tmp.add(account);

        return tmp;
    }

    public String listAllAccounts(){
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        return this.allAccounts.toString();
    }

    public void createNewContact(String fname, String lname, String email, String phone) throws Exception {
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        this.currentContact = new Contact(fname, lname, email, phone);
    }

    public String viewCurrentContactObject(){
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        return this.currentContact.toString();
    }

    public void createNewAddress(String street1, String street2, String city, String state, String zip) throws Exception {
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        this.currentAddressMap.put("CurrentAddress", new Address(street1, street2, city, state, zip));
    }

    public String viewAddressObject(String addressType){
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        return this.currentAddressMap.get(addressType).toString();
    }


    public void saveCurrentAddress(String addressType) throws Exception{
        /*
         * Address type as parameter
         * Saves currentAddress from currentAddressMap as address type in map
         */
        this.currentAddressMap.put(addressType, this.currentAddressMap.get("CurrentAddress"));
    }

    private Account _generateNewAccount(Contact contact, List<Address> addresses ){
        /*
         * Contact and List<Address> type as parameter
         * returns new Account
         */
        String accountID = "A" + this._generateUniqueID(9);
        return new Account(accountID, contact, addresses);
    }

    public void createNewAccount(boolean useCurrentContact, boolean useSavedAddresses, boolean mailingSameAsPhysical) throws Exception {
        /*
         *  if !useCurrentContact, prompt user for new contact input
         *  if !useSavedAddresses && !mailingSameAsPhysical, prompt user for new physical and mailing address input
         *  if !useSavedAddresses && mailingSameAsPhysical, prompt user for new physical address
         *  convert address map to address List
         *  call this._generateNewAccount
         *  save account, generate directory and account file
         * 
         */
        List<Address> addresses = new ArrayList<Address>();
        if(!useCurrentContact)
            this.currentContact = this._createTempContact();
        if(!useSavedAddresses)
            addresses = this._createTempAddressList(mailingSameAsPhysical);
        this.currentAccount = this._generateNewAccount(this.currentContact, addresses);

    }
    
    private Contact _createTempContact() throws Exception{
        Scanner contactInfo = new Scanner(System.in);
        String fname = contactInfo.nextLine();
        String lname = contactInfo.nextLine();
        String email = contactInfo.nextLine();
        String phone = contactInfo.nextLine();

        return new Contact(fname, lname, email, phone);
    }

    private List<Address> _createTempAddressList(boolean mailingSameAsPhysical) throws Exception {
        List<Address> tmpList = new ArrayList<Address>();
        Address tmpPhysicalAddress = this._createTempAddress("PhysicalAddress");
        tmpList.add(tmpPhysicalAddress);
        if(mailingSameAsPhysical){
            tmpList.add(tmpPhysicalAddress);
            return tmpList;
        }
        
        Address tmpMailingAddress = this._createTempAddress("MailingAddress");
        tmpList.add(tmpMailingAddress);
        return tmpList;
    }

    private Address _createTempAddress(String type) throws Exception {
        Scanner addressInfo = new Scanner(System.in);
        String street1 = addressInfo.nextLine();
        String street2 = addressInfo.nextLine();
        String city = addressInfo.nextLine();
        String state = addressInfo.nextLine();
        String zip = addressInfo.nextLine();

        return new Address(street1, street2, city, state, zip);
    }

    private String _generateUniqueID(int charCount){
        /*
         * Create
         */

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(charCount)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    }

    
    public void saveCurrentAccount() throws Exception{
        /* Check if currentAccount ID is in allAccounts ArrayList and accountID != -99
         *  If not new, update deltas,
         * If new, create directory and file
         * change msg based on success or error
         */
        

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

    public String saveContact(String AccountId){
        String msg = "";
        /*
         * 
         */
        return msg;
    }

}
