import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by Petter Glad-Ørbak on 27.01.2019.
 */
public class BysykkelAPI {

    private String client_id;
    private HttpResponse<JsonNode> stations;
    private HttpResponse<JsonNode> availability;

    public BysykkelAPI(String client_id)
    {
        this.client_id = client_id;
        stations = setStations(client_id);
        availability = setAvailability(client_id);
    }

    public HttpResponse<JsonNode> setStations(String client_id)
    {
        try {
            System.out.println("Attempting to GET stations ..");
            HttpResponse<JsonNode> stations = Unirest.get("https://oslobysykkel.no/api/v1/stations")
                    .header("Client-Identifier", client_id)
                    .asJson();
            System.out.println("Response code: " + stations.getStatus());

            return stations;

        } catch(UnirestException ue)
        {
            ue.printStackTrace();
        }
        return null;
    }

    private HttpResponse<JsonNode> setAvailability(String client_id)
    {
        try {
            System.out.println("Attempting to GET stations/availability ..");
            HttpResponse<JsonNode> availability = Unirest.get("https://oslobysykkel.no/api/v1/stations/availability")
                    .header("Client-Identifier", client_id)
                    .asJson();
            System.out.println("Response code: " + availability.getStatus());

            return availability;

        } catch(UnirestException ue)
        {
            ue.printStackTrace();
        }
        return null;
    }

    public HttpResponse<JsonNode> getStations()
    {
        return stations;
    }

    public HttpResponse<JsonNode> getAvailability()
    {
        return availability;
    }
}
