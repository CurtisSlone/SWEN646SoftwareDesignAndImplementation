package com.manager;

import java.util.List;
import java.util.Random;

interface ParseXML {
    void saveCurrentObject() throws Exception;
    void loadObjectFromFile(String identifierString) throws Exception;
    void updateObjectFromParameters(List<Object> parameters) throws Exception;
    void deleteFileFromID(String identifier) throws Exception;
    default String generateUniqueID(String prefix){
        /*
         * Create unique ID
         * take prefix as string
         * Stringbuilder to build random charachters
         */
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s%s", prefix, random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(9)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };
    
}
