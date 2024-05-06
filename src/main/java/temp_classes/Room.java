import lombok.Getter;
import lombok.Setter;

public class Room {
    // for tests ONLY
    @Setter
    @Getter
    private long room_id;
    @Getter
    @Setter
    private String room_name;

    @Setter
    @Getter
    private String room_description;

    @Setter
    @Getter
    private int popularity;

    public Room(String name, String room_name, String description, int popularity) {
        this.room_name = room_name;
        this.room_description = description;
        this.popularity = popularity;
    }




    @Override
    public String toString() {
        return "Room {" +
                ", name='" + room_name + '\'' +
                ", description='" + room_description + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}
