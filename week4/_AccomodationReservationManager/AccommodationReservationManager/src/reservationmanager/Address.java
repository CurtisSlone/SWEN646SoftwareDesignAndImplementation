package reservationmanager;

public class Address {
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zip;

    public Address(String addStreet1, String addStreet2, String addCity, String addState, String addZip ){
        this.street1 = addStreet1;
        this.street2 = addStreet2;
        this.city = addCity;
        this.state = addState;
        this.zip = addZip;
    }

    @Override
    public String toString(){
        return String.format("<Address>\n<street1>%s</street1>\n<street2>%s</street2>\n<city>%s</city>\n<state>%s</state>\n<zip>%s</zip>\n</Address>\n",this.street1,this.street2,this.city,this.state,this.zip);
    }
}
