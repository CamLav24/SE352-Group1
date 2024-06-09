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
 * 7.  Utilized GetMapping and PostMapping to establish Rest Controller functionality, facilitating API calls.
 *
 * 8. Conducted unit testing for the generated tables to ensure robustness.
 *
 * 9. Developed dedicated services for each entity to streamline operations.
 *
 * 10. Integrated Swagger documentation across all services, enhancing accessibility and clarity of the API.
 *
 * 11. Implemented Git-hub workflow to push application image to docker hub.
 *
 * 12. Implemented Front-end using themeleaf and used Model and view controller library.
 *
 * 14. Developed docker file to  pull image from hub.docker.
 *
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
 * 3) Covered unit tests for created services.
 *
 * Documentation on features that were not covered in class (persistence and non-persistence):
 *
 * 1) Created attributes with different annotations for different constraints such as non-null, unique, column, temporal, etc.
 * 2) Implemented relation between the Booking and Payment tables using the foreign key concept (@JoinColumn, @OneToOne annotation).
 *    - The booking_id in the Payment table serves as a foreign key, establishing a one-to-one relationship with the Booking table.
 * 3) Ensured that every test case handles dependencies in other tables, maintaining data integrity.
 * 4) Created relevant services for both booking and payments.
 * 5) Implemented Front end using themeleaf.
 * 6) updated services to process data and able to view in the UI.
 * 7) Used Bootstrap for pages.
 * *) Dynamic updates on UI.
 *
 *
 *
 *
 * @Author : Vinod Chowdary
 */

package cdm.depaul.edu.se352.group1.se352group1.booking;






