# Host: localhost  (Version 5.5.21)
# Date: 2016-08-30 18:52:46
# Generator: MySQL-Front 5.3  (Build 5.21)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

CREATE TABLE `admin` (
  `admin_userName` varchar(20) NOT NULL,
  `admin_password` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES ('doudou','123456');

#
# Structure for table "customer"
#

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_ic` varchar(20) NOT NULL,
  `customer_name` varchar(30) NOT NULL,
  `customer_phone` varchar(20) NOT NULL,
  `customer_sex` tinyint(1) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_ic` (`customer_ic`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "customer"
#

INSERT INTO `customer` VALUES (1,'412825199110114157','豆方','18037801938',1);

#
# Structure for table "report"
#

CREATE TABLE `report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `report_date` date NOT NULL,
  `report_ordersum` int(11) DEFAULT '0',
  `report_checkin` int(11) DEFAULT '0',
  `report_income` int(11) DEFAULT '0',
  PRIMARY KEY (`report_id`),
  UNIQUE KEY `report_date` (`report_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "report"
#

INSERT INTO `report` VALUES (1,'2016-03-15',6,11,1100);

#
# Structure for table "type"
#

CREATE TABLE `type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(30) NOT NULL,
  `type_price` int(11) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "type"
#

INSERT INTO `type` VALUES (1,'标准间',100),(2,'商务间',200),(3,'总统间',5000);

#
# Structure for table "room"
#

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_num` int(11) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `room_floor` int(11) NOT NULL,
  `room_state` int(11) NOT NULL,
  PRIMARY KEY (`room_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "room"
#

INSERT INTO `room` VALUES (1,101,1,1,0),(2,102,1,1,0),(3,103,1,1,0),(4,104,1,1,0),(5,105,1,1,0),(6,106,1,1,0),(7,201,1,2,0),(8,202,1,2,0),(9,203,1,2,0),(10,204,1,2,0),(11,205,1,2,0),(12,206,1,2,0),(13,301,1,3,0),(14,302,1,3,0),(15,303,1,3,0),(16,304,2,3,0),(17,305,2,3,0),(18,306,2,3,0),(19,401,1,4,0),(20,402,1,4,0),(21,403,1,4,0),(22,404,2,4,0),(23,405,2,4,0),(24,406,2,4,0),(25,501,1,5,0),(26,502,1,5,0),(27,503,1,5,0),(28,504,2,5,0),(29,505,2,5,0),(30,506,2,5,0),(31,601,1,6,0),(32,602,1,6,0),(33,603,1,6,0),(34,604,3,6,0),(35,605,3,6,0),(36,606,3,6,0);

#
# Structure for table "book"
#

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `book_time` date NOT NULL,
  `book_start` date NOT NULL,
  `book_leave` date NOT NULL,
  `book_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `room_id` (`room_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "book"
#

INSERT INTO `book` VALUES (1,1,1,'2016-03-15','2016-03-15','2016-03-16',1),(2,2,1,'2016-03-15','2016-03-15','2016-03-16',1),(3,33,1,'2016-03-15','2016-03-16','2016-03-17',1);

#
# Structure for table "io"
#

CREATE TABLE `io` (
  `io_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `io_intime` datetime NOT NULL,
  `io_outtime` datetime DEFAULT NULL,
  `io_last` int(11) NOT NULL,
  `io_state` tinyint(1) NOT NULL,
  PRIMARY KEY (`io_id`),
  KEY `room_id` (`room_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `io_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `io_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "io"
#

INSERT INTO `io` VALUES (1,1,1,'2016-03-15 23:46:55','2016-03-15 23:47:15',24,1),(2,1,2,'2016-03-15 23:51:07','2016-03-15 23:52:34',72,1),(3,1,33,'2016-03-15 23:51:10','2016-03-15 23:52:36',48,1);
