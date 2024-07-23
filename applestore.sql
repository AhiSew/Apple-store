-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 23, 2024 at 02:28 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `applestore`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_details`
--

CREATE TABLE `product_details` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(150) NOT NULL,
  `category` varchar(150) NOT NULL,
  `price` double NOT NULL,
  `total_quantity` int(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_details`
--

INSERT INTO `product_details` (`product_id`, `product_name`, `category`, `price`, `total_quantity`) VALUES
(3, 'apple', 'i9', 200, 22),
(4, 'apple i4', 'i4', 12000, 65),
(7, 'apple i3', 'i5', 1000, 3),
(8, 'applei3', 'i3', 12000, 25),
(9, 'applei9', 'i9', 1003, 2),
(10, 'apple76', 'i7', 20000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sells_detailss`
--

CREATE TABLE `sells_detailss` (
  `sells_id` int(150) NOT NULL,
  `product_id` int(150) NOT NULL,
  `product_name` varchar(150) NOT NULL,
  `sells_quantity` int(150) NOT NULL,
  `product_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sells_detailss`
--

INSERT INTO `sells_detailss` (`sells_id`, `product_id`, `product_name`, `sells_quantity`, `product_price`) VALUES
(1, 4, 'apple i4', 3, 12000),
(2, 4, 'apple i4', 3, 12000),
(3, 3, 'apple i43', 10, 50000),
(4, 4, 'apple i4', 1, 12000),
(5, 4, 'apple i4', 1, 12000),
(6, 3, 'apple i43', 2, 50000),
(7, 3, 'apple i43', 1, 50000),
(8, 3, 'apple i43', 2, 50000),
(9, 4, 'apple i4', 2, 12000),
(10, 4, 'apple i4', 2, 12000),
(11, 4, 'apple i4', 1, 12000),
(12, 3, 'apple i43', 3, 50000),
(13, 4, 'apple i4', 1, 12000),
(14, 3, 'apple i43', 1, 50000),
(15, 4, 'apple i4', 1, 12000),
(16, 4, 'apple i4', 7, 12000),
(17, 3, 'apple i43', 23, 50000),
(18, 3, 'apple i43', 33, 50000),
(19, 3, 'apple', 11, 200),
(20, 6, 'apple', 33, 200),
(21, 4, 'sncn', 20, 100);

-- --------------------------------------------------------

--
-- Table structure for table `users_details`
--

CREATE TABLE `users_details` (
  `user` int(11) NOT NULL,
  `user_name` varchar(150) NOT NULL,
  `user_password` varchar(150) NOT NULL,
  `user_role` varchar(150) NOT NULL,
  `user_email` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_details`
--

INSERT INTO `users_details` (`user`, `user_name`, `user_password`, `user_role`, `user_email`) VALUES
(2, 'cash', 'cash123', 'cashier', 'jbsxusb@gmail.com'),
(37, 'gg', '12345', 'user', 'rrfddd'),
(38, 'man', 'man123', 'manager', 'edgygy@gmail.com'),
(39, 'ppp', 'ppp12350', 'cashier', 'pp@1230'),
(40, 'a', 'ahinas1234', 'user', 'a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `sells_detailss`
--
ALTER TABLE `sells_detailss`
  ADD PRIMARY KEY (`sells_id`);

--
-- Indexes for table `users_details`
--
ALTER TABLE `users_details`
  ADD PRIMARY KEY (`user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product_details`
--
ALTER TABLE `product_details`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `sells_detailss`
--
ALTER TABLE `sells_detailss`
  MODIFY `sells_id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `users_details`
--
ALTER TABLE `users_details`
  MODIFY `user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
