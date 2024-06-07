package reservationmanager;

public class Address {
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zip;

    public Address(String addStreet1, String addStreet2, String addCity, String addZip ){
        this.street1 = addStreet1;
        this.street2 = addStreet2;
        this.city = addCity;
        this.zip = addZip;
    }

    @Override
    public String toString(){
        return "";
    }
}
