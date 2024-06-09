package cdm.depaul.edu.se352.group1.se352group1.booking;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payments", description = "Everything about payments")
@Log4j2
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping
    @Operation(summary = "Get all payments", description = "Retrieve a list of all payments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the payments"),
            @ApiResponse(responseCode = "404", description = "Payments not found")
    })
    public List<Payment> getAllPayments() {
        log.info("Fetching all payments");
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a payment by ID", description = "Retrieve a single payment by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the payment"),
            @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        log.info("Fetching payment with ID: {}", id);
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> {
            log.error("Payment with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        });
    }

    @PostMapping
    @Operation(summary = "Create a new payment", description = "Create a new payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Payment> createPayment(@RequestParam Long guestId,
                                                 @RequestParam Long bookingId,
                                                 @RequestParam String typeOfMethod,
                                                 @RequestParam String remarks) {



        Optional<Booking> bookingOptional = bookingRepo.findById(bookingId);
        Booking booking = bookingOptional.orElse(new Booking());

        Payment payment = new Payment(guestId, booking, LocalDate.now(), booking.getAmount(), typeOfMethod, remarks);

        log.info("Creating new payment: {}", payment);
        try {

            Payment savedPayment = paymentRepository.save(payment);
            log.info("Payment created successfully with ID: {}", savedPayment.getId());
            return ResponseEntity.status(201).body(savedPayment);
        } catch (Exception e) {
            log.error("Error creating payment: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

//    @PutMapping("/{id}")
//    @Operation(summary = "Update a payment", description = "Update an existing payment by its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Payment updated"),
//            @ApiResponse(responseCode = "404", description = "Payment not found"),
//            @ApiResponse(responseCode = "400", description = "Invalid input")
//    })
//    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
//        log.info("Updating payment with ID: {}", id);
//        return paymentRepository.findById(id).map(existingPayment -> {
//            updatedPayment.setId(id);
//            Payment savedPayment = paymentRepository.save(updatedPayment);
//            log.info("Payment updated successfully with ID: {}", savedPayment.getId());
//            return ResponseEntity.ok(savedPayment);
//        }).orElseGet(() -> {
//            log.error("Payment with ID: {} not found", id);
//            return ResponseEntity.notFound().build();
//        });
//    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a payment by ID", description = "Delete a payment by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Payment deleted"),
            @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        log.info("Deleting payment with ID: {}", id);
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            log.info("Payment with ID: {} deleted successfully", id);
            return ResponseEntity.noContent().build();
        } else {
            log.error("Payment with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
