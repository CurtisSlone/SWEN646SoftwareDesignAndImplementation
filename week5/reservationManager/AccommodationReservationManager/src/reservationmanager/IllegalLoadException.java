package reservationmanager;

public class IllegalLoadException extends RuntimeException {
    public IllegalLoadException(String message){
        super(message);
    }
}
