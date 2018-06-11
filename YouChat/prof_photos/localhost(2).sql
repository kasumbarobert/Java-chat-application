-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 01, 2016 at 11:35 
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `youchat`
--
CREATE DATABASE IF NOT EXISTS `youchat` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `youchat`;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `msg_id` varchar(90) NOT NULL,
  `sender` varchar(30) NOT NULL,
  `msg` longtext NOT NULL,
  `file` text NOT NULL,
  `timestamp` bigint(20) NOT NULL,
  `receiver` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `name` varchar(90) NOT NULL,
  `password` mediumtext NOT NULL,
  `login_status` int(1) NOT NULL DEFAULT '0',
  `profile_photo` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `name`, `password`, `login_status`, `profile_photo`) VALUES
('kasumbarobert', 'Kasumba Robert', '[C@1304bfd', 0, 'prof_photos/2015-05-15 17.51.35.jpg'),
('love_robert', 'Lydia Kasande', '[C@2de9738f', 0, 'prof_photos/2015-05-31 18.08.30.png'),
('solema', 'Ssevvume', '[C@18246e15', 0, 'prof_photos/2015-05-29 06.27.26.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
