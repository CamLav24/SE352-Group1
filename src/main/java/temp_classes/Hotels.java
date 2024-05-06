import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class Hotels {
    private Integer hotelId;

    private String name;

    private Integer locationId;

    private BigDecimal price;

    private Integer roomsLeft;

    private String description;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRoomsLeft() {
        return roomsLeft;
    }

    public void setRoomsLeft(Integer roomsLeft) {
        this.roomsLeft = roomsLeft;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}