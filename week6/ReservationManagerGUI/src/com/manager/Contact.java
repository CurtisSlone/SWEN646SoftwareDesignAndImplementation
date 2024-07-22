package com.manager;

import java.util.List;

public class Contact {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    
    /*
     * Empty Constructor for parameter validation
    */
    public Contact(){ }

    /*
     * Takes List<String> as parameter
     */
    public Contact(List<String> parameters){
        
        this.firstName = parameters.get(0);
        this.lastName = parameters.get(1);
        this.email = parameters.get(2);
        this.phoneNumber = parameters.get(3);
    }


    /*
    * Override Object.toSTring() Output as XML
    */ 
    @Override
    public String toString(){

        return String.format("""
            <Contact>
                <firstName>%s</firstName>
                <lastName>%s</lastName>
                <email>%s</email>
                <phone>%s</phone>
            </Contact>""", this.firstName, this.lastName, this.email, this.phoneNumber);
    }
}
