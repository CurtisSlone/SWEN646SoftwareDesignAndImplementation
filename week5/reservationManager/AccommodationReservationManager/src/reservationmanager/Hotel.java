package reservationmanager;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Hotel extends Reservation {
    
    /*
    * hotel attributes
    */
    protected boolean hasKitchenette;
    protected boolean isValidHotel;
    public static List<Object> validationParameters = Arrays.asList(new Address(), new Address() ,new Date(),false,0,0,0,0,0,0,true);

    // Default Constructor
    public Hotel( ReservationType type, String accountID){
        super(type, accountID);
    }
   
    //Check if isValidHotel
    private boolean _checkIfValidHotel(){
        return (this.numberOfBeds == 2 && this.numberOfRooms == 1) ? true : false;
    }

    // Override calculate price
    @Override
    public float calculatePriceTotal(){
        float hotelFee = this.hasKitchenette ? 60 : 50;
        return this.BASEPRICE + this._calculateLodgingSizeFee() + hotelFee;
    };

    // Override loadObjectFromFile interface method
    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        /*
         * Call Super
         * assign child attributes using childxml string
         */
        super.loadObjectFromFile(identifierString);
        //hasKitchenette
        this.hasKitchenette = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasKitchenette>") + 16, this.childXml.indexOf("</hasKitchenette>")));
        //Reset childxml
        this.childXml = "";
    }

    // Overrise saveCurrentObject to check if isValidHotel
    @Override
    public void saveCurrentObject() throws Exception{ 
        
        if(!this._checkIfValidHotel())
            throw new Exception();
        super.saveCurrentObject();
    }

    // Override updateObjectFromParameters interface method
    @Override
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        /*
         * Call Super
         * assign child attributes using childxml string
         */
        if(!this.validateParameters(Hotel.validationParameters, parameters))
            throw new IllegalArgumentException("The included parameters were incorrect.");
        super.updateObjectFromParameters(parameters);
        this.hasKitchenette = (Boolean)parameters.get(9);
    }

    /*
    * Override Object.toSTring() Output as XML
    */ 
    @Override
    public String toString() {
        
        return String.format("<HotelReservation>\n%s\n<hasKitchenette>%s</hasKitchenette>\n</HotelReservation>",super.toString(), String.valueOf(this.hasKitchenette)) ;
    }
}
