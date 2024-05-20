package cdm.depaul.edu.se352.group1.se352group1.booking;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testFindByGuestId() {
        Long guestId = 22L;
        List<Booking> bookings = bookingRepository.findByGuestId(guestId);
        assertEquals(1, bookings.size()); // Assuming there are two bookings for guestId 1
    }

    @Test
    public void testFindByCheckInDate() {

        //2024-05-15
        LocalDate checkInDate1 = LocalDate.of(2024, 5, 1);
        List<Booking> bookings1 = bookingRepository.findByCheckInDate(checkInDate1);
        assertTrue(bookings1.isEmpty());

        LocalDate checkInDate = LocalDate.of(2024, 5, 1);

        Booking booking1 = new Booking(1L, 1L, checkInDate, LocalDate.of(2024, 5, 5), 100.0f, "Single", 1);
        Booking booking2 = new Booking(2L, 2L, checkInDate, LocalDate.of(2024, 5, 6), 150.0f, "Double", 2);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);


        List<Booking> bookings = bookingRepository.findByCheckInDate(checkInDate);


        assertEquals(2, bookings.size()); // Assuming there are 2 bookings for the specified check-in date
        assertEquals(booking1, bookings.get(0)); // Assuming booking1 is the first result
        assertEquals(booking2, bookings.get(1)); //

    }

    @Test
    public void testFindByGuestIdAndCheckInDate() {
        Long guestId1 = 1L;
        LocalDate checkInDate1 = LocalDate.of(2024, 5, 1);
        List<Booking> bookings1 = bookingRepository.findByGuestIdAndCheckInDate(guestId1, checkInDate1);
        assertTrue(bookings1.isEmpty());


        Long guestId = 1L;
        LocalDate checkInDate = LocalDate.of(2024, 5, 1);


        Booking booking1 = new Booking(1L, guestId, checkInDate, LocalDate.of(2024, 5, 5), 100.0f, "Single", 1);
        bookingRepository.save(booking1);


        List<Booking> bookings = bookingRepository.findByGuestIdAndCheckInDate(guestId, checkInDate);


        assertEquals(1, bookings.size());
        assertEquals(booking1, bookings.get(0));
    }

    @Test
    public void testSaveBooking() {
        // Create a booking
        Booking booking = new Booking();
        booking.setGuestId(1L);
        booking.setCheckInDate(LocalDate.of(2024, 5, 1));
        booking.setCheckOutDate(LocalDate.of(2024, 5, 5));
        booking.setAmount(500.0f);
        booking.setRooms("101,102");
        booking.setNoOfRooms(2);

        // Save the booking
        bookingRepository.save(booking);

        // Retrieve the booking from the database
        Booking savedBooking = bookingRepository.findById(booking.getId()).orElse(null);


        assertEquals(1L, savedBooking.getGuestId());
        assertEquals(LocalDate.of(2024, 5, 1), savedBooking.getCheckInDate());
        assertEquals(LocalDate.of(2024, 5, 5), savedBooking.getCheckOutDate());
        assertEquals(500.0f, savedBooking.getAmount());
        assertEquals("101,102", savedBooking.getRooms());
        assertEquals(2, savedBooking.getNoOfRooms());
    }

    @Test
    public void testFindBookingsByGuestId() {


        Booking booking1 = new Booking();
        booking1.setGuestId(9L);
        booking1.setCheckInDate(LocalDate.of(2024, 5, 1));
        booking1.setCheckOutDate(LocalDate.of(2024, 5, 5));
        booking1.setAmount(500.0f);
        booking1.setRooms("101,102");
        booking1.setNoOfRooms(2);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking();
        booking2.setGuestId(8L);
        booking2.setCheckInDate(LocalDate.of(2024, 6, 1));
        booking2.setCheckOutDate(LocalDate.of(2024, 6, 5));
        booking2.setAmount(600.0f);
        booking2.setRooms("103,104");
        booking2.setNoOfRooms(2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking();
        booking3.setGuestId(9L);
        booking3.setCheckInDate(LocalDate.of(2024, 7, 1));
        booking3.setCheckOutDate(LocalDate.of(2024, 7, 5));
        booking3.setAmount(700.0f);
        booking3.setRooms("105,106");
        booking3.setNoOfRooms(2);
        bookingRepository.save(booking3);

        // Retrieve bookings by guest ID
        List<Booking> bookingsForGuest1 = bookingRepository.findByGuestId(9L);
        List<Booking> bookingsForGuest2 = bookingRepository.findByGuestId(8L);

        // Check if the correct number of bookings is retrieved for each guest
        assertEquals(2, bookingsForGuest1.size());
        assertEquals(1, bookingsForGuest2.size());

        // Check if the retrieved bookings belong to the correct guest
        assertEquals(9L, bookingsForGuest1.get(0).getGuestId());
        assertEquals(8L, bookingsForGuest2.get(0).getGuestId());
    }
}
