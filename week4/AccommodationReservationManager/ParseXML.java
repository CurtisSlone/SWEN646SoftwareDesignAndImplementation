
import java.util.*;

/**
 * 
 */
public interface ParseXML {

    /**
     * @return
     */
    public void saveCurrentObject();

    /**
     * @param identifierString 
     * @return
     */
    public void loadCurrentObject(String identifierString);

    /**
     * @return
     */
    public String generateUniqueID();

}