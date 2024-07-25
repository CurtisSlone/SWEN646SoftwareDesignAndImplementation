package com.art;

public class Customer {

    private String firstName;
    private String lastName;
    private String mailingAddress;
    private String phoneNumber;
    private String email;
    
    public Customer(String firstName, String lastName, String mailingAddress, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailingAddress = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /*
     * GETTERS
     */
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getMailingAddress(){
        return this.mailingAddress;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

     /*
     * SETTERS
     */

     public void setFirstName(String firstName){
        this.firstName = firstName;
     }

     public void setLastName(String lastName){
        this.lastName = lastName;
     }

     public void setMailingAddress(String mailingAddress){
        this.mailingAddress = mailingAddress;
     }

     public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
     }

     public void setEmail(String email){
        this.email = email;
     }
}
