import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*

 @ Generated by http://www.jsonschema2pojo.org/

 */

public class StationService {

    @SerializedName("stations")
    @Expose
    private List<Station> stations = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public StationService() {
    }

    /**
     *
     * @param stations
     */
    public StationService(List<Station> stations) {
        super();
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

}