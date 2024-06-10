package reservationmanager;
 
public class Hotel extends Reservation {
    
    protected boolean hasKitchenette;
    protected boolean isValidHotel;

    public Hotel(String accountID){
        super(accountID);
    }
    public Hotel( ReservationType type, String accountID){
        super(type, accountID);
    }
    // this.hotelFee = this.hasKitchenette ? 60 : 50;
    public boolean checkIfValidHotel(){
        return (this.numberOfBeds == 2 && this.numberOfRooms == 1) ? true : false;
    }

    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        super.loadObjectFromFile(identifierString);

        this.hasKitchenette = Boolean.getBoolean(this.childXml.substring(this.childXml.indexOf("<hasKitchenette>") + 16, this.childXml.indexOf("</hasKitchenette>")));

        this.childXml = "";
    }

    @Override
    public String toString() {
        
        return String.format("<HotelReservation>\n%s\n<hasKitchenette>%s</hasKitchenette>\n</HotelReservation>",super.toString(), String.valueOf(this.hasKitchenette)) ;
    }
}
