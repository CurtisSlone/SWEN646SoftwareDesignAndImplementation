package reservationmanager;

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
        this.email = parameters.get(1);
        this.phoneNumber = parameters.get(1);
    }


    /*
    * Output as XML
    */ 
    @Override
    public String toString(){

        return String.format("<Contact>\n<firstName>%s</firstName> \n<lastName>%s</lastName> \n<email>%s</email> \n<phone>%s</phone>\n</Contact>\n", this.firstName, this.lastName, this.email, this.phoneNumber);
    }
}
