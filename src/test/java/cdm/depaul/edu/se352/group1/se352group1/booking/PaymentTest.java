package cdm.depaul.edu.se352.group1.se352group1.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    private  List<Booking> bookings;

    private Payment payment;

    private Booking booking_log ;

    private Booking booking ;



    @BeforeEach
    public void setUp() {
        // Create a new Payment object
        booking_log = new Booking(22L, 1L, LocalDate.of(2024, 5, 1)
                , LocalDate.of(2024, 5, 5), 100.0f, "Single", 1);

        booking = bookingRepository.save(booking_log);
//        booking = bookingRepository.findById(22L);


        payment = new Payment();
        payment.setGuestId(7L); // Set guestId
        payment.setDate(LocalDate.now()); // Set payment date
        payment.setAmount(100.0f); // Set payment amount
        payment.setTypeOfMethod("Credit Card"); // Set payment method
        payment.setTransactionId("123456789"); // Set transaction ID
        payment.setRemarks("Test payment"); // Set remarks
        payment.setBooking(booking);
    }

    @Test
    public void testSavePayment() {

        // Save the Payment object
        Payment savedPayment = paymentRepository.save(payment);

        // Assertions
        assertNotNull(savedPayment);
        assertTrue(savedPayment.getId() > 0);

        assertNotNull(savedPayment.getDate());
        assertNotNull(savedPayment.getTypeOfMethod());
        assertNotNull(savedPayment.getTransactionId());
        assertNotNull(savedPayment.getRemarks());
    }

    @Test
    public void testFindByGuestId() {



        Payment savedPayment = paymentRepository.save(payment);


        Long guestId = 7L;


        List<Payment> payments = paymentRepository.findByGuestId(guestId);


        assertTrue(!payments.isEmpty());

        Long guestId1 = 999L;

        List<Payment> payments1 = paymentRepository.findByGuestId(guestId1);

        assertTrue(payments1.isEmpty());
    }


    @Test
    public void testFindByBooking() {


        // Save the Payment object
        Payment savedPayment = paymentRepository.save(payment);


        Payment foundPayment = paymentRepository.findByBooking(booking);


        assertEquals(payment, foundPayment);
    }

    @Test
    public void testFindByTransactionId() {


        // Save the Payment object
        Payment savedPayment = paymentRepository.save(payment);

        String transactionId = "123456789";

        Payment foundPayment = paymentRepository.findByTransactionId(transactionId);

        assertEquals(payment, foundPayment);
    }

}
