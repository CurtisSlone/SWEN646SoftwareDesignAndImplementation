

/**
 * 
 */
public interface ParseXML {

    /**
     * Saves current object to XML file
     */
    public void saveCurrentObject();

    /**
     * Loads xml file as object
     */
    public void loadCurrentObject(String identifierString);

    /**
     * Generates Unique ID for Object
     */
    public String generateUniqueID();

}