
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Hotel extends Reservation {
    protected boolean hasKitchenette; //Bool if Hotel as Kitchenette
    protected boolean isValidHotel;  //Bool if Hotel is valid
    
    /**
     * Default empty object constructor
     */
    public Hotel(String accountID){
        super(accountID);
    }

    /**
     * Default new object constructor
     */
    public Hotel( ReservationType type, String accountID){
        super(type, accountID);
    }

    private boolean _checkIfValidHotel(){
        /*
         * return for isValid Hotel before saving object
         */
        return (this.numberOfBeds == 2 && this.numberOfRooms == 1) ? true : false;
    }

    @Override
    public void loadObjectFromFile(String identifierString) {
       /* super.loadObjectFromFile(identifierString);

        this.hasKitchenette = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasKitchenette>") + 16, this.childXml.indexOf("</hasKitchenette>")));
        this.childXml = "";
     */
    }

    @Override
    public void saveCurrentObject() {
        /*
            if(!this._checkIfValidHotel())
                throw new Exception();
            super.saveCurrentObject();
         */
    }

    @Override
    public String toString() {
        
        return String.format("<HotelReservation>\n%s\n<hasKitchenette>%s</hasKitchenette>\n</HotelReservation>",super.toString(), String.valueOf(this.hasKitchenette)) ;
    }

}