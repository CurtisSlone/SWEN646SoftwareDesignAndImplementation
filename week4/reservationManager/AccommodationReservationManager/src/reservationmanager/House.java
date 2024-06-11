package reservationmanager;

import java.util.List;

public class House extends Reservation {

    protected int numberOfFloors;

    public House(String accountID){
        super(accountID);
    }

    public House( ReservationType type, String accountID){
        super(type, accountID);
    }
 
    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        super.loadObjectFromFile(identifierString);

        this.numberOfFloors = Integer.valueOf(this.childXml.substring(this.childXml.indexOf("<numberOfFloors>") + 16, this.childXml.indexOf("</numberOfFloors>")));

        this.childXml = "";
    }

    @Override
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        super.updateObjectFromParameters(parameters);
        this.numberOfFloors = (Integer)parameters.get(9);
    }

    @Override
    public String toString(){
        return String.format("<HotelReservation>\n%s\n<numberOfFloors>%s</numberOfFloors>\n</HotelReservation>\n", super.toString(), String.valueOf(this.numberOfFloors));
    }
}