INSERT INTO booking (guest_id,  check_in, check_out, amount, room_nos, no_of_rooms)
VALUES (22, '2024-05-15', '2024-05-20', 750.00, '101,102', 2);

INSERT INTO booking (guest_id,  check_in, check_out, amount, room_nos, no_of_rooms)
VALUES (23,  '2024-06-10', '2024-06-15', 1200.00, '201', 1);

INSERT INTO booking (guest_id,  check_in, check_out, amount, room_nos, no_of_rooms)
VALUES (24, '2024-07-01', '2024-07-05', 900.00, '301,302,303', 3);




INSERT INTO payment (guest_id, booking_id, payment_date, amount, method,trans_id, remarks)
VALUES (22, 1, '2024-05-15', 500.00, 'Credit Card','12121hdhdhd', 'Payment received for booking');

INSERT INTO payment (guest_id, booking_id, payment_date, amount, method,trans_id, remarks)
VALUES (23, 2, '2024-06-10', 750.00, 'PayPal','12121hdhdhd22', 'Payment processed successfully');

--INSERT INTO payment (guest_id, booking_id, payment_date, amount, method,trans_id, remarks)
--VALUES (24, 3, '2024-07-01', 1000.00, 'Cash','12121hdhdhd33', NULL);
