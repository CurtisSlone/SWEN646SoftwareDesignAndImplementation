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
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Manager {

    private List<String> allAccounts;
    private List<String> currentAccountReservations;
    private Account currentAccount;
    private Contact currentContact;
    private Map<String,Address> currentAddressMap;
    private Reservation currentReservation;

    public Manager() throws Exception {
        /*
         *  
         */
        this._loadAllAccounts();
        this.currentAddressMap = new HashMap<String,Address>();
        currentAddressMap.put("CurrentAddress", null);
        currentAddressMap.put("PhysicalAddress", null);
        currentAddressMap.put("MailingAddress", null);
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

    private Account _generateNewAccount(Contact contact, List<Address> addresses ) throws Exception{
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
        if(!useSavedAddresses){
            addresses = this._createTempAddressList(mailingSameAsPhysical);
        } else {
            addresses.add(this.currentAddressMap.get("PhysicalAddress"));
            if(!mailingSameAsPhysical)
                addresses.add(this._createTempAddress("MailingAddress"));
            addresses.add(this.currentAddressMap.get("PhysicalAddress"));
        }
        this.currentAccount = this._generateNewAccount(this.currentContact, addresses);   
    }
    
    private Contact _createTempContact() throws Exception{
        /*
         *  
         */
        Scanner contactInfo = new Scanner(System.in);
        String fname = contactInfo.nextLine();
        String lname = contactInfo.nextLine();
        String email = contactInfo.nextLine();
        String phone = contactInfo.nextLine();
        contactInfo.close();
        return new Contact(fname, lname, email, phone);
    }

    private List<Address> _createTempAddressList(boolean mailingSameAsPhysical) throws Exception {
        /*
         *  
         */
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
        addressInfo.close();
        return new Address(street1, street2, city, state, zip);
    }

    private String _generateUniqueID(int charCount){
        /*
         * charCount as int Parameter
         * Returns random alphanumeric string of charCount length
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

    public String viewCurrentAccountObject() {
        /*
         * 
         */
        return this.currentAccount.toString();
    }

    public void saveCurrentAccountObject() throws Exception{
        /*
         * 
         */

        String accountDirStr = String.format("./accounts/%s",this.currentAccount.getAccountId());
        String accountFileName = String.format("%s/acc-%s.xml", accountDirStr, this.currentAccount.getAccountId());
        this.currentAccount.acctReservations = this.currentAccountReservations;
        String accountInfoStr = this.currentAccount.toString();
        char foutAccountInfo[] = accountInfoStr.toCharArray();

        File accountDir = new File(accountDirStr);
        if(!accountDir.exists())
            accountDir.mkdir();
        accountDir = null;

        FileOutputStream writeAccountToFile = new FileOutputStream(accountFileName, false);

        for( char c : foutAccountInfo)
            writeAccountToFile.write(c);
        
        writeAccountToFile.close();
        this._loadAllAccounts();

    }

    private Reservation _generateNewReservation(ReservationType type, String accountID, List<Address> addresses, List<Object> reservationParameters) throws Exception {
        /*
         * 
         */
        String reservationID;
        switch (type) {
            case HOTEL:
                reservationID = "HOT" + this._generateUniqueID(10);
                return new Hotel(reservationID, accountID, addresses, reservationParameters);
                
            case HOUSE:
                reservationID = "HOU" + this._generateUniqueID(10);
                return new House(reservationID, accountID, addresses, reservationParameters);

            case CABIN:
                reservationID = "CAB" + this._generateUniqueID(10);
                return new Cabin(reservationID, accountID, addresses, reservationParameters);

            default:
                throw new Exception();
        }
    }

    public void createNewReservation(ReservationType type, List<Object> reservationParameters, boolean useSavedAddresses, boolean mailingSameAsPhysical) throws Exception{
        /*
         *  
         */
        

        List<Address> addresses = new ArrayList<Address>();
        if(!useSavedAddresses){
            addresses = this._createTempAddressList(mailingSameAsPhysical);
        } else {
            addresses.add(this.currentAddressMap.get("PhysicalAddress"));
            if(!mailingSameAsPhysical)
                addresses.add(this._createTempAddress("MailingAddress"));
            addresses.add(this.currentAddressMap.get("PhysicalAddress"));
        }
        
        this.currentReservation = this._generateNewReservation(type, this.currentAccount.getAccountId(), addresses, reservationParameters);
    
        this._saveReservation();
    }

    private void _saveReservation() throws Exception {
        /*
         *  
         */

        String accountDirStr = String.format("./accounts/%s",this.currentAccount.getAccountId());
        String reservationFileName = String.format("%s/res-%s.xml", accountDirStr, this.currentReservation.getReservationID());

        if(this.currentReservation instanceof Hotel && !((Hotel)this.currentReservation).checkIfValidHotel())
            throw new Exception();
        if(this.currentAccount == null)
            throw new Exception();
        
        File accountInfo = new File(accountDirStr);
        if(!accountInfo.exists())
            throw new Exception();
        accountInfo = null;

        String reservationInfo = this.currentReservation.toString();
        char foutReservationInfo[] = reservationInfo.toCharArray();

        FileOutputStream writeReservationToFile = new FileOutputStream(reservationFileName, true);

        for(char c : foutReservationInfo)
            writeReservationToFile.write(c);

        writeReservationToFile.close();
        this.currentAccountReservations.add(this.currentReservation.getReservationID());
        this.saveCurrentAccountObject();
        
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

    // Todo: this.current account equals loaded object

    public void selectAccountFromAll(int accountIndex) throws Exception {
        /*
         *  
         */
        String selectedAccountID = this.allAccounts.get(accountIndex);
        System.out.println(selectedAccountID);
        this._loadCurrentObjectsFromFileByAccountID(selectedAccountID);
    }

    private void _loadCurrentObjectsFromFileByAccountID(String accountID) throws Exception {
        /*
         *  
         */
        String accountFile = String.format("./accounts/%s/acc-%s.xml", accountID,accountID);
        BufferedReader accountBufferedReader = null;
        FileInputStream accountFileInputStream = new FileInputStream(accountFile);
        accountBufferedReader = new BufferedReader(new InputStreamReader(accountFileInputStream));
	    String currentLine = null;
        List<Address> addressArrList = null;
	        
	    currentLine = accountBufferedReader.readLine();
        while((currentLine = accountBufferedReader.readLine()) != null){ 
            currentLine += accountBufferedReader.readLine();
        }
        
        System.out.println(currentLine);
	    String accountContact = currentLine.substring(currentLine.indexOf("<Contact>"), currentLine.indexOf("</Contact>") + 10);
        this.currentContact = this._loadCurrentContactObject(accountContact);

        String accountAddresses = currentLine.substring(currentLine.indexOf("<PhysicalAddress>"), currentLine.indexOf("</MailingAddress>") + 17);
        addressArrList = this._loadCurrentAccountAddresses(accountAddresses);
        this._loadCurrentAddessMap(addressArrList);

        String accountReservations = currentLine.substring(currentLine.indexOf("<Reservations>"), currentLine.indexOf("</Reservations>") + 15);
        this.currentAccountReservations = this._loadCurrentReservationsList(accountReservations);

        accountFileInputStream.close();
        accountFileInputStream.close();
        accountBufferedReader.close();

        this.currentAccount = new Account(accountID, currentContact, addressArrList);
    }

    private Contact _loadCurrentContactObject(String contactXML) throws Exception{
        /*
         *  
         */
        String firstName = contactXML.substring(contactXML.indexOf("<firstName>") + 11, contactXML.indexOf("</firstName>"));
        String lastName = contactXML.substring(contactXML.indexOf("<lastName>") + 10, contactXML.indexOf("</lastName>"));
        String email = contactXML.substring(contactXML.indexOf("<email>") + 7, contactXML.indexOf("</email>"));
        String phoneNumber = contactXML.substring(contactXML.indexOf("<phoneNumber>") + 13, contactXML.indexOf("</phoneNumber>"));

        return new Contact(firstName,lastName,email,phoneNumber);
    }

    // Most recent need to be finished
    private List<Address> _loadCurrentAccountAddresses(String addressXML) throws Exception {
        /*
        *  
        */
        List<Address> tmpAddresses = new ArrayList<Address>();
        
        String addresses[] = {
            addressXML.substring(addressXML.indexOf("<PhysicalAddress>" + 17), addressXML.indexOf("</PhysicalAddress")),
            addressXML.substring(addressXML.indexOf("<MailingAddress>" + 16), addressXML.indexOf("</MailingAddress")),
        };

        for( String address : addresses){
            String street1 = address.substring(address.indexOf("<street1>") + 9, address.indexOf("</street1>"));
            String street2 = address.substring(address.indexOf("<street2>") + 9, address.indexOf("</street2>"));
            String city = address.substring(address.indexOf("<city>") + 6, address.indexOf("</city>"));
            String state = address.substring(address.indexOf("<state>") + 7, address.indexOf("</state>"));
            String zip = address.substring(address.indexOf("<zip>") + 5, address.indexOf("</zip>"));
            tmpAddresses.add(new Address(street1, street2, city, state, zip));
        }
        
        return tmpAddresses;
    }

    private void _loadCurrentAddessMap(List<Address> addressList) throws Exception {
        this.currentAddressMap.put("PhysicalAddress", addressList.get(0));
        this.currentAddressMap.put("MailingAddress", addressList.get(1));
    }

    private List<String> _loadCurrentReservationsList(String reservationXML) throws Exception {
       /*
        *  
        */
        List<String> tmpReservations = new ArrayList<String>();
        String reservationsXMLString = reservationXML.substring(reservationXML.indexOf("<Reservations>[") + 15, reservationXML.indexOf("]</Reservations>"));
        String reservations[] = reservationsXMLString.split(",");
        for( String reservation : reservations)
            tmpReservations.add(reservation);
        return tmpReservations;
    }

}
