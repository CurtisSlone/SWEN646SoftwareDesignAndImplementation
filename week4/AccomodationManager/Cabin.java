import java.util.List;

public class Cabin extends Reservation {
    protected boolean hasFullKitchen;
    protected boolean hasLoft;

    public Cabin( String accountID){
        super(accountID);
    }

    public Cabin( ReservationType type, String accountID){
        super(type, accountID);
    }
    
    @Override
    public float calculatePriceTotal(){
        float cabinFee = this.hasFullKitchen ? (20 + (5 * this.numberOfRooms)) : (5 * this.numberOfRooms);
        return this.BASEPRICE + this._calculateLodgingSizeFee() + cabinFee;
    };

    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        super.loadObjectFromFile(identifierString);

        this.hasFullKitchen = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasFullKitchen>") + 16, this.childXml.indexOf("</hasFullKitchen>")));

        this.hasLoft = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasLoft>") + 9, this.childXml.indexOf("</hasLoft>")));

        this.childXml = "";
    }

    @Override
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        super.updateObjectFromParameters(parameters);
        this.hasFullKitchen = (Boolean)parameters.get(9);
        this.hasLoft = (Boolean)parameters.get(10);
    }
    
    @Override
    public String toString(){

        return String.format("<CabinReservation>\n%s\n<hasFullKitchen>%s</hasFullKitchen>\n<hasLoft>%s</hasLoft>\n</Cabinreservation>", super.toString(), String.valueOf(this.hasFullKitchen), String.valueOf(this.hasLoft));
    }
}
