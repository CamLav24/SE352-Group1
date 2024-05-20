package cdm.depaul.edu.se352.group1.se352group1.booking;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("bookings")
@Tag(name = "Bookings",description = "Everything about Bookings")
@Log4j2
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;



    @GetMapping
    @Operation(summary = "Get all bookings", description = "Retrieve a list of all bookings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the bookings"),
            @ApiResponse(responseCode = "404", description = "Bookings not found")
    })
    public List<Booking> getAllBookings() {
        log.info("Fetching all bookings");
        return bookingRepo.findAll();
    }


    @GetMapping("{id}")
    @Operation(summary = "Get a booking details by ID", description = "Retrieve a single booking by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the booking"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<List<Booking>> getBookingById(@PathVariable(value = "id") Long id) throws Exception {
        log.info("Fetching booking with ID: {}", id);

        List<Booking> bookingsList = bookingRepo.findAll();

        List<Booking> resultList = new ArrayList<>();

        for(Booking booking : bookingsList){

            if(Objects.equals(booking.getId(), id)){
                resultList.add(booking);

            }
        }

        if(resultList.size()==0){
            log.error("No details found for the given student id :"+id);
            throw  new Exception("No details found for the given student id !! ");
        }
        log.info("Details found with student ID -"+id);

        return ResponseEntity.ok().body(resultList);
    }

    @PostMapping
    @Operation(summary = "Create a new booking", description = "Create a new booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Booking created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        log.info("Creating new booking: {}", booking);
        try {
            Booking savedBooking = bookingRepo.save(booking);
            log.info("Booking created successfully with ID: {}", savedBooking.getId());
            return ResponseEntity.status(201).body(savedBooking);
        } catch (Exception e) {
            log.error("Error creating booking: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a booking", description = "Update an existing booking by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking updated"),
            @ApiResponse(responseCode = "404", description = "Booking not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        log.info("Updating booking with ID: {}", id);
        return bookingRepo.findById(id).map(existingBooking -> {
            updatedBooking.setId(id);
            Booking savedBooking = bookingRepo.save(updatedBooking);
            log.info("Booking updated successfully with ID: {}", savedBooking.getId());
            return ResponseEntity.ok(savedBooking);
        }).orElseGet(() -> {
            log.error("Booking with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        });
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a booking by ID", description = "Delete a booking by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Booking deleted"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        log.info("Deleting booking with ID: {}", id);
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            log.info("Booking with ID: {} deleted successfully", id);
            return ResponseEntity.noContent().build();
        } else {
            log.error("Booking with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/bookings/byGuestId")
    public List<Booking> findBookingsByGuestId(@RequestParam Long guestId) {
        return bookingRepo.findByGuestId(guestId);
    }

    @GetMapping("/bookings/today")
    public List<Booking> getTodaysBookings() {
        LocalDate today = LocalDate.now();
        return bookingRepo.findByCheckInDate(today);
    }




}
