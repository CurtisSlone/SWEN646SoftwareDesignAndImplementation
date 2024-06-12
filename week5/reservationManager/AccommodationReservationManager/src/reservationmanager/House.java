package reservationmanager;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class House extends Reservation implements ParameterValidator {
    /*
    * House attribute
    */
    protected int numberOfFloors;
    public static List<Object> validationParameters = Arrays.asList(new Address(), new Address() ,new Date(),false,0,0,0,0,0,0);

    //Default Constructor
    public House( ReservationType type, String accountID){
        super(type, accountID);
    }
 
    // Override loadObjectFromFile interface method
    @Override
    public void loadObjectFromFile(String identifierString) throws Exception{
        /*
         * Call Super
         * assign child attributes using childxml string
         */
        super.loadObjectFromFile(identifierString);

        //numberOfFloors
        this.numberOfFloors = Integer.valueOf(this.childXml.substring(this.childXml.indexOf("<numberOfFloors>") + 16, this.childXml.indexOf("</numberOfFloors>")));

        //Reset child xml
        this.childXml = "";
    }

    // Override updateObjectFromParameters interface method
    @Override
    public void updateObjectFromParameters(List<Object> parameters) throws Exception {
        /*
         * Call Super
         * assign child attributes using childxml string
         */
        if(!this.validateParameters(Reservation.validationParameters, parameters))
            throw new IllegalArgumentException("The included parameters were incorrect.");
        super.updateObjectFromParameters(parameters);
        this.numberOfFloors = (Integer)parameters.get(9);
    }

    @Override
    public String toString(){
        return String.format("<HotelReservation>\n%s\n<numberOfFloors>%s</numberOfFloors>\n</HotelReservation>\n", super.toString(), String.valueOf(this.numberOfFloors));
    }
}