package cdm.depaul.edu.se352.group1.se352group1.booking;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;
import java.util.UUID;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String list(Model model, HttpSession session){
//        ModelAndView mAndV = new ModelAndView("se352group1/bookings");
        model.addAttribute("bookings",bookingRepository.findAll());

        if(session.getAttribute("booking") == null){
            model.addAttribute("booking",new Booking());
            model.addAttribute("btnAddOrModifyLabel","Add");
        }
        else{
             model.addAttribute("booking",session.getAttribute("booking"));
             model.addAttribute("btnAddOrModifyLabel","Add More Bookings");
        }
        return "bookings";
    }
    @GetMapping("/edit/{id}")
    public String get(@PathVariable("id") Long id, Model model, HttpSession session) {

        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        Booking booking = optionalBooking.orElse(null);
//        Booking booking1 = new Booking();

//        booking.

        if (booking!=null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedCheckInDate = booking.getCheckInDate().format(formatter);
            String formattedCheckOutDate = booking.getCheckOutDate().format(formatter);
            System.out.println(booking.getCheckInDate());
            System.out.println(booking.getCheckOutDate());

            // Update the booking object with formatted dates
            booking.setCheckInDate(LocalDate.parse(formattedCheckInDate, formatter));
            booking.setCheckOutDate(LocalDate.parse(formattedCheckOutDate, formatter));

            System.out.println(booking.getCheckInDate());
            System.out.println(booking.getCheckOutDate());
        }


//        formatCheckInDate(booking);

        session.setAttribute("booking", booking);
        session.setAttribute("typeOfString",paymentRepository.findByBooking(Optional.ofNullable(booking)).getTypeOfMethod());
//        model.addAttribute("btnAddOrModifyLabel","Book More");

        return "redirect:/bookings";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {

        bookingService.deleteBooking(id);
        model.addAttribute("info", "Payment successful!!");
        return "redirect:/bookings";
    }



//    @PostMapping
//    public String createWorkspace(@ModelAttribute Booking booking, HttpSession session) {
//        if (booking.getId() == 0)
//            bookingRepository.save(booking);
//        else {
//            Optional<Booking> bookingsOptional1 = bookingRepository.findById(booking.getId());
//            Booking existingResource = bookingsOptional1.get();
//            existingResource.setCheckInDate(booking.getCheckInDate());
//            existingResource.setCheckOutDate(booking.getCheckOutDate());
//            existingResource.setRooms(booking.getRooms());
//            existingResource.setNoOfRooms(booking.getNoOfRooms());
//            existingResource.setGuestId(booking.getGuestId());
//            bookingRepository.save(existingResource);
//            session.setAttribute("booking", null);
//        }
//        return "redirect:/bookings";
//    }

    @PostMapping
    public String save(@ModelAttribute Booking booking,@RequestParam String typeOfMethod, Model model, HttpSession session) {

//        Payment payment1 = new Payment()


        Booking savedBooking = bookingRepository.save(booking);

        Payment payment = new Payment();
        payment.setBooking(savedBooking);
        payment.setAmount(savedBooking.getAmount());
        payment.setGuestId(savedBooking.getGuestId());
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setDate(LocalDate.now());
        payment.setRemarks("Payment Successful");
        payment.setTypeOfMethod(typeOfMethod);
        paymentRepository.save(payment);

        model.addAttribute("info", "Payment successful!!");


        return "redirect:/bookings";
    }




}
