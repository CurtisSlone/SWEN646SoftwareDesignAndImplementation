package reservationmanager;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Account {
    private String acctID;
    protected Contact acctClient;
    protected List<Address> acctAddresses;
    private List<String> acctReservations;

    public Account(String accountID, Contact client, List<Address>addresses ){
        this.acctID = accountID != null ? accountID : "-99";
        this.acctClient = client;
        this.acctAddresses = addresses;
        this.acctReservations = this._loadReservations();
    }

    private List<String> _loadReservations(){
        /*
         * create new ArrayList<String>
         * enumerate filenames in account directory if this.acctID != -99
         * add filenames as reservation IDs to ArrayList<String>
         */
        return new ArrayList<String>();
    }

    public String getAccountId(){
        return this.acctID;
    }

    public List<String> getAccountReservations(){
        return this.acctReservations;
    }
    
    @Override
    public String toString(){

        return "";
    }
}
