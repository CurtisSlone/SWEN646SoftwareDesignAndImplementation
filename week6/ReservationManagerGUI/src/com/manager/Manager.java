package com.manager;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Manager  {

    private List<String> allAccounts;
    private Account currentAccount;
    private Reservation currentReservation;

    /*
     * Default Constructor
     */
    public Manager() {
        this._loadAllAccounts();
    }

    /*
     * Load All Accounts
     */
    private void _loadAllAccounts() {

        /*
         * If accounts directory does not exist, make directory
         * List all account names from directory names
         * Add to this.allAccounts List<String>
         */
        try {
            File accountsDir = new File("./accounts");
            if(!accountsDir.exists())
                accountsDir.mkdir();
            this.allAccounts = Arrays.asList(accountsDir.list());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    /*
     * List all Loaded Accounts
     */
    public List<String> listAllAccounts(){
        return this.allAccounts;
    }

    /*
     * View Current Account Contact Object as String
     */
    public String viewCurrentAccountContact(){
        try {
            if(this.currentAccount == null)
                throw new IllegalOperationException("No Account selected");
           } catch (Exception e) {
            System.out.println(e.getMessage());
           }
        return this.currentAccount.acctClient.toString();
           
    }

    /*
     * View Current Address Object as string
     */
    public String viewCurrentAccountAddresses(){
        try {
            if(this.currentAccount == null)
                throw new IllegalOperationException("No Account selected");
           } catch (Exception e) {
            System.out.println(e.getMessage());
           } 
        return this.currentAccount.addressList.toString();
    }

    /*
     * View Current Account Object
     */
    public Account viewCurrentAccountObject() {
        try {
            if(this.currentAccount == null)
                throw new IllegalOperationException("No Account selected");
           } catch (Exception e) {
            System.out.println(e.getMessage());
           } 
                return this.currentAccount;
    }

    /*
     * View Current Reservation Object
     */
    public Reservation viewCurrentReservationObject() {
       try {
        if(this.currentReservation == null)
            throw new IllegalOperationException("No reservation selected");
       } catch (Exception e) {
        System.out.println(e.getMessage());
       } 
        return this.currentReservation;
  
    }

    /*
     * View Current Account Object Reservations as String
     */
    public List<String> viewAllCurrentAccountReservations(){
        try {
            if(this.currentAccount == null)
                throw new IllegalOperationException("No Account selected");
           } catch (Exception e) {
            System.out.println(e.getMessage());
           } 
        return this.currentAccount.acctReservations;

    }

    /*
     * Load account by account ID
     */
    public void selectAccountFromAll(int accountIndex) {
        /*
        * Create Empty Account
        * select account by ID from this.allAccounts to get accountID for file location
        * call currentObject ParseXML interface method to change all attributes of empty account
        */
        try {
            if(accountIndex > this.allAccounts.size() - 1)
                throw new IllegalOperationException("Index is outside of List Range");
            this.currentAccount = new Account();
            this.currentAccount.loadObjectFromFile(this.allAccounts.get(accountIndex));
            // System.out.println(this.currentAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    /*
     * Load Reservation by reservation
     */
    public void selectReservationFromAll(int reservationIndex) {
        /*
         *  Get Reservation ID from Current Account object's reservation list
         *  Parse reservation ID to find Reservation Type
         *  Create new reservation
         *  Change attributes by calling ParseXML interface methof loadObjectFromFile
         */
        try {
            if(reservationIndex > this.currentAccount.acctReservations.size() - 1)
                throw new IllegalArgumentException("Index is outside of List range");
            if(this.currentAccount == null)
                throw new IllegalOperationException("No account selected");
            if( this.currentAccount.acctReservations.get(reservationIndex).matches("^HOT.*")){
                this.currentReservation = new Hotel(ReservationType.HOTEL, this.currentAccount.getAccountId());

            } else if(this.currentAccount.acctReservations.get(reservationIndex).matches("^HOU.*")){
                this.currentReservation = new House(ReservationType.HOUSE, this.currentAccount.getAccountId());

            } else if(this.currentAccount.acctReservations.get(reservationIndex).matches("^CAB.*")){
                this.currentReservation = new Cabin(ReservationType.CABIN, this.currentAccount.getAccountId());

            }

         this.currentReservation.loadObjectFromFile(this.currentAccount.acctReservations.get(reservationIndex));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /*
     * Create new reservation
     */
    public void createNewReservation(ReservationType type) {
        /*
         * If not current account loaded, throw exception
         * Take type as parameter, match to ReservationType
         * Create correct Reservation type
         */
        try {
            
            if(this.currentAccount == null)
                throw new IllegalOperationException("No current account selected");
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
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Create new empty account
     */
    public void createNewAccount(){
        this.currentAccount = new Account();
    }

    public void saveObject(ParseXML objectTypeOf){
        try {
            objectTypeOf.saveCurrentObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this._loadAllAccounts();
    }
    /*
     * Update object
     */
    public void updateObject(ParseXML objectTypeOf, List<Object> parameters){
        /*
        * Take ParseXML object,
        * Save Object
        */
        try {
            objectTypeOf.updateObjectFromParameters(parameters);
            objectTypeOf.saveCurrentObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Delete object
     */
    public void deleteObject(ParseXML objectTypeOf,String identifierString){
        try {
            objectTypeOf.deleteFileFromID(identifierString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
     }
}
