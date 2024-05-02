import lombok.Getter;
import lombok.Setter;

public class Hotel {
    // for tests ONLY
    @Setter
    @Getter
    private long Hotel_Id;
    @Getter
    @Setter
    private String Hotel_Name;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private long Location_Id;

    @Setter
    @Getter
    private int Rooms_left;

    public Hotel(long id, String name, String description, long location, int room) {
        this.Hotel_Id = id;
        this.Hotel_Name = name;
        this.description = description;
        this.Location_Id = location;
        this.Rooms_left = room;
    }


    @Override
    public String toString() {
        return "Hotel {" +
                "Hotel Id=" + Hotel_Id +
                ",Hotel name='" + Hotel_Name + '\'' +
                ", description='" + description + '\'' +
                ", Location Id='" + Location_Id + '\'' +
                ", Rooms Left=" + Rooms_left +
                '}';
    }
}
