INSERT INTO `doctorspeciality` (`id`, `specialityType`) VALUES
(1, 'ENT Surgeon'),
(2, 'Cardiologist'),
(3, 'Dermatologyst'),
(4, 'General Surgeon');

INSERT INTO `doctors` (`regNo`, `address`, `email`, `firstName`, `lastName`, `phoneNumber`, `typeId`) VALUES
('Doc1001', 'Kokuvil,Jaffna', 'sivansuthan@gmail.com', 'aaaaaa', 'Nadaraj', '0759017404', 1),
('Doc1002', 'Kokuvil,Jaffna', 'sivansuthan@gmail.com', 'bbbbb', 'Nadaraj', '0759017404', 1),
('Doc1003', 'Kokuvil,Jaffna', 'sivansuthan@gmail.com', 'ccccc', 'Nadaraj', '0759017404', 1),
('Doc1004', 'Kokuvil,Jaffna', 'sivansuthan@gmail.com', 'ddddd', 'Nadaraj', '0759017404', 2),
('Doc1005', 'Kokuvil,Jaffna', 'sivansuthan@gmail.com', 'ddddd', 'Nadaraj', '0759017404', 3);