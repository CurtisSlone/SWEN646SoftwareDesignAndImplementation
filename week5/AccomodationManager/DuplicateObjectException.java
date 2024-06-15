package reservationmanager;

class DuplicateObjectException extends RuntimeException {
    public DuplicateObjectException(String message){
        super(message);
    }
}
