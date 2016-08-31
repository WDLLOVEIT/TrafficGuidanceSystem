# Host: localhost  (Version 5.5.21)
# Date: 2016-08-31 08:36:48
# Generator: MySQL-Front 5.3  (Build 5.21)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'admin','doudou'),(2,'1','1');

#
# Structure for table "coordinate"
#

CREATE TABLE `coordinate` (
  `coordinateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '位置',
  `abscissa` double DEFAULT NULL,
  `ordinate` double DEFAULT NULL,
  PRIMARY KEY (`coordinateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "coordinate"
#


#
# Structure for table "map"
#

CREATE TABLE `map` (
  `mapId` int(11) NOT NULL AUTO_INCREMENT,
  `coordinateId` int(11) NOT NULL DEFAULT '0',
  `zoom` int(11) DEFAULT NULL,
  PRIMARY KEY (`mapId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "map"
#


#
# Structure for table "user"
#

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'doudou','1234565'),(3,'u','u'),(4,'dddddddd','ddddddd'),(5,'234234','2342342'),(6,'doudoubudou','doudoudou'),(7,'doudoubudou','doudoudou'),(8,'1','1');
