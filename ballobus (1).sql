-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2017 at 06:13 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ballobus`
--

-- --------------------------------------------------------

--
-- Table structure for table `coordinates`
--

CREATE TABLE `coordinates` (
  `C_id` int(5) NOT NULL,
  `U_id` int(5) DEFAULT NULL,
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  `timeUpdated` varchar(10) DEFAULT NULL,
  `Status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coordinates`
--

INSERT INTO `coordinates` (`C_id`, `U_id`, `latitude`, `longitude`, `timeUpdated`, `Status`) VALUES
(1, 5, '-1.308932', '36.813072', '4:15 PM', 1),
(2, 6, '-1.302061', '36.687210', '5:30 PM', 1),
(3, 9, '-1.264839', '36.801880', '4:25 PM', 1),
(4, 10, '-1.396916', '36.760292', '4:35 PM', 1);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `R_id` int(5) NOT NULL,
  `description` varchar(30) DEFAULT NULL,
  `Status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`R_id`, `description`, `Status`) VALUES
(1, 'Bus Driver', 1),
(2, 'Student', 1),
(3, 'Parent', 1),
(4, 'Admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `S_id` int(5) NOT NULL,
  `AdmNo` int(5) NOT NULL,
  `F_name` varchar(100) NOT NULL,
  `L_name` varchar(100) NOT NULL,
  `V_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`S_id`, `AdmNo`, `F_name`, `L_name`, `V_id`) VALUES
(1, 1992, 'Collin', 'Gitonga', 3),
(2, 1996, 'Alex', 'Sagini', 4),
(3, 1993, 'Hiro', 'Shima', 1),
(4, 1990, 'Prisca', 'Musibi', 2),
(5, 1978, 'David', 'Milai', 5);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `U_id` int(5) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `phonenum` int(10) DEFAULT NULL,
  `pass` varchar(6) DEFAULT NULL,
  `R_id` int(5) DEFAULT NULL,
  `S_id` int(5) DEFAULT NULL,
  `V_id` int(5) DEFAULT NULL,
  `Status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`U_id`, `fname`, `lname`, `username`, `phonenum`, `pass`, `R_id`, `S_id`, `V_id`, `Status`) VALUES
(1, 'Apollo', 'Musibi', 'apsmusibi', 705214187, '123456', 4, 0, NULL, 1),
(2, 'Bizy', 'Sankan', 'bizeysankan', 711502614, '132435', 4, 0, NULL, 1),
(4, 'Jane', 'Doe', 'jdoe', 786524189, '124', 3, 2, NULL, 1),
(5, 'James', 'Mwangi', 'jmwangi', 785678490, '345', 1, 0, 2, 1),
(6, 'Macharia', 'Mbugua', 'mmbugua', 765789045, '897', 1, 0, 1, 1),
(9, 'Jack', 'Bauer', 'jbauer', 785663904, '908', 1, 0, 3, 1),
(10, 'Johnny', 'Test', 'jtest', 785674829, 'jtest', 1, 0, 4, 1),
(12, 'John', 'Jones', 'jjones', 745628794, 'jjone1', 3, 1, NULL, 1),
(13, 'Jennifer', 'West', 'jwest', 765438975, 'jwest1', 3, 3, NULL, 1),
(17, 'Alice', 'Muthoni', 'amuthoni', 721965331, 'alice1', 3, 4, NULL, 1),
(18, 'Brandon', 'James', 'bjames', 792874567, 'bjame1', 1, NULL, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `V_id` int(5) NOT NULL,
  `reg_no` varchar(30) DEFAULT NULL,
  `dateAdded` varchar(30) DEFAULT NULL,
  `capacity` varchar(4) DEFAULT NULL,
  `Status` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`V_id`, `reg_no`, `dateAdded`, `capacity`, `Status`) VALUES
(1, 'KBC 123B', '30/03/2017', '60', 1),
(2, 'KCA 345T', '25/01/2017', '55', 1),
(3, 'KBX 925X', '1/02/2016', '46', 1),
(4, 'KBY 543P', '3/05/2016', '67', 1),
(5, 'KBU 547X', '14/05/2016', '55', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coordinates`
--
ALTER TABLE `coordinates`
  ADD PRIMARY KEY (`C_id`),
  ADD KEY `U_id` (`U_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`R_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`S_id`),
  ADD KEY `V_id` (`V_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`U_id`),
  ADD KEY `R_id` (`R_id`),
  ADD KEY `V_id` (`V_id`),
  ADD KEY `S_id` (`S_id`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`V_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `coordinates`
--
ALTER TABLE `coordinates`
  MODIFY `C_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `R_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `S_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `U_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `V_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `coordinates`
--
ALTER TABLE `coordinates`
  ADD CONSTRAINT `coordinates_ibfk_1` FOREIGN KEY (`U_id`) REFERENCES `users` (`U_id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`V_id`) REFERENCES `vehicle` (`V_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`R_id`) REFERENCES `roles` (`R_id`),
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`V_id`) REFERENCES `vehicle` (`V_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
