#by doudou

CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



INSERT INTO `admin` VALUES (1,'admin','doudou'),(2,'1','1');


CREATE TABLE `coordinate` (
  `coordinateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '位置',
  `abscissa` double DEFAULT NULL,
  `ordinate` double DEFAULT NULL,
  PRIMARY KEY (`coordinateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `map` (
  `mapId` int(11) NOT NULL AUTO_INCREMENT,
  `coordinateId` int(11) NOT NULL DEFAULT '0',
  `zoom` int(11) DEFAULT NULL,
  PRIMARY KEY (`mapId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Structure for table "user"


CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;



INSERT INTO `user` VALUES (1,'doudou','1234565'),(3,'u','u'),(4,'dddddddd','ddddddd'),(5,'234234','2342342'),(6,'doudoubudou','doudoudou'),(7,'doudoubudou','doudoudou'),(8,'1','1');
