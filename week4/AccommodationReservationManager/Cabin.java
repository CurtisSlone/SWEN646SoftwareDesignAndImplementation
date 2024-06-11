
import java.util.*;

/**
 * @author Curtis Slone
 */
public class Cabin extends Reservation {

    protected boolean hasFullKitchen; //Bool if Cabin has full kitchen
    protected boolean hasLoft; //Bool if Cabin has loft

    /**
     * Blank Object Constructor
     */
    public Cabin(String accountId) {
        super(accountId);
    }

    /**
     * New Object Constructor
     */
    public Cabin(ReservtionType type, String accountId) {
        super(type, accountId);
    }

    @Override
    public float calculatePriceTotal(){
        float cabinFee = this.hasFullKitchen ? (20 + (5 * this.numberOfRooms)) : (5 * this.numberOfRooms);
        return this.BASEPRICE + this._calculateLodgingSizeFee() + cabinFee;
    };

    @Override
    public void loadObjectFromFile(String identifierString){
        super.loadObjectFromFile(identifierString);

        /*
            this.hasFullKitchen = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasFullKitchen>") + 16, this.childXml.indexOf("</hasFullKitchen>")));

            // this.hasLoft = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasLoft>") + 9, this.childXml.indexOf("</hasLoft>")));

            this.childXml = ""; 
        */
    }

    @Override
    public String toString(){

        return String.format("<CabinReservation>\n%s\n<hasFullKitchen>%s</hasFullKitchen>\n<hasLoft>%s</hasLoft>\n</Cabinreservation>", super.toString(), String.valueOf(this.hasFullKitchen), String.valueOf(this.hasLoft));
    }

}