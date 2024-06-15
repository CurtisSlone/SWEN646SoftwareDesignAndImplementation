package reservationmanager;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Cabin extends Reservation {

    /*
    * Cabin attribute
    */
    protected boolean hasFullKitchen;
    protected boolean hasLoft;
    public static List<Object> validationParameters = Arrays.asList(new Address(), new Address() ,new Date(),false,0,0,0,0,0,0, true, true);

    // Default Constructor
    public Cabin( ReservationType type, String accountID){
        super(type, accountID);
    }
    
    // Override calculate price
    @Override
    public float calculatePriceTotal(){
        //determine fee based on unique parameters
        return this.BASEPRICE + this._calculateLodgingSizeFee() + (this.hasFullKitchen ? (20 + (5 * this.numberOfRooms)) : (5 * this.numberOfRooms));
    };

    // Override loadObjectFromFile interface method
    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        /*
         * Call Super
         * assign child attributes using childxml string
         */
        super.loadObjectFromFile(identifierString);

        //hasFullKitchen
        this.hasFullKitchen = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasFullKitchen>") + 16, this.childXml.indexOf("</hasFullKitchen>")));

        //hasLoft
        this.hasLoft = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasLoft>") + 9, this.childXml.indexOf("</hasLoft>")));

        //reset childxml attribute
        this.childXml = "";
    }

    // Override updateObjectFromParameters interface method
    @Override
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        /*
         * Call Super
         * assign child attributes using childxml string
         */
        super.updateObjectFromParameters(parameters);
        if(!this.validateParameters(Cabin.validationParameters, parameters))
            throw new IllegalArgumentException("The included parameters were incorrect.");
        this.hasFullKitchen = (Boolean)parameters.get(9);
        this.hasLoft = (Boolean)parameters.get(10);
    }
    
    //Override Object.toString()
    @Override
    public String toString(){

        return String.format("<CabinReservation>\n%s\n<hasFullKitchen>%s</hasFullKitchen>\n<hasLoft>%s</hasLoft>\n</Cabinreservation>", super.toString(), String.valueOf(this.hasFullKitchen), String.valueOf(this.hasLoft));
    }
}
