package reservationmanager;

import java.util.List;

public class Address {
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zip;

    /*
     * Empty Constructor for parameterValidation
     */

     public Address(){ }
    /*
     * Default Constructor
     * Takes List<String> as parameter
     */
    public Address(List<String> parameters){
        this.street1 = parameters.get(0);
        this.street2 = parameters.get(1);
        this.city = parameters.get(2);
        this.state = parameters.get(3);
        this.zip = parameters.get(4);
    }

    @Override
    public String toString(){
        return String.format("\n<Address>\n<street1>%s</street1>\n<street2>%s</street2>\n<city>%s</city>\n<state>%s</state>\n<zip>%s</zip>\n</Address>\n",this.street1,this.street2,this.city,this.state,this.zip);
    }
}
