



import reservationmanager.Manager;
public class App {
    public static void main(String[] args) throws Exception {
        Manager reservationApp = new Manager();
        reservationApp.createNewContact("Terry", "Smith", "tsmith@gmail.com", "111-111-1111");
        // System.out.println(reservationApp.viewCurrentContactObject());
        reservationApp.createNewAddress("178 old 30 rd", "", "Nashville", "TN", "27505");
        // System.out.println(reservationApp.viewAddressObject("CurrentAddress"));
        reservationApp.saveCurrentAddress("PhysicalAddress");
        // System.out.println(reservationApp.viewAddressObject("PhysicalAddress"));
        reservationApp.createNewAccount(true, true, true);
        // System.out.println(reservationApp.viewCurrentAccountObject());
        
        
    }    
}
