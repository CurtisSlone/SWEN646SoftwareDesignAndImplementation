package reservationmanager;

public class IllegalOperationException extends RuntimeException {
    public IllegalOperationException(String message){
        super(message);
    }
}
