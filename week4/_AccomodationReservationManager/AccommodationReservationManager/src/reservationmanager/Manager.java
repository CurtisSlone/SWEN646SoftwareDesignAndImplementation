package reservationmanager;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.Date;

public class Manager {

    private List<String> allAccounts;
    private List<String> currentAccountReservations;
    private Account currentAccount;
    private Contact currentContact;
    private Map<String,Address> currentAddressMap;
    private Reservation currentReservation;

    public Manager() throws Exception {
        this._loadAllAccounts();
        this.currentAddressMap = new HashMap<String,Address>();
        currentAddressMap.put("CurrentAddress", null);
        currentAddressMap.put("PhysicalAddress", null);
        currentAddressMap.put("MailingAddress", null);
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
        return this.currentAccount.toString();
    }

    private Reservation _generateNewReservation(ReservationType type, String accountID, List<Address> addresses, Date startDate, int numNights, int numBeds, int numRooms, int numBaths, int lodgingSize) throws Exception {
        /*
         * 
         */
        String reservationID;
        Scanner reservationScanner = new Scanner(System.in);
        switch (type) {
            case HOTEL:
                reservationID = "HOT" + this._generateUniqueID(10);
                boolean hasKitchenette = reservationScanner.nextBoolean();

                return new Hotel(reservationID, accountID, addresses, startDate, numNights, numBeds, numRooms, numBaths, lodgingSize, hasKitchenette);
                
            case HOUSE:
                reservationID = "HOU" + this._generateUniqueID(10);
                int numFloors = reservationScanner.nextInt();

                return new House(reservationID, accountID, addresses, startDate, numNights, numBeds, numRooms, numBaths, lodgingSize, numFloors);

            case CABIN:
                reservationID = "CAB" + this._generateUniqueID(10);
                boolean hasFullKitchen = reservationScanner.nextBoolean();
                boolean hasLoft = reservationScanner.nextBoolean();

                return new Cabin(reservationID, accountID, addresses, startDate, numNights, numBeds, numRooms, numBaths, lodgingSize, hasFullKitchen, hasLoft);

            default:
                throw new Exception();
        }
    }

    public void createNewReservation(ReservationType type, boolean useSavedAddresses, boolean mailingSameAsPhysical) throws Exception{
        /*
         *  
         */
        
        Scanner newReservationScanner = new Scanner(System.in);
        //Date Operations
        String dateYear = newReservationScanner.nextLine();
        String dateMonth = newReservationScanner.nextLine();
        String dateDay = newReservationScanner.nextLine();
        String dateFormat = String.format("%s-%s-%s 12:00:23");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        // End Date Opeerations

        Date startDate = simpleDateFormat.parse(dateFormat);
        int numNights = newReservationScanner.nextInt();
        int numBeds = newReservationScanner.nextInt();
        int numRooms = newReservationScanner.nextInt();
        int numBaths = newReservationScanner.nextInt();
        int lodgingSize = newReservationScanner.nextInt();
        List<Address> addresses = new ArrayList<Address>();
        if(!useSavedAddresses){
            addresses = this._createTempAddressList(mailingSameAsPhysical);
        } else {
            addresses.add(this.currentAddressMap.get("PhysicalAddress"));
            if(!mailingSameAsPhysical)
                addresses.add(this._createTempAddress("MailingAddress"));
            addresses.add(this.currentAddressMap.get("PhysicalAddress"));
        }
        
        this.currentReservation = this._generateNewReservation(type, this.currentAccount.getAccountId(), addresses, startDate, numNights, numBeds, numRooms, numBaths, lodgingSize);


    }

    private void _saveReservation() throws Exception {
        /*
         *  
         */
        if(this.currentReservation instanceof Hotel && !((Hotel)this.currentReservation).checkIfValidHotel())
            throw new Exception();
        if(this.currentAccount == null)
            throw new Exception();
        this.currentAccount.acctReservations.add(this.currentReservation.getReservationID());
        
    }

}
