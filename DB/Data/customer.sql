-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 18, 2018 at 05:12 AM
-- Server version: 5.7.24-0ubuntu0.16.04.1
-- PHP Version: 7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `insurance`
--

--
-- Truncate table before insert `customer`
--

TRUNCATE TABLE `customer`;
--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `tel`, `email`, `brand`, `province`, `model`, `insurance_id`, `expire_date`) VALUES
(1, 'เพลิน แก้วเรียน', '0837717778', 'ploen@th.fujitsu.com', 'Honda/Freed', 'กทม/2558', '1600', '1', '2018-12-30'),
(2, 'สมศรี สุขมาก', '081883333', 'somsri@gmail.com', 'Volvo/V60', 'กทม/2016', '2500', '1', '2019-12-02'),
(3, 'สบาย อยู่ดี', '0809998888', 'sabai.y@gmail.com', 'Subaru/WRX', 'กทม/2017', '3499CC/SRX', '1', '2019-01-15'),
(4, 'Nattapong pongpanich', '0891421411', 'nattapong!@th.fujitsu.com', 'Toyota/Vios', 'กทม/2013', '1500/E', '2', '2019-08-15'),
(5, 'กณิกนันต์ บริสุทธิ์', '0647824561', 'b_kaniknaa@hotmail.com', 'Nissam/Almera', 'กทม/2556', '1200/VSPORTECH CVT', '3', '2018-12-20'),
(6, 'Metha Putchakan', '0908049995', 'metha@hotmaill.com', 'Toyota/Vios', 'กทม/2560', '1500/E', '3', '2019-07-11'),
(7, 'สุวราลักษณ์ ชุมภูวิเศษ', '0999955588', 'kafair@programmua.com', 'Suzuki/Ertiga', 'กทม/2018', '1.5CC', '3', '2019-12-07'),
(8, 'ธนกร วิบูลย์', '0906464556', 'tamajung@gmail.com', 'Honda/Civic', 'กทม/2561', '1500', '2', '2019-11-10'),
(9, 'สุกัญญา วีรวโรดม', '0806668228', 'suk@th.fujitsu.com', 'Mazda', 'กทม/2560', '2000', '2', '2018-01-12');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
