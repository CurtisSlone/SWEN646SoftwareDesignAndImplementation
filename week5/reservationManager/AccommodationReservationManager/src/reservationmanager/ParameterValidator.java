package reservationmanager;

import java.util.List;
import java.util.stream.Collectors;

public interface ParameterValidator {
    default boolean validateParameters(List<Object> type, List<Object> parameters){
        type = type.stream().map(x -> x.getClass().toString()).collect(Collectors.toList());
        parameters = parameters.stream().map(x -> x.getClass().toString()).collect(Collectors.toList());
        return type.equals(parameters);
    }
}
