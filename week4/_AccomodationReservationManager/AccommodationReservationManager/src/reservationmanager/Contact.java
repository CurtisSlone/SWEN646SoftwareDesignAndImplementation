package reservationmanager;

public class Contact {
    private String firstName;
    private String lastName;
    protected String email;
    protected String phoneNumber;
    
    public Contact(String fName, String lName, String email, String phoneNumber){
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    
    @Override
    public String toString(){

        return String.format("<Contact>\n<firstName>%s</firstName> \n<lastName>%s</lastName> \n<email>%s</email> \n<phone>%s</phone>\n</Contact>\n", this.firstName, this.lastName, this.email, this.phoneNumber);
    }
}
