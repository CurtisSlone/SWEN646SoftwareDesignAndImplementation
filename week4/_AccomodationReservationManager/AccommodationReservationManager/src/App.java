import reservationmanager.Manager;
import reservationmanager.ReservationType;

import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    private static List<Object> reservationParameters() throws Exception{
        List<Object> reservationParams = new ArrayList<Object>();

        Scanner newReservationScanner = new Scanner(System.in);
        //Date Operations
        System.out.print("yyyy: ");
        String dateYear = newReservationScanner.nextLine();
        System.out.print("MM: ");
        String dateMonth = newReservationScanner.nextLine();
        System.out.print("dd: ");
        String dateDay = newReservationScanner.nextLine();
        String dateFormat = String.format("%s-%s-%s 12:00:23",dateYear,dateMonth,dateDay);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        // End Date Opeerations

        Date startDate = simpleDateFormat.parse(dateFormat);
        System.out.print("numNights: ");
        int numNights = newReservationScanner.nextInt();
        System.out.print("numBeds: ");
        int numBeds = newReservationScanner.nextInt();
        System.out.print("numRooms: ");
        int numRooms = newReservationScanner.nextInt();
        System.out.print("numBaths: ");
        int numBaths = newReservationScanner.nextInt();
        System.out.print("lodgingSize: ");
        int lodgingSize = newReservationScanner.nextInt();
        newReservationScanner.close();

        return reservationParams;
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
