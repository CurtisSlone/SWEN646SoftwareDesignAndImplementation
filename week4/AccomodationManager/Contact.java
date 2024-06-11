import java.util.List;

public class Contact {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    
    public Contact(List<Object> parameters){
        this.firstName = (String)parameters.get(0);
        this.lastName = (String)parameters.get(1);
        this.email = (String)parameters.get(1);
        this.phoneNumber = (String)parameters.get(1);
    }

    
    @Override
    public String toString(){

        return String.format("<Contact>\n<firstName>%s</firstName> \n<lastName>%s</lastName> \n<email>%s</email> \n<phone>%s</phone>\n</Contact>\n", this.firstName, this.lastName, this.email, this.phoneNumber);
    }
}
