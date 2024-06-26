package cdm.depaul.edu.se352.group1.se352group1.booking;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    List<Payment> findByGuestId(Long guestId);

    Payment findByBooking(Optional<Booking> booking);

    Payment findByTransactionId(String transactionId);

    boolean existsByBookingId(Long bookingId);

    void deleteByBookingId(Long bookingId);
}