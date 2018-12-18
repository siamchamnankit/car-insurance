-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 18, 2018 at 05:07 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(10) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `province` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `insurance_id` varchar(10) NOT NULL,
  `expire_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(6, 'Metha Putchakan', '-', 'metha@hotmaill.com', 'Toyota/Vios', 'กทม/2560', '1500/E', '3', '2019-07-11'),
(7, 'สุวราลักษณ์ ชุมภูวิเศษ', '0908058884', 'kafair@programmua.com', 'Suzuki/Swift', 'กทม/2018', '1.5CC', '3', '2019-12-07'),
(8, 'ธนกร วิบูลย์', '0906464556', 'tamajung@gmail.com', 'Honda/Civic', 'กทม/2561', '1500', '2', '2019-11-10'),
(9, 'สุกัญญา วีรวโรดม', '0806668228', 'suk@th.fujitsu.com', 'Mazda', 'กทม/2560', '2000', '2', '2018-01-12');

-- --------------------------------------------------------

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `insurance_id` int(20) NOT NULL,
  `insurance_name` varchar(100) NOT NULL,
  `insurance_type` varchar(10) NOT NULL,
  `box1` varchar(200) DEFAULT NULL,
  `box2` varchar(200) DEFAULT NULL,
  `box3` varchar(200) DEFAULT NULL,
  `box4` varchar(200) DEFAULT NULL,
  `remark` varchar(4000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `insurance`
--

TRUNCATE TABLE `insurance`;
--
-- Dumping data for table `insurance`
--

INSERT INTO `insurance` (`insurance_id`, `insurance_name`, `insurance_type`, `box1`, `box2`, `box3`, `box4`, `remark`) VALUES
(1, 'ประกันรถยนต์ชั้น 1', '1', 'ความคุ้มครอง รถเก๋ง/กระบบ 4 ประตู จำนวน 7 ที่นั่ง', 'ความรับผิดต่อชีวิต/ร่างกายของบุคคลภายนอก สูงสุด 10,000,000 บาท', 'ความรับผิดต่อรถเอาประกันภัยกรณีชนกับยานพาหนะ สูญหายไฟไหม้ ตามทุนประกัน ', 'คุ้มครองอุบัติเหตุส่วนบุคคลค่ารักษาพยาบาล 100,000 บาทต่อคน', 'พร้อมความคุ้มครองหลักทรัพย์ประกันตัวผู้ขับขี่ 300,000 บาท ต่อครั้ง และคุ้มครองครอบคลุมไปถึงภัยก่อการร้าย'),
(2, 'เมืองไทย 3+ คุ้มเว่อร์', '2', 'เบี้ยประกันภัยเริ่มต้นที่ 8,400 บาท', 'คุ้มครอง ครอบคลุม ชน', 'คุ้มครอง น้ำท่วม สูงสุด 100,000 บาท', 'คุ้มครอง อุบัติเหตุเสียหายทั้งคัน', 'เงินชดเชย ค่าเดินทางระหว่างนำรถยนต์เข้าอู่ไม่ว่าผู้ขับขี่เป็นฝ่ายผิดหรือถูก 1,000 บาท/ครั้ง (3 ครั้ง/ปี)'),
(3, 'เมืองไทยขับดียกกำลัง ยกกำลัง 8 ', '3', 'เบี้ยประกันภัย 8,888 บาท รถเก๋ง ซ่อมอู่', 'ความรับผิดต่อชีวิต/ร่างกายของบุคคลภายนอก (รวมผู้โดยสารในรถ) สูงสุด 10,000,000 บาท', 'ความรับ’ผิดต่อรถเอาประภัยกรณีชนกับยานพาหนะ 200,000 บาท', 'คุ้มครองรถเสียหายจากน้ำท่วมสูญหายไฟไหม้สูงสุด 200,000บาท', 'พร้อมความคุ้มครองอุบัติเหตุส่วนบุคคล ค่ารักษาพยาบาล 100,000 บาท ต่อคน และหลักทรัพย์ประกันตัวผู้ขับขี่ 200,000 บาทต่อครั้ง รวมไปถึงค่าใช้จ่ายในการเดินทาง ระหว่างนำรถเข้าซ่อม จากอุบัติเหตุชนกับยานพาหนะทางบก 2,000 บาทต่อครั้ง');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name_lastname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `user`
--

TRUNCATE TABLE `user`;
--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `name_lastname`) VALUES
('prathan', '3Nj0Y8319', 'ประธาน ด่านสกุลเจริญกิจ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `insurance`
--
ALTER TABLE `insurance`
  ADD PRIMARY KEY (`insurance_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
