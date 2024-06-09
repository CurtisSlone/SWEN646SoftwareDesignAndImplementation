import reservationmanager.Manager;
import reservationmanager.ReservationType;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Manager reservationApp = new Manager();
        // reservationApp.createNewContact("Terry", "Smith", "tsmith@gmail.com", "111-111-1111");
        // System.out.println(reservationApp.viewCurrentContactObject());
        // reservationApp.createNewAddress("178 old 30 rd", "", "Nashville", "TN", "27505");
        // System.out.println(reservationApp.viewAddressObject("CurrentAddress"));
        // reservationApp.saveCurrentAddress("PhysicalAddress");
        // System.out.println(reservationApp.viewAddressObject("PhysicalAddress"));
        // reservationApp.createNewAccount(true, true, true);
        System.out.println(reservationApp.viewCurrentAccountObject());
        // reservationApp.saveCurrentAccountObject();
        System.out.println(reservationApp.listAllAccounts());
        // reservationApp.createNewReservation(ReservationType.HOUSE, true, true);
        
    }    

    public static List<Object> hotelReservationParameters(){
        List<Object> hotelParams = new ArrayList<Object>();

        return hotelParams;
    }

    public static List<Object> houseReservationParameters(){
        List<Object> houseParams = new ArrayList<Object>();

        return houseParams;
    }

    public static List<Object> cabinReservationParameters(){
        List<Object> cabinParams = new ArrayList<Object>();

        return cabinParams;
    }
}
