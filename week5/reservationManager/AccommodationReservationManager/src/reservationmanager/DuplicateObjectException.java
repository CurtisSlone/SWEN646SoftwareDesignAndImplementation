package reservationmanager;

public class DuplicateObjectException extends RuntimeException {
    public DuplicateObjectException(String message){
        super(message);
    }
}
