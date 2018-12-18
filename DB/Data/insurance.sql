-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 18, 2018 at 05:51 AM
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
-- Dumping data for table `insurance`
--

INSERT INTO `insurance` (`insurance_id`, `insurance_name`, `insurance_type`, `box1`, `box2`, `box3`, `box4`, `remark`) VALUES
(1, 'ประกันรถยนต์ชั้น 1', '1', 'ความคุ้มครอง รถเก๋ง/กระบบ 4 ประตู จำนวน 7 ที่นั่ง', 'ความรับผิดต่อชีวิต/ร่างกายของบุคคลภายนอก สูงสุด 10,000,000 บาท', 'ความรับผิดต่อรถเอาประกันภัยกรณีชนกับยานพาหนะ สูญหายไฟไหม้ ตามทุนประกัน ', 'คุ้มครองอุบัติเหตุส่วนบุคคลค่ารักษาพยาบาล 100,000 บาทต่อคน', 'พร้อมความคุ้มครองหลักทรัพย์ประกันตัวผู้ขับขี่ 300,000 บาท ต่อครั้ง และคุ้มครองครอบคลุมไปถึงภัยก่อการร้าย'),
(2, 'เมืองไทย 3+ คุ้มเว่อร์', '2', 'เบี้ยประกันภัยเริ่มต้นที่ 8,400 บาท', 'คุ้มครอง ครอบคลุม ชน', 'คุ้มครอง น้ำท่วม สูงสุด 100,000 บาท', 'คุ้มครอง อุบัติเหตุเสียหายทั้งคัน', 'เงินชดเชย ค่าเดินทางระหว่างนำรถยนต์เข้าอู่ไม่ว่าผู้ขับขี่เป็นฝ่ายผิดหรือถูก 1,000 บาท/ครั้ง (3 ครั้ง/ปี)'),
(3, 'เมืองไทยขับดียกกำลัง ยกกำลัง 8 ', '3', 'เบี้ยประกันภัย 8,888 บาท รถเก๋ง ซ่อมอู่', 'ความรับผิดต่อชีวิต/ร่างกายของบุคคลภายนอก (รวมผู้โดยสารในรถ) สูงสุด 10,000,000 บาท', 'ความรับ’ผิดต่อรถเอาประภัยกรณีชนกับยานพาหนะ 200,000 บาท', 'คุ้มครองรถเสียหายจากน้ำท่วมสูญหายไฟไหม้สูงสุด 200,000บาท', 'พร้อมความคุ้มครองอุบัติเหตุส่วนบุคคล ค่ารักษาพยาบาล 100,000 บาท ต่อคน และหลักทรัพย์ประกันตัวผู้ขับขี่ 200,000 บาทต่อครั้ง รวมไปถึงค่าใช้จ่ายในการเดินทาง ระหว่างนำรถเข้าซ่อม จากอุบัติเหตุชนกับยานพาหนะทางบก 2,000 บาทต่อครั้ง');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `insurance`
--
ALTER TABLE `insurance`
  ADD PRIMARY KEY (`insurance_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
