-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2017 at 09:13 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline`
--

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `flight_id` varchar(20) NOT NULL,
  `source` varchar(25) NOT NULL,
  `destination` varchar(25) NOT NULL,
  `hours` varchar(10) NOT NULL,
  `distance` int(11) NOT NULL,
  `day` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`flight_id`, `source`, `destination`, `hours`, `distance`, `day`) VALUES
('BLRPUN', 'Bangalore', 'Pune', '2:10 Hrs', 450, 'Monday'),
('BLRPTN', 'Bangalore', 'Patna', '4:10 Hrs', 200, 'Friday');

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `pnr` int(11) NOT NULL,
  `source_city` varchar(25) NOT NULL,
  `destination_city` varchar(25) NOT NULL,
  `numofperson` int(11) NOT NULL,
  `date` date NOT NULL,
  `Day` varchar(25) NOT NULL,
  `Hours` varchar(25) NOT NULL,
  `Distance` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`pnr`, `source_city`, `destination_city`, `numofperson`, `date`, `Day`, `Hours`, `Distance`) VALUES
(2000, 'Bangalore', 'Manipal', 2, '2017-04-10', 'Monday', '2:10 Hrs', 450),
(1, 'Bangalore', 'Manipal', 1, '2017-04-24', 'Monday', '2:10 Hrs', 450),
(2001, 'Bangalore', 'Manipal', 2, '2017-04-10', 'Monday', '2:10 Hrs', 450),
(2003, 'Bangalore', 'Manipal', 2, '2017-04-10', 'Monday', '2:10 Hrs', 450),
(2004, 'Bangalore', 'Manipal', 2, '2017-04-10', 'Monday', '2:10 Hrs', 450),
(20000, 'Bangalore', 'Manipal', 1, '2017-04-24', 'Monday', '2:10 Hrs', 450);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `ph_num` varchar(11) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `name`, `ph_num`, `pass`) VALUES
('praveen', 'praveen Singh', '9738836826', 'singh'),
('praveenmath96', 'praveen skumar singh', '9741014516', '1234'),
('asd', 'asd', '123', 'asd'),
('', '', '', ''),
('qw', 'qwe', '123', 'qwe'),
('sd', 'qwe', '123', '12'),
('prakashsing057', 'Prakash Singh', '7676192390', '1234'),
('abcd', 'abcd', '1234', 'abcd'),
('shash_pai', 'stp', '9090', 'pai'),
('archianshiansh', 'ARCHIT SINGH', '1234567990', '1234qwe'),
('praveenise74', '', '', '1234'),
('aditya@96', 'aditya', '466123789', 'aditya'),
('amitabh@', 'amitabh', '4561237890', 'kumar'),
('asdf', 'abcd', '789456123', 'qwe'),
('qwe', 'qwe', '1234567990', '123'),
('Poi', 'Poi', '1223', 'poi'),
('amyrocker', 'Shubham', '123456789', '12345'),
('ad', 'ad', '12', 'ad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flight_id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`pnr`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `uid` (`uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
