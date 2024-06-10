package reservationmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account implements ParseXML {
    private String acctID;
    protected Contact acctClient;
    protected List<Address> acctAddresses;
    protected List<String> acctReservations;

    public Account(){
        this.acctID = this.generateUniqueID("A");
    }

    public Account(Contact client, List<Address>addresses ) {
        this.acctID = this.generateUniqueID("A");
        this.acctClient = client;
        this.acctAddresses = addresses;
        this.acctReservations = new ArrayList<String>();
    }

    public String getAccountId(){
        return this.acctID;
    }

    public List<String> getAccountReservations(){
        return this.acctReservations;
    }

    public void saveCurrentObject() throws Exception{

    };

    public void generateNewObject(List<Object> parameters) throws Exception{

    };

    public void loadObjectFromFile(String identifierString) throws Exception{

    };

    public String generateUniqueID(String prefix){
        
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s%s", prefix, random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(9)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };
 
    @Override
    public String toString(){

        return String.format("<Account>\n<accountID>%s</accountID>\n%s<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<Reservations>%s</Reservations>\n</Account>\n",this.acctID,this.acctClient.toString(),this.acctAddresses.get(0),this.acctAddresses.get(1),this.acctReservations.toString());
    }
}
