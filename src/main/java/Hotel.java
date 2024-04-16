import lombok.Getter;
import lombok.Setter;

public class Hotel {
    // for tests ONLY
    @Setter
    @Getter
    private long id;
    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    String city;

    @Setter
    @Getter
    private int rating;

    public Hotel(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }



    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Hotel {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}
