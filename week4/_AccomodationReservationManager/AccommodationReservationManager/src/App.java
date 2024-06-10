import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;
import reservationmanager.Manager;
import reservationmanager.ReservationType;

public class App {
    Scanner newReservationScanner;
    List<Object> paramList;
    public static void main(String[] args) throws Exception {
        App ui = new App();
        Manager reservatioManager = new Manager();
        ui.paramList = new ArrayList<Object>();
        ui.newReservationScanner = new Scanner(System.in);


        ui.newReservationScanner.close();
    }    

    public List<Object> reservationParameters(ReservationType type) throws Exception{
        List<Object> reservationParams = new ArrayList<Object>();

        //Date Operations
        System.out.print("yyyy: ");
        String dateYear = this.newReservationScanner.nextLine();
        System.out.print("MM: ");
        String dateMonth = this.newReservationScanner.nextLine();
        System.out.print("dd: ");
        String dateDay = this.newReservationScanner.nextLine();
        String dateFormat = String.format("%s-%s-%s 12:00:23",dateYear,dateMonth,dateDay);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        // End Date Opeerations

        Date startDate = simpleDateFormat.parse(dateFormat);
        reservationParams.add(startDate);
        System.out.print("numNights: ");
        int numNights = this.newReservationScanner.nextInt();
        reservationParams.add(numNights);
        System.out.print("numBeds: ");
        int numBeds = this.newReservationScanner.nextInt();
        reservationParams.add(numBeds);
        System.out.print("numRooms: ");
        int numRooms = this.newReservationScanner.nextInt();
        reservationParams.add(numRooms);
        System.out.print("numBaths: ");
        int numBaths = this.newReservationScanner.nextInt();
        reservationParams.add(numBaths);
        System.out.print("lodgingSize: ");
        int lodgingSize = this.newReservationScanner.nextInt();
        reservationParams.add(lodgingSize);
        

        switch (type) {
            case HOTEL:
                System.out.print("hasKitchenette: ");
                boolean hasKitchenette = this.newReservationScanner.nextBoolean();
                reservationParams.add(hasKitchenette);
                break;
                
            case HOUSE:
                System.out.println("NumberOfFloors: ");
                int numFloors = this.newReservationScanner.nextInt();
                reservationParams.add(numFloors);
                break;

            case CABIN:
                System.out.println("hasFullKitchen: ");
                boolean hasFullKitchen = this.newReservationScanner.nextBoolean();
                reservationParams.add(hasFullKitchen);
                System.out.println("hasLoft: ");
                boolean hasLoft = this.newReservationScanner.nextBoolean();
                reservationParams.add(hasLoft);
                break;

            default:
                break;
        }
        
        return reservationParams;
    }

}
