package reservationmanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<String> allAccounts;
    private Account currentAccount;
    private Contact currentContact;
    private List<Address> currentAddresses;
    private Reservation currentReservation;

    public Manager() throws Exception {
        this._loadAllAccounts();
    }

    private void _loadAllAccounts() throws IOException {

        this.allAccounts = new ArrayList<String>();

        String accounts[];
        File accountsDir = new File("./accounts");
        if(!accountsDir.exists())
            accountsDir.mkdir();
        accounts = accountsDir.list();
        if(accounts.length != 0)
            for(String account : accounts)
                this.allAccounts.add(account);
    }

    public String listAllAccounts(){
        return this.allAccounts.toString();
    }

    public String viewCurrentContactObject(){
        return this.currentContact.toString();
    }

    public String viewAddressObject(int typeIdx){
        return this.currentAccount.addressList.get(typeIdx).toString();
    }

    public String viewCurrentObject(ParseXML objectTypeof) {
        return objectTypeof.toString();
    }

    public String viewAllCurrentAccountReservations(){
        return this.currentAccount.acctReservations.toString();
    }

    public void selectAccountFromAll(int accountIndex) throws Exception {
        String selectedAccountID = this.allAccounts.get(accountIndex);
        this.currentAccount = new Account();
        this.currentAccount.loadObjectFromFile(selectedAccountID);
    }

    public void selectReservationFromAll(int reservationIndex) throws Exception {
        /*
         *  
         */
        String selectedReservationID = this.currentAccount.acctReservations.get(reservationIndex);
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
    
    public Contact createContactObject(List<Object> parameters){
        return new Contact(parameters);
    }

    public Address createAddressesObject(List<Object> parameters) {
        return new Address(parameters);
    }

    public void createNewReservation(ReservationType type) throws Exception{
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

    public void createNewAccount(){
        this.currentAccount = new Account();
    }

    public void updateObject(ParseXML objectTypeOf, List<Object> parameters) throws Exception{
            objectTypeOf.updateObjectFromParameters(parameters);
            objectTypeOf.saveCurrentObject();
    }

    public void deleteObject(ParseXML objectTypeOf,String identifierString) throws Exception {
        objectTypeOf.deleteFileFromID(identifierString);
     }

}