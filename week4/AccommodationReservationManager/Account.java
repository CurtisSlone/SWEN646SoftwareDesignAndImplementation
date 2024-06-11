
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Account implements ParseXML {

    private String acctId; //Unique Account ID- A followed by 9 characters
    protected Contact actClient; //Client Object Associated with Account
    public Address physicalAddress; //Address Object  for Physical Address
    protected Address mailingAddress; //Address Object  for Physical Addr
    protected List<String> acctReservations; //List of reservations associated with account

    
    //Default constructor
    public Account() {
        this.acctID = "-99";
        this.acctReservations = new ArrayList<String>();
    }

   // Constructor: List<Object> as Params
    public void Account(List<Object> parameters) {
        
        this.acctID = this.generateUniqueID("A");
        this.acctClient = (Contact)parameters.get(0);
        this.physicalAddress = (Address)parameters.get(1);
        this.mailingAddress = (Address)parameters.get(2);
        this.acctReservations = new ArrayList<String>();
    
    }

    
    protected String getAccountId() {
        return this.acctID;
    }


    protected List<String> getAccountReservations() {
        return this.acctReservations;
    }

    public void saveCurrentObject() {
        /*
            if(this.getAccountId() == "-99")
                throw new Exception();
            File accountDir = new File(accountDirName);
            if(!accountDir.exists())
                accountDir.mkdir();
            accountDir = null;

            FileOutputStream writeAccountToFile = new FileOutputStream(accountFileName, false);
        
            for( char c : foutAccountInfo)
                writeAccountToFile.write(c);
            writeAccountToFile.close();
         */
        
    }


    public void loadObjectFromFile(String identifierString) {
        /*
            List<Object> parameters 
            List<Address> addresses 
            this.acctID = identifierString;
            accountFile = String.format("./accounts/%s/acc-%s.xml", identifierString,identifierString);
            accountXmlAsString = new String(Files.readAllBytes(Paths.get(accountFile)));

            accountXmlAsString.substring(accountXmlAsString.indexOf("<Contact>"), accountXmlAsString.indexOf("</Contact>") + 10);

            parameters.add(contactXml.substring(contactXml.indexOf("<firstName>") + 11, contactXml.indexOf("</firstName>")));

            parameters.add(contactXml.substring(contactXml.indexOf("<lastName>") + 10, contactXml.indexOf("</lastName>")));
            
            parameters.add(contactXml.substring(contactXml.indexOf("<email>") + 7, contactXml.indexOf("</email>")));

            parameters.add(contactXml.substring(contactXml.indexOf("<phone>") + 7, contactXml.indexOf("</phone>")));

            this.acctClient = new Contact(parameters);
            parameters.clear();

            accountAddresses[] = {
                accountXmlAsString.substring(accountXmlAsString.indexOf("<PhysicalAddress>") + 17, accountXmlAsString.indexOf("</PhysicalAddress")),
                accountXmlAsString.substring(accountXmlAsString.indexOf("<MailingAddress>") + 16, accountXmlAsString.indexOf("</MailingAddress")),
            };

            for( String address : accountAddresses){
                parameters.add(address.substring(address.indexOf("<street1>") + 9, address.indexOf("</street1>")));
                
                parameters.add(address.substring(address.indexOf("<street2>") + 9, address.indexOf("</street2>")));
                
                parameters.add(address.substring(address.indexOf("<city>") + 6, address.indexOf("</city>")));
                parameters.add(address.substring(address.indexOf("<state>") + 7, address.indexOf("</state>")));
                parameters.add(address.substring(address.indexOf("<zip>") + 5, address.indexOf("</zip>")));
                
                addresses.add(new Address(parameters));
                parameters.clear();
            }

            physicalAddress = addresses.get(0);
            mailingAddress = addresses.get(1);
            addresses = null;

            reservationsXMLString = accountXmlAsString.substring(accountXmlAsString.indexOf("<Reservations>[") + 15, accountXmlAsString.indexOf("]</Reservations>"));
            reservations[] = reservationsXMLString.split(", ");
            
            for( reservation : reservations)
                this.acctReservations.add(reservation);

         */
    }

    public String generateUniqueID(String prefix) {
        /*
         * Generate Random String
         * String.format("%s%s", prefix, Random String)
         */
        return "";
    }

    @Override
    public String toString(){

        return String.format("<Account>\n<accountID>%s</accountID>\n%s<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<Reservations>%s</Reservations>\n</Account>\n",this.acctID,this.acctClient.toString(),this.physicalAddress,this.mailingAddress,this.acctReservations.toString());
    }

}