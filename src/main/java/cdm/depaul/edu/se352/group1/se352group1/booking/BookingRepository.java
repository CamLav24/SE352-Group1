package cdm.depaul.edu.se352.group1.se352group1.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByGuestId(Long guestId);


    List<Booking> findByCheckInDate(LocalDate checkInDate);

    List<Booking> findByGuestIdAndCheckInDate(Long guestId, LocalDate checkInDate);

}