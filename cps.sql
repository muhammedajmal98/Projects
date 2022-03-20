-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2022 at 01:55 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cps`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `name` varchar(50) DEFAULT NULL,
  `uname` varchar(5) NOT NULL,
  `pswd` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `uname`, `pswd`) VALUES
('Muhammed Ajmal', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `appliedjobs`
--

CREATE TABLE `appliedjobs` (
  `sid` varchar(13) DEFAULT NULL,
  `jobid` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `coordinator`
--

CREATE TABLE `coordinator` (
  `ename` varchar(40) DEFAULT NULL,
  `uname` varchar(40) NOT NULL,
  `cname` varchar(80) DEFAULT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `pswd` varchar(40) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coordinator`
--

INSERT INTO `coordinator` (`ename`, `uname`, `cname`, `phone`, `pswd`, `address`) VALUES
('John', 'john@gmail.com', 'Tehnolog', '7034834276', 'aju123', 'New Street, Newland PP, PPO'),
('Muhammed Ajmal', 'majmals1998@gmail.com', 'Stack Overflow', '7034834276', 'aju123', 'New Street, Ernakulam(North), 699399');

-- --------------------------------------------------------

--
-- Table structure for table `selectstudent`
--

CREATE TABLE `selectstudent` (
  `sid` varchar(13) NOT NULL,
  `jobid` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `selectstudent`
--

INSERT INTO `selectstudent` (`sid`, `jobid`) VALUES
('180021030987', 'PYDESTOV22JAN'),
('180021030992', 'PYDESTOV22JAN');

-- --------------------------------------------------------

--
-- Table structure for table `srmail`
--

CREATE TABLE `srmail` (
  `mailid` varchar(60) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `tmailid` varchar(60) DEFAULT NULL,
  `mailtype` varchar(3) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `srmail`
--

INSERT INTO `srmail` (`mailid`, `sname`, `tmailid`, `mailtype`, `message`, `date`, `status`) VALUES
('admin@cps.com', 'ADMIN', 'majmals1998@gmail.com', 'A-S', 'Hello this is a demo message for testing cps', '01/21/2022 22:24:00', 1),
('admin@cps.com', 'ADMIN', 'mihrajrs@gmail.com', 'A-S', 'Hello this is a demo message for testing cps', '01/21/2022 22:26:00', 0),
('admin@cps.com', 'ADMIN', 'salman@gmail.com', 'A-S', 'Hello this is a demo message for testing cps', '01/21/2022 22:26:00', 0),
('admin@cps.com', 'ADMIN', 'mithun@gmail.com', 'A-S', 'Hello this is a demo message for testing cps', '01/21/2022 22:26:00', 0),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'majmals1998@gmail.com', 'C-S', 'Dear Muhammed Ajmal, <br/><br/>Congratulations. We are so happy to inform you that Stack Overflow like to extend the offer to you for the position of Python Developer. After interviewing all the candidates, we found you the most suitable person for the job. <br/>Please feel free to reach out to me in case you have any other doubts. We look forward to you joining us and making us bigger and better than ever. <br/><br/>Yours’ sincerely, <br/>Muhammed Ajmal <br/>Stack Overflow', '06/01/2022 02:19:10', 1),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'admin@cps.com', 'S-A', 'Hello admin', '06/01/2022 04:40:10', 1),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'admin@cps.com', 'S-A', 'Hello admin', '06/01/2022 04:41:13', 1),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'admin@cps.com', 'S-C', 'Hello admin', '06/01/2022 04:41:34', 1),
('sandeep@gmail.com', 'Sandeep S Rajesh', 'admin@cps.com', 'S-A', 'Good Morningssssss', '06/01/2022 05:51:02', 0),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'sandeep@gmail.com', 'C-S', 'Dear Sandeep S Rajesh,<br/><br/>Congratulations. We are so happy to inform you that Stack Overflow you like to extend the offer to you for the position of Python Developer. After interviewing all the candidates, we found you the most suitable person for the job. You will be working directly under [supervisor name], and we believe that your addition to the team will add great value to the company.<br/><br/>Please feel free to reach out to me in case you have any other doubts. We look forward to you joining us and making us bigger and better than ever.<br/><br/>Yours’ sincerely,<br/>Muhammed Ajmal<br/>Stack Overflow', '06/01/2022 05:54:26', 1),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'sandeep@gmail.com', 'C-S', 'Hello', '06/01/2022 05:55:36', 1),
('majmals1998@gmail.com', 'Muhammed Ajmal', 'sandeep@gmail.com', 'C-S', 'Dear Sandeep S Rajesh,<br/><br/>Congratulations. We are so happy to inform you that Stack Overflow you like to extend the offer to you for the position of Python Developer. After interviewing all the candidates, we found you the most suitable person for the job. You will be working directly under [supervisor name], and we believe that your addition to the team will add great value to the company.<br/><br/>Please feel free to reach out to me in case you have any other doubts. We look forward to you joining us and making us bigger and better than ever.<br/><br/>Yours’ sincerely,<br/>Muhammed Ajmal<br/>Stack Overflow', '06/01/2022 06:19:51', 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sid` varchar(20) NOT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `uname` varchar(50) DEFAULT NULL,
  `course` varchar(30) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `pswd` varchar(40) DEFAULT NULL,
  `path` varchar(220) DEFAULT NULL,
  `rpath` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sid`, `sname`, `uname`, `course`, `batch`, `gender`, `phone`, `pswd`, `path`, `rpath`) VALUES
