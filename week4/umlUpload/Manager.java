
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

    public String viewCurrentAccountObject() {
        return this.currentAccount.toString();
    }

    public String viewCurrentReservationObject(){
        return this.currentReservation.toString();
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

    public void updateAccount(List<Object> parameters) throws Exception{
        this.currentAccount.updateObjectFromParameters(parameters);
        this.currentAccount.saveCurrentObject();
    }

    public void updateReservation(List<Object> parameters) throws Exception{ 
        this.currentReservation.updateObjectFromParameters(parameters);
        this.currentReservation.saveCurrentObject();
    }

    public void deleteAccount(String identifierString) throws Exception {
        this.currentAccount.deleteFileFromID(identifierString);
     }

    public void deleteReservation(String identifierString) throws Exception { 
        this.currentReservation.deleteFileFromID(identifierString);
    }

}