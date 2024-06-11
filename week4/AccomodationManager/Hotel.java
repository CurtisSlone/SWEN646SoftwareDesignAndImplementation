import java.util.List;

public class Hotel extends Reservation {
    
    protected boolean hasKitchenette;
    protected boolean isValidHotel;

    public Hotel(String accountID){
        super(accountID);
    }
    public Hotel( ReservationType type, String accountID){
        super(type, accountID);
    }
   
    private boolean _checkIfValidHotel(){
        return (this.numberOfBeds == 2 && this.numberOfRooms == 1) ? true : false;
    }

    @Override
    public float calculatePriceTotal(){
        float hotelFee = this.hasKitchenette ? 60 : 50;
        return this.BASEPRICE + this._calculateLodgingSizeFee() + hotelFee;
    };

    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        super.loadObjectFromFile(identifierString);

        this.hasKitchenette = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasKitchenette>") + 16, this.childXml.indexOf("</hasKitchenette>")));
        this.childXml = "";
    }

    @Override
    public void saveCurrentObject() throws Exception{ 
        
        if(!this._checkIfValidHotel())
            throw new Exception();
        super.saveCurrentObject();
    }

    @Override
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        super.updateObjectFromParameters(parameters);
        this.hasKitchenette = (Boolean)parameters.get(9);
    }

    @Override
    public String toString() {
        
        return String.format("<HotelReservation>\n%s\n<hasKitchenette>%s</hasKitchenette>\n</HotelReservation>",super.toString(), String.valueOf(this.hasKitchenette)) ;
    }
}
