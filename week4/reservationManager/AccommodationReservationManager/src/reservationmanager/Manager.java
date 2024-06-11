package reservationmanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager  {

    private List<String> allAccounts;
    private Account currentAccount;
    private Contact currentContact;
    private Reservation currentReservation;

    /*
     * Default Constructor
     */
    public Manager()throws Exception {
        this._loadAllAccounts();
    }

    /*
     * Load All Accounts
     */
    private void _loadAllAccounts() throws IOException {

        /*
         * initialize this.currentReservation
         */
        this.allAccounts = new ArrayList<String>();

        /*
         * If accounts directory does not exist, make directory
         * List all account names from directory names
         * Add to this.allAccounts List<String>
         */
        String accounts[];
        File accountsDir = new File("./accounts");
        if(!accountsDir.exists())
            accountsDir.mkdir();
        accounts = accountsDir.list();
        if(accounts.length != 0)
            for(String account : accounts)
                this.allAccounts.add(account);
    }

    /*
     * List all Loaded Accounts
     */
    public String listAllAccounts(){
        return this.allAccounts.toString();
    }

    /*
     * View Current Contact Object as String
     */
    public String viewCurrentContactObject(){
        return this.currentContact.toString();
    }

    /*
     * View Current Address Object as string
     */
    public String viewAddressObject(int typeIdx){
        return this.currentAccount.addressList.get(typeIdx).toString();
    }

    /*
     * View Current Account Object
     */
    public Account viewCurrentAccountObject() {
        return this.currentAccount;
    }

    /*
     * View Current Reservation Object
     */
    public Reservation viewCurrentReservationObject() {
        return this.currentReservation;
    }

    /*
     * View Current Account Object Reservations as String
     */
    public String viewAllCurrentAccountReservations(){
        return this.currentAccount.acctReservations.toString();
    }

    /*
     * Load account by account ID
     */
    public void selectAccountFromAll(int accountIndex) throws Exception {
        /*
        * Create Empty Account
        * select account by ID from this.allAccounts to get accountID for file location
        * call currentObject ParseXML interface method to change all attributes of empty account
        */
        this.currentAccount = new Account();
        this.currentAccount.loadObjectFromFile(this.allAccounts.get(accountIndex));
    }

    /*
     * Load Reservation by reservation
     */
    public void selectReservationFromAll(int reservationIndex) throws Exception {
        /*
         *  Get Reservation ID from Current Account object's reservation list
         *  Parse reservation ID to find Reservation Type
         *  Create new reservation
         *  Change attributes by calling ParseXML interface methof loadObjectFromFile
         */

        if( this.currentAccount.acctReservations.get(reservationIndex).matches("^HOT.*")){
            this.currentReservation = new Hotel(ReservationType.HOTEL, this.currentAccount.getAccountId());

        } else if(this.currentAccount.acctReservations.get(reservationIndex).matches("^HOU.*")){
            this.currentReservation = new House(ReservationType.HOUSE, this.currentAccount.getAccountId());

        } else if(this.currentAccount.acctReservations.get(reservationIndex).matches("^CAB.*")){
            this.currentReservation = new Cabin(ReservationType.CABIN, this.currentAccount.getAccountId());

        } else {
            throw new Exception();
        }

        this.currentReservation.loadObjectFromFile(this.currentAccount.acctReservations.get(reservationIndex));
    }
    
    /*
     * Create new reservation
     */
    public void createNewReservation(ReservationType type) throws Exception{
        /*
         * If not current account loaded, throw exception
         * Take type as parameter, match to ReservationType
         * Create correct Reservation type
         */

        if(this.currentAccount == null)
            throw new Exception();
        switch(type){
            case HOTEL:
                this.currentReservation = new Hotel(type, this.currentAccount.getAccountId());
                break;
            case HOUSE:
                this.currentReservation = new House(type, this.currentAccount.getAccountId());
                break;
            case CABIN:
                this.currentReservation = new Cabin(type, this.currentAccount.getAccountId());
                break;
            default:
                throw new Exception();
        }
    }

    /*
     * Create new empty account
     */
    public void createNewAccount(){
        this.currentAccount = new Account();
    }

    /*
     * Update object
     */
    public void updateObject(ParseXML objectTypeOf, List<Object> parameters) throws Exception{
        /*
        * Take ParseXML object,
        * Save Object
        */
        objectTypeOf.updateObjectFromParameters(parameters);
        objectTypeOf.saveCurrentObject();
    }

    /*
     * Delete object
     */
    public void deleteObject(ParseXML objectTypeOf,String identifierString) throws Exception {
        objectTypeOf.deleteFileFromID(identifierString);
     }

}