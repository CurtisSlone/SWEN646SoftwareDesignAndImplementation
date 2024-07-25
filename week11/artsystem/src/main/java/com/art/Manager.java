package com.art;

import java.util.Random;

public class Manager {

    public Manager(){}

    public String generateUniqueID(){
        /*
         * Create unique ID
         * Stringbuilder to build random charachters
         */
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s", random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(9)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };
}
