package com.manager;

import java.util.List;
import java.util.stream.Collectors;

interface ParameterValidator {
    /*
     * Validate parameters for objects
     */

    default boolean validateParameters(List<Object> type, List<Object> parameters){
        /*
         * Get classes from all elements of type and parameters list
         * Compare the two lists
         * return boolean for if equal or not
         */
        type = type.stream().map(x -> x.getClass().toString()).collect(Collectors.toList());
        parameters = parameters.stream().map(x -> x.getClass().toString()).collect(Collectors.toList());
        return type.equals(parameters);
    }
}
