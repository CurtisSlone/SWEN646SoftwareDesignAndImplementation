import java.util.List;

interface ParseXML {
    void saveCurrentObject() throws Exception;
    void loadObjectFromFile(String identifierString) throws Exception;
    void updateObjectFromParameters(List<Object> parameters) throws Exception;
    void deleteFileFromID(String identifier) throws Exception;
    String generateUniqueID(String prefix);
    
}
