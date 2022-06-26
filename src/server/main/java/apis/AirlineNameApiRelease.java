package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.airlinename.AirlineNameApiUtil;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Documentation: https://airlabs.co/docs/
 */
public class AirlineNameApiRelease implements AirlineNameApi {


    private WebClient webClient;

    public AirlineNameApiRelease() {
        webClient = WebClient.builder().defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
    }

    /**
     * @param airline_icao takes the ICAO_CODE of a given Airline and return the corresponding Airline name/AirlineNameApiUtil
     * @return AirlineNameApiUtil
     */
    @Override
    public AirlineNameApiUtil getAirlineName(String airline_icao) {
        try {
            String res = webClient.get()
                    .uri(new URI(("https://airlabs.co/api/v9/airlines?icao_code=" + airline_icao + "&api_key=f6753372-61ae-40c3-85ed-2333a7ea8b15")))
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorStop()
                    .block();
            return AirlineNameApi.jsonStringToJavaClass(res);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}