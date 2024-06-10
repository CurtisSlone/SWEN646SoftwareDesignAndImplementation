package reservationmanager;

import java.util.List;

public interface ParseXML {
    void saveCurrentObject() throws Exception;
    void generateNewObject(List<Object> parameters) throws Exception;
    void loadObjectFromFile(String identifierString) throws Exception;
    String generateUniqueID(String prefix);
    
}
