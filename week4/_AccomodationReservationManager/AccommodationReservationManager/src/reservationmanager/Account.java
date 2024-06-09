package reservationmanager;

import java.util.List;
import java.util.ArrayList;
import java.lang.Exception;

public class Account {
    private String acctID;
    protected Contact acctClient;
    protected List<Address> acctAddresses;
    protected List<String> acctReservations;

    public Account(String accountID, Contact client, List<Address>addresses ) throws Exception {
        this.acctID = accountID != null ? accountID : "-99";
        this.acctClient = client;
        this.acctAddresses = addresses;
        this.acctReservations = new ArrayList<String>();
    }

    private void _loadReservations() throws Exception {
        /*
         * create new ArrayList<String>
         * enumerate filenames in account directory if this.acctID != -99
         * add filenames as reservation IDs to ArrayList<String>
         */
        this.acctReservations = new ArrayList<String>();
    }

    public String getAccountId(){
        return this.acctID;
    }

    public List<String> getAccountReservations(){
        return this.acctReservations;
    }

    
    @Override
    public String toString(){

        return String.format("<Account>\n<accountID>%s</accountID>\n%s<PhysicalAddress>%s</PhysicalAddress>\n<MailingAddress>%s</MailingAddress>\n<Reservations>%s</Reservations>\n</Account>\n",this.acctID,this.acctClient.toString(),this.acctAddresses.get(0),this.acctAddresses.get(1),this.acctReservations.toString());
    }
}
