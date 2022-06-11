package apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.api.airline.AirlineAPI;

public interface AirlinesAPI {

    AirlineAPI getFlightData(String formDep_iata, String toArr_iata);

    static AirlineAPI jsonStringToJavaClass(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, AirlineAPI.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
