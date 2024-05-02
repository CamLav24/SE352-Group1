import lombok.*;

@Data
@NoArgsConstructor
public class Locations {
    @Getter
    @Setter
    private int location_id;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private int zip_code;
    public Locations(int location_id, String address, String city, String state, String country, int zip_code){
        this.location_id = location_id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip_code = zip_code;
    }

    public int getZipCode() {
        return this.zip_code;
    }
    public int getLocationId(){
        return this.location_id;
    }
}
