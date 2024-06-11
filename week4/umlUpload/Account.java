
public class Account implements ParseXML {
    private String acctID;
    protected Contact acctClient;
    protected List<Address> addressList;
    protected List<String> acctReservations;

    public Account(){
        this.acctID = "-99";
        this.acctReservations = new ArrayList<String>();
        this.addressList = new ArrayList<Address>();
    }

    public Account(List<Object> parameters) {
        this.acctID = this.generateUniqueID("A");
        this.acctClient = (Contact)parameters.get(0);
        this.addressList.add(0, (Address)parameters.get(1));
        this.addressList.add(1, (Address)parameters.get(2));
        this.acctReservations = new ArrayList<String>(); 
    }

    protected String getAccountId(){
        return this.acctID;
    }

    protected List<String> getAccountReservations(){
        return this.acctReservations;
    }

    public void saveCurrentObject() throws Exception{
        String accountDirName = new String();
        String accountFileName = new String();
        
        char foutAccountInfo[] = this.toString().toCharArray();
        try {
            if(this.getAccountId() == "-99")
                throw new Exception();

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

    public void loadObjectFromFile(String identifierString) throws Exception {
        System.out.println(identifierString);
        String accountFile = new String();
        String accountXmlAsString = new String();
        List<Object> parameters = new ArrayList<Object>();
        List<Address> addresses = new ArrayList<Address>();
        try {
            this.acctID = identifierString;
            accountFile = String.format("./accounts/%s/acc-%s.xml", identifierString,identifierString);
            accountXmlAsString = new String(Files.readAllBytes(Paths.get(accountFile)));

            String contactXml = accountXmlAsString.substring(accountXmlAsString.indexOf("<Contact>"), accountXmlAsString.indexOf("</Contact>") + 10);
            
            parameters.add(contactXml.substring(contactXml.indexOf("<firstName>") + 11, contactXml.indexOf("</firstName>")));

            parameters.add(contactXml.substring(contactXml.indexOf("<lastName>") + 10, contactXml.indexOf("</lastName>")));
            
            parameters.add(contactXml.substring(contactXml.indexOf("<email>") + 7, contactXml.indexOf("</email>")));

            parameters.add(contactXml.substring(contactXml.indexOf("<phone>") + 7, contactXml.indexOf("</phone>")));

            this.acctClient = new Contact(parameters);
            
            parameters.clear();

            String accountAddresses[] = {
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

            this.addressList.add(0, addresses.get(0));
            this.addressList.add(1, addresses.get(1));
            addresses.clear();

            String reservationsXMLString = accountXmlAsString.substring(accountXmlAsString.indexOf("<Reservations>[") + 15, accountXmlAsString.indexOf("]</Reservations>"));
            String reservations[] = reservationsXMLString.split(", ");
            
            for( String reservation : reservations)
                this.acctReservations.add(reservation);
                

            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    };
    
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        this.acctClient = (Contact)parameters.get(0);
        this.addressList.clear();
        this.addressList.add(0, (Address)parameters.get(1));
        this.addressList.add(1, (Address)parameters.get(2));
        this.acctReservations.clear();
        String reservationString = (String)parameters.get(3);
        reservationString = reservationString.replaceAll("[\\[\\](){}]","");
        String reservations[] = reservationString.split(", ");

        for( String reservation : reservations)
            this.acctReservations.add(reservation);
                
    }

    public void deleteFileFromID(String identifierString) throws Exception {
        throw new Exception();
    }

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

        return String.format("<Account>\n<accountID>%s</accountID>\n%s<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<Reservations>%s</Reservations>\n</Account>\n",this.acctID,this.acctClient.toString(),this.addressList.get(0).toString(),this.addressList.get(1).toString(),this.acctReservations.toString());
    }
}