INSERT INTO `hospitals` (`hosRegNo`, `hosAdress`, `hosEmail`, `hosName`, `hosPhoneNumber`, `hosType`) VALUES
('Hos101', 'Manipay', '******@gmail.com', 'St johns', '###', 'Clinic'),
('Hos102', 'Thurunelweli', '******@gmail.com', 'Northern Central', '###', 'Multy Speciality'),
('Hos103', 'Thadatheru', '******@gmail.com', 'Vanwest', '###', 'Clinic'),
('Hos104', 'Jaffna', '******@gmail.com', 'Mother care', '###', 'Multy Speciality'),
('Hos105', 'Jaffna', '******@gmail.com', 'City Medicals', '###', 'Clinic');


INSERT INTO `visitingdoctors` (`id`, `docChanellingFee`, `docRegNo`, `hosChanellingFee`, `hosRegNo`) VALUES
(1, 1500, 'Doc1001', 350, 'Hos101'),
(2, 1500, 'Doc1001', 350, 'Hos102'),
(3, 1500, 'Doc1001', 350, 'Hos103'),
(4, 1500, 'Doc1001', 350, 'Hos104'),
(5, 1500, 'Doc1001', 350, 'Hos105'),
(6, 1000, 'Doc1002', 350, 'Hos101'),
(7, 1000, 'Doc1002', 350, 'Hos102'),
(8, 1000, 'Doc1002', 350, 'Hos103'),
(9, 850, 'Doc1003', 350, 'Hos101'),
(10, 850, 'Doc1003', 350, 'Hos102'),
(11, 500, 'Doc1004', 350, 'Hos103'),
(12, 5000, 'Doc1005', 500, 'Hos102');


INSERT INTO `doctorscedules` (`id`, `currentAppointmentNumber`, `date`, `docRegNo`, `expectedArrival`, `hosRegNo`, `session`, `status`, `totalBookings`) VALUES
(1, 0, '2021-02-11', 'Doc1001', '18:00:00', 'Hos101', 'eve', 'created',10),
(2, 0, '2021-02-12', 'Doc1001', '18:00:00', 'Hos101', 'eve', 'created',11),
(3, 0, '2021-02-13', 'Doc1001', '18:00:00', 'Hos101', 'eve', 'created',27),
(4, 0, '2021-02-14', 'Doc1001', '18:00:00', 'Hos102', 'eve', 'created',41),
(5, 0, '2021-02-15', 'Doc1001', '18:00:00', 'Hos102', 'eve', 'created',25),
(6, 0, '2021-02-11', 'Doc1002', '18:00:00', 'Hos101', 'eve', 'created',4),
(7, 0, '2021-02-12', 'Doc1002', '18:00:00', 'Hos101', 'eve', 'created',17),
(8, 0, '2021-02-13', 'Doc1002', '18:00:00', 'Hos101', 'eve', 'created',41),
(9, 0, '2021-02-14', 'Doc1002', '18:00:00', 'Hos102', 'eve', 'created',45),
(10, 0, '2021-02-15', 'Doc1002', '18:00:00', 'Hos102', 'eve', 'created',35),
(11, 0, '2021-02-16', 'Doc1002', '18:00:00', 'Hos103', 'eve', 'created',15);