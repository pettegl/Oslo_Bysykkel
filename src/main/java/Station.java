import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Petter Glad-Ørbak on 27.01.2019.
 */
public class Station
{
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("number_of_locks")
    @Expose
    private int number_of_locks;
    @SerializedName("availability")
    @Expose
    private Availability availability;

    public Station(Long id, String title, String subtitle, Availability availability)
    {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.availability = availability;
        this.number_of_locks = number_of_locks;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle ()
    {
        return this.title;
    }

    public void setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }

    public String getSubtitle()
    {
        return subtitle;
    }

    public void setNumber_of_locks(int number_of_locks)
    {
        this.number_of_locks = number_of_locks;
    }

    public int getNumber_of_locks()
    {
        return this.number_of_locks;
    }

    public void setAvailability(int bikes, int locks)
    {
        this.availability.bikes = bikes;
        this.availability.locks = locks;
    }

    public Availability getAvailability()
    {
        return this.availability;
    }

    public class Availability {
        private int bikes;
        private int locks;

        public Availability(int bikes, int locks)
        {
            this.bikes = bikes;
            this.locks = locks;
        }
        public void setBikes(int bikes)
        {
            this.bikes = bikes;
        }
        public int getBikes()
        {
            return this.bikes;
        }
        public void setLocks(int locks)
        {
            this.locks = locks;
        }
        public int getLocks()
        {
            return this.locks;
        }


    }


}
