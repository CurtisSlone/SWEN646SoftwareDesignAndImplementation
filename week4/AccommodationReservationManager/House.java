
import java.util.*;

/**
 * @author Curtis Slone
 */
public class House extends Reservation {
    
    protected int numberOfFloors; // Number of Floors in House
    /**
     * Default Blannk Object constructor
     */
    public House(String accountID){
        super(accountID);
    }

    /**
     * Default New Object constructor
     */
    public House( ReservationType type, String accountID){
        super(type, accountID);
    }
    
    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        /* 
            super.loadObjectFromFile(identifierString);

            this.numberOfFloors = Integer.valueOf(this.childXml.substring(this.childXml.indexOf("<numberOfFloors>") + 16, this.childXml.indexOf("</numberOfFloors>")));

            this.childXml = "";
        */
    }

    @Override
    public String toString(){
        return String.format("<HotelReservation>\n%s\n<numberOfFloors>%s</numberOfFloors>\n</HotelReservation>\n", super.toString(), String.valueOf(this.numberOfFloors));
    }

}