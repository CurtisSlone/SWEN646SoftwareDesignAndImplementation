package reservationmanager;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Account implements ParseXML, ParameterValidator {
    private String acctID;
    protected Contact acctClient;
    protected List<Address> addressList;
    protected List<String> acctReservations;
    public static List<Object> validationParameters = Arrays.asList(new Contact(), new Address(), new Address(),"_");

    /*
     * Default Constructor
     */
    public Account(){
        this.acctID = "-99";
        this.acctReservations = new ArrayList<>();
        this.addressList = new ArrayList<>();
        this.acctReservations = new ArrayList<>(); 
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
        String accountDirName;
        String accountFileName;
        char foutAccountInfo[] = this.toString().toCharArray();
            /*
             * If not acctID, generate new UniqueID
             */
            if(this.getAccountId() == "-99" && this.acctClient != null && !this.addressList.isEmpty())
                this.acctID = this.generateUniqueID("A");
            
            if(this.getAccountId() == "-99" && this.acctClient == null && this.addressList.isEmpty())   
                throw new IllegalOperationException("The Account must have a Contact and Address to be saved");
            /*
             * Get directory
             * If directory doesn't exist, create
             * Write Account object to file
             * Save file in directory
             */
            accountDirName = String.format("./accounts/%s",this.getAccountId());
            accountFileName = String.format("%s/acc-%s.xml", accountDirName, this.getAccountId());

            File accountDir = new File(accountDirName);
            if(!accountDir.exists()){}
                accountDir.mkdir();

            FileOutputStream writeAccountToFile = new FileOutputStream(accountFileName, false);

            for( char c : foutAccountInfo)
                writeAccountToFile.write(c);
            writeAccountToFile.close();
    };

    /*
     * Load Account Attributes From XML File
     */
    public void loadObjectFromFile(String identifierString) throws Exception {
        /*
         * Local Variables
         */
        String accountFile;
        String accountXmlAsString;
        List<String> parameters;

            //Change account ID to match File
            this.acctID = identifierString;

            /*
             * Open file, extract text
             */
            accountFile = String.format("./accounts/%s/acc-%s.xml", identifierString,identifierString);
            File fileToCheck = new File(accountFile);

            if(!fileToCheck.exists())
                throw new IllegalLoadException("Account does not exist");

            accountXmlAsString = new String(Files.readAllBytes(Paths.get(accountFile)));

            /*
             * Parse Contact from xml 
             * Create Contact Object
             * Clear parameters for next Object
             */
            parameters = Arrays.asList(accountXmlAsString.substring(accountXmlAsString.indexOf("<Contact>"), accountXmlAsString.indexOf("</Contact>") + "</Contact>".length()).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf( x -> x.equals(""));
            this.acctClient = new Contact(parameters);

            /*
             * Parse Physical Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            parameters = Arrays.asList(accountXmlAsString.substring(accountXmlAsString.indexOf("<PhysicalAddress>") + "<PhysicalAddress>".length(), accountXmlAsString.indexOf("</PhysicalAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x.equals(""));
            this.addressList.add(new Address(parameters));

            /*
             * Parse Mailing Address from xml 
             * Create Address Object
             * Add to adressList List<Address>
             * Clear parameters for next Object
             */
            parameters = Arrays.asList(accountXmlAsString.substring(accountXmlAsString.indexOf("<MailingAddress>") + "<MailingAddress>".length(), accountXmlAsString.indexOf("</MailingAddress")).replaceAll("<(.*?)>", ",").split(","));
            parameters.removeIf(x -> x.equals(""));
            this.addressList.add(new Address(parameters));

            /*
             * Parse RservationIDs from XML
             * Add to this.acctReservations
             */
            this.acctReservations = Arrays.asList(accountXmlAsString.substring(accountXmlAsString.indexOf("<Reservations>[") + "<Reservations>[".length(), accountXmlAsString.indexOf("]</Reservations>")).split(", "));
            
    };
    
    /*
     * Update Current Account Object With new attributes
     */
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        /*
         * Validate Parameters
         */
        if(!this.validateParameters(Account.validationParameters, parameters))
            throw new IllegalArgumentException("The included parameters were incorrect.");
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
    public void deleteFileFromID(String identifierString) throws IllegalOperationException {
        /*
         * Cannot delete account
         * Throw Exception
         */
        throw new IllegalOperationException("Can not delete account.");
    }
 
        /*
         * Output as XML
         */ 
    @Override
    public String toString(){
        
        return String.format("<Account>\n<accountID>%s</accountID>\n%s<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<Reservations>%s</Reservations>\n</Account>\n",this.acctID,this.acctClient.toString(),this.addressList.get(0).toString(),this.addressList.get(1).toString(),this.acctReservations.toString());
    }
}