('180021030987', 'Muhammed Ajmal', 'majmals1998@gmail.com', 'B.Sc. Computer Science', 2018, 'Male', '7034834276', 'aju123', 'C:\\Users\\majma\\Desktop\\Desk 003\\Campus_Placement_System\\src\\Uploads\\majmals1998.jpg', 'C:\\Users\\majma\\Desktop\\Desk 003\\Campus_Placement_System\\src\\Uploads\\majmals1998.pdf'),
('180021030989', 'Salman Siyad', 'salman@gmail.com', 'B.Sc. Computer Science', 2018, 'Male', '9999999999', '123', 'C:\\Users\\majma\\Desktop\\Desk 003\\Campus_Placement_System\\src\\Uploads\\img1.png', NULL),
('180021030992', 'Sandeep S Rajesh', 'sandeep@gmail.com', 'B.Sc. Computer Science', 2018, 'Male', '7034834276', 'sandeep', 'C:\\Users\\majma\\Desktop\\Desk 003\\Campus_Placement_System\\src\\Uploads\\sandeep.jpg', 'C:\\Users\\majma\\Desktop\\Desk 003\\Campus_Placement_System\\src\\Uploads\\sandeep.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `vacancies`
--

CREATE TABLE `vacancies` (
  `job` varchar(40) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `cname` varchar(80) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `vacancies` int(11) DEFAULT NULL,
  `jobid` varchar(13) NOT NULL,
  `salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vacancies`
--

INSERT INTO `vacancies` (`job`, `description`, `cname`, `address`, `vacancies`, `jobid`, `salary`) VALUES
('Java Developer', 'Need a java developer who has well in object oriented programming and must knows spring boot', 'Infosys', 'Electronic Street, Trivandrum, 669955', 3, 'JADEIN22JAN', 40000),
('.Net Developer', 'Need a .net developer who has well in object oriented programming', 'Infosys', 'Electronic Street, Trivandrum, 669955', 3, 'NEDEIN22JAN', 32000),
('Python Developer', 'Need a python developer who has well in object oriented programming', 'Stack Overflow', 'New Street, Ernakulam(North), 690899', 5, 'PYDESTOV22JAN', 25000),
('Software Tester', 'null null null null null', 'Stack Overflow', 'New Street, Ernakulam(North), 699399', 5, 'SOTESTOV2JAN', 25000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `appliedjobs`
--
ALTER TABLE `appliedjobs`
  ADD KEY `sid` (`sid`),
  ADD KEY `jobid` (`jobid`);

--
-- Indexes for table `coordinator`
--
ALTER TABLE `coordinator`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `selectstudent`
--
ALTER TABLE `selectstudent`
  ADD PRIMARY KEY (`sid`),
  ADD KEY `jobid` (`jobid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `vacancies`
--
ALTER TABLE `vacancies`
  ADD PRIMARY KEY (`jobid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appliedjobs`
--
ALTER TABLE `appliedjobs`
  ADD CONSTRAINT `appliedjobs_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  ADD CONSTRAINT `appliedjobs_ibfk_2` FOREIGN KEY (`jobid`) REFERENCES `vacancies` (`jobid`);

--
-- Constraints for table `selectstudent`
--
ALTER TABLE `selectstudent`
  ADD CONSTRAINT `selectstudent_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  ADD CONSTRAINT `selectstudent_ibfk_2` FOREIGN KEY (`jobid`) REFERENCES `vacancies` (`jobid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
