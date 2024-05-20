/**
 * --Lessons Learned--
 *
 * 1. Started a Spring Boot project and managed dependencies like H2 database and Log4j.
 *
 * 2. Gained experience in version control systems, including sessions on code merging, rebasing, and understanding Git commands such as push, fetch, etc., on both individual and main branches.
 *
 * 3. Explored build.gradle files and learned about defining project dependencies and modules.
 *
 * 4. Acquired knowledge about logging systems and their essential features.
 *
 * 5. Created database tables using Java files, understanding the concept of primary keys, foreign keys, and other constraints, implemented using annotations.
 *
 * 6. Developed repositories by extending the JPA Repository interface to leverage its built-in methods for interacting with the database effectively.
 *
 * This package contains entity classes representing data related to bookings and payments in the system.
 *
 *
 * --Data Entities--
 *
 * Booking Table:
 *
 * - The Booking table stores information about guest bookings, including check-in and check-out dates, room details, and payment amounts.
 * - It helps manage reservations and track guest stays within the system.
 *
 *
 * Payment Table:
 * - The Payment table records payment transactions made by guests, including payment dates, amounts, methods, and associated booking details.
 * - It facilitates tracking of payment transactions and their association with specific bookings and guests.
 *

 -- Unit Tests --
 * Covered below operations for both the Booking and Payment tables, confirming main functionality:
 *
 * 1) Records save
 * 2) Get Record by using guestId, CheckIOnDate etc.,
 *
 * Documentation on features that were not covered in class (persistence and non-persistence):
 *
 * 1) Created attributes with different annotations for different constraints such as non-null, unique, column, temporal, etc.
 * 2) Implemented relation between the Booking and Payment tables using the foreign key concept (@JoinColumn, @OneToOne annotation).
 *    - The booking_id in the Payment table serves as a foreign key, establishing a one-to-one relationship with the Booking table.
 * 3) Ensured that every test case handles dependencies in other tables, maintaining data integrity.
 *
 *
 *
 *
 * @Author : Vinod Chowdary
 */

package cdm.depaul.edu.se352.group1.se352group1.booking;






