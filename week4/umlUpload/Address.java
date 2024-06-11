
public class Address {
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zip;

    public Address(List<Object> parameters){
        this.street1 = (String)parameters.get(0);
        this.street2 = (String)parameters.get(1);
        this.city = (String)parameters.get(2);
        this.state = (String)parameters.get(3);
        this.zip = (String)parameters.get(4);
    }

    @Override
    public String toString(){
        return String.format("\n<Address>\n<street1>%s</street1>\n<street2>%s</street2>\n<city>%s</city>\n<state>%s</state>\n<zip>%s</zip>\n</Address>\n",this.street1,this.street2,this.city,this.state,this.zip);
    }
}
