package cdm.depaul.edu.se352.group1.se352group1.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NonNull
    @Column(name = "guest_id",nullable = false, unique = false)
    private Long guestId;




    @NonNull
    @Column(name = "check_in", nullable = false)
    private LocalDate checkInDate;

    @NonNull
    @Column(name = "check_out", nullable = false)
    private LocalDate checkOutDate;


    @NonNull
    @Column(name = "amount", nullable = false)
    private Float amount;

    @NonNull
    @Column(name = "room_nos", nullable = false)
    private String rooms;

    @NonNull
    @Column(name = "no_of_rooms", nullable = false)
    private int noOfRooms;



}
