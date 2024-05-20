package cdm.depaul.edu.se352.group1.se352group1.hotelTesting;

import cdm.depaul.edu.se352.group1.se352group1.dao.Hotels;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class hotelTesting {

    @Test
    public void testHotelId() {
        Hotels hotel = new Hotels();
        hotel.setHotelId(1);
        assertEquals(1, hotel.getHotelId());

        // Test for negative ID
        hotel.setHotelId(-1);
        assertEquals(-1, hotel.getHotelId());
    }

    @Test
    public void testName() {
        Hotels hotel = new Hotels();
        hotel.setName("Grand Hotel");
        assertEquals("Grand Hotel", hotel.getName());

        // Test for null value
        hotel.setName(null);
        assertNull(hotel.getName());

        // Test for empty string
        hotel.setName("");
        assertEquals("", hotel.getName());

        // Test for extremely long name
        String longName = "A".repeat(1000);
        hotel.setName(longName);
        assertEquals(longName.trim(), hotel.getName());
    }

    @Test
    public void testLocationId() {
        Hotels hotel = new Hotels();
        hotel.setLocationId(100);
        assertEquals(100, hotel.getLocationId());

        // Test for negative Location ID
        hotel.setLocationId(-100);
        assertEquals(-100, hotel.getLocationId());
    }

    @Test
    public void testPrice() {
        Hotels hotel = new Hotels();
        BigDecimal price = new BigDecimal("99.99");
        hotel.setPrice(price);
        assertEquals(price, hotel.getPrice());

        // Test for zero price
        BigDecimal zeroPrice = BigDecimal.ZERO;
        hotel.setPrice(zeroPrice);
        assertEquals(zeroPrice, hotel.getPrice());

        // Test for negative price
        BigDecimal negativePrice = new BigDecimal("-99.99");
        hotel.setPrice(negativePrice);
        assertEquals(negativePrice, hotel.getPrice());

        // Test for null price
        hotel.setPrice(null);
        assertNull(hotel.getPrice());
    }

    @Test
    public void testRoomsLeft() {
        Hotels hotel = new Hotels();
        hotel.setRoomsLeft(5);
        assertEquals(5, hotel.getRoomsLeft());

        // Test for zero rooms left
        hotel.setRoomsLeft(0);
        assertEquals(0, hotel.getRoomsLeft());

        // Test for negative rooms left
        hotel.setRoomsLeft(-5);
        assertEquals(-5, hotel.getRoomsLeft());

        // Test for null rooms left
        hotel.setRoomsLeft(null);
        assertNull(hotel.getRoomsLeft());
    }

    @Test
    public void testDescription() {
        Hotels hotel = new Hotels();
        hotel.setDescription("A luxurious stay.");
        assertEquals("A luxurious stay.", hotel.getDescription());

        // Test for null value
        hotel.setDescription(null);
        assertNull(hotel.getDescription());

        // Test for empty description
        hotel.setDescription("");
        assertEquals("", hotel.getDescription());

        // Test for trimming
        hotel.setDescription("  Spacious rooms.  ");
        assertEquals("Spacious rooms.", hotel.getDescription());

        // Test for extremely long description
        String longDescription = "B".repeat(2000);
        hotel.setDescription(longDescription);
        assertEquals(longDescription.trim(), hotel.getDescription());
    }
}