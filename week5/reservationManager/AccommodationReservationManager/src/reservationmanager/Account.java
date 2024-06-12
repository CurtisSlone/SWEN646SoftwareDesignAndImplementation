package reservationmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.lang.Exception;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Account implements ParseXML {
    private String acctID;
    protected Contact acctClient;
    protected List<Address> addressList;
    protected List<String> acctReservations;

    /*
     * Default Constructor
     */
    public Account(){
        this.acctID = "-99";
        this.acctReservations = new ArrayList<String>();
        this.addressList = new ArrayList<Address>();
        this.acctReservations = new ArrayList<String>(); 
    }

    /*
     * Return this account id
     */
    protected String getAccountId(){
        return this.acctID;
    }

    /*
     * return reservations associated with account as ArrayList
     */
    protected List<String> getAccountReservations(){
        return this.acctReservations;
    }


    /*
     * Save Account Object To File
     */
    public void saveCurrentObject() throws Exception{
        /*
         * Local Variables
         */
        String accountDirName = new String();
        String accountFileName = new String();
        char foutAccountInfo[] = this.toString().toCharArray();
        try {
            /*
             * If not acctID, generate new UniqueID
             */
            if(this.getAccountId() == "-99")
                this.acctID = this.generateUniqueID("A");

            /*
             * Get directory
             * If directory doesn't exist, create
             * Write Account object to file
             * Save file in directory
             */
            accountDirName = String.format("./accounts/%s",this.getAccountId());
            accountFileName = String.format("%s/acc-%s.xml", accountDirName, this.getAccountId());

            File accountDir = new File(accountDirName);
            if(!accountDir.exists())
                accountDir.mkdir();
            accountDir = null;

            FileOutputStream writeAccountToFile = new FileOutputStream(accountFileName, false);

            for( char c : foutAccountInfo)
                writeAccountToFile.write(c);
            writeAccountToFile.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    /*
     * Load Account Attributes From XML File
     */
    public void loadObjectFromFile(String identifierString) throws Exception {
        /*
         * Local Variables
         */
        String accountFile = new String();
        String accountXmlAsString = new String();
        List<String> parameters = new ArrayList<String>();

        try {
            //Change account ID to match File
            this.acctID = identifierString;

            /*
             * Open file, extract text
             */
            accountFile = String.format("./accounts/%s/acc-%s.xml", identifierString,identifierString);
            accountXmlAsString = new String(Files.readAllBytes(Paths.get(accountFile)));

            /*
             * Parse Contact from xml 
             * Create Contact Object
             * Clear parameters for next Object
             */
            Collections.addAll(parameters, accountXmlAsString.substring(accountXmlAsString.indexOf("<Contact>"), accountXmlAsString.indexOf("</Contact>") + "</Contact>".length()).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x == "");
            this.acctClient = new Contact(parameters);
            parameters.clear();

            /*
             * Parse Physical Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            Collections.addAll(parameters,accountXmlAsString.substring(accountXmlAsString.indexOf("<PhysicalAddress>") + "<PhysicalAddress>".length(), accountXmlAsString.indexOf("</PhysicalAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x == "");
            this.addressList.add(new Address(parameters));
            parameters.clear();

            /*
             * Parse Mailing Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            Collections.addAll(parameters,accountXmlAsString.substring(accountXmlAsString.indexOf("<MailingAddress>") + "<MailingAddress>".length(), accountXmlAsString.indexOf("</MailingAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x == "");
            this.addressList.add(new Address(parameters));
            parameters.clear();

            /*
             * Parse RservationIDs from XML
             * Add to this.acctReservations
             */
            Collections.addAll(this.acctReservations, accountXmlAsString.substring(accountXmlAsString.indexOf("<Reservations>[") + 15, accountXmlAsString.indexOf("]</Reservations>")).split(", "));
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    };
    
    /*
     * Update Current Account Object With new attributes
     */
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        /*
         * Update Object from parameters
         */
        this.acctClient = (Contact)parameters.get(0);
        this.addressList.clear();
        this.addressList.add(0, (Address)parameters.get(1));
        this.addressList.add(1, (Address)parameters.get(2));
        this.acctReservations.clear();
        String reservationString = (String)parameters.get(3);
        Collections.addAll(this.acctReservations,reservationString.replaceAll("[\\[\\](){}]","").split(", "));       
    }

    /*
     * Delete Operation from ParseXML Interface
     */
    public void deleteFileFromID(String identifierString) throws Exception {
        /*
         * Cannot delete account
         * Throw Exception
         */
        throw new Exception();
    }

    /*
     * Generate Unique Account ID Operation From ParseXML Interface
     */
    public String generateUniqueID(String prefix){
        /*
         * Create unique ID
         * take prefix as string
         * Stringbuilder to build random charachters
         */
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s%s", prefix, random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(9)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };
 
        /*
         * Output as XML
         */ 
    @Override
    public String toString(){
        
        return String.format("<Account>\n<accountID>%s</accountID>\n%s<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<Reservations>%s</Reservations>\n</Account>\n",this.acctID,this.acctClient.toString(),this.addressList.get(0).toString(),this.addressList.get(1).toString(),this.acctReservations.toString());
    }
}