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
@Table(name = "payment", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "trans_id"})
})
public class Payment {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "guest_id",nullable = false, unique = false)
    private Long guestId;

    @JoinColumn(name = "booking_id",nullable = false, unique = true)// Foreign key reference
    @OneToOne
    private Booking booking;// Foreign key field



    @NonNull
    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @NonNull
    @Column(name = "amount", nullable = false)
    private Float amount;

    @NonNull
    @Column(name = "method", nullable = false)
    private String typeOfMethod;

    @NonNull
    @Column(name = "trans_id", nullable = false, unique = true)
    private String transactionId;


    private String remarks;


}

