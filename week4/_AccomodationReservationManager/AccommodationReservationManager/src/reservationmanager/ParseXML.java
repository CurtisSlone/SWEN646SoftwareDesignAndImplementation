package reservationmanager;

public interface ParseXML {
    void saveCurrentObject() throws Exception;
    void loadObjectFromFile(String identifierString) throws Exception;
    String generateUniqueID(String prefix);
    
}
