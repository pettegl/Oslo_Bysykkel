import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Petter Glad-Ørbak on 27.01.2019.
 */
public class BysykkelApplication
{
    private static final String client_id = "ENTER YOUR CLIENT-IDENTIFICATION HERE";
    private static BysykkelAPI api;

    public static void main(String[] args) throws Exception
    {
        try {
            api = new BysykkelAPI(client_id);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Hold the responses from the API.
        HttpResponse<JsonNode> stations = api.getStations();
        HttpResponse<JsonNode> availability = api.getAvailability();

        Gson gsonObject = new Gson();
        Gson gsonObject2 = new Gson();

        // Use GSON to parse JSON to Java-objects.
        StationService stationsHolder = gsonObject.fromJson(stations.getBody().getObject().toString(),StationService.class);
        StationService availabilityHolder = gsonObject2.fromJson(availability.getBody().getObject().toString(),StationService.class);

        HashMap<Long, String> stationsMap = new HashMap<Long, String>();
        HashMap<Long, int[]> stationAvailability = new HashMap<Long, int[]>();

        // Map stations and title using the "id" JSON-field as key.
        for(Station st : stationsHolder.getStations())
        {
            if(!stationsMap.containsKey(st.getId()))
            {
                stationsMap.put(st.getId(), st.getTitle()+ " " + st.getSubtitle());
            }
        }

        // Map availability of stations using the "id" JSON-field as key.
        for(Station av : availabilityHolder.getStations())
        {
            if(!stationAvailability.containsKey(av.getId()))
            {
                stationAvailability.put(av.getId(), new int[]{av.getAvailability().getBikes(),av.getAvailability().getLocks()});
            }
        }

        // Aggregate the maps into one list for displaying purposes.
        List<String> aggregatedList = aggregateResponseMaps(stationsMap, stationAvailability);

        // Print the list to console.
        for(String s : aggregatedList)
        {
            System.out.println(s);
        }


    }
    public static List<String> aggregateResponseMaps(HashMap<Long, String> stationsMap, HashMap<Long, int[]> stationAvailability)
    {
        List<String> tempList = new ArrayList<String>();
        for(Long id : stationsMap.keySet())
        {
            if (stationAvailability.containsKey(id))
            {
                tempList.add(
                        "ID: " + id +
                                " | Navn: " + stationsMap.get(id) +
                                " | Sykler: " + stationAvailability.get(id)[0] +
                                " | Låser: " + stationAvailability.get(id)[1]);


            }
            else
            {
                continue;
            }
        }
        return tempList;
    }

}
