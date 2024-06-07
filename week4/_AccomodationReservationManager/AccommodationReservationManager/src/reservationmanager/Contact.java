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

        return "";
    }
}
