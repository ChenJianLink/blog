/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.29 : Database - db_blog3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_blog3` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_blog3`;

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `summary` varchar(400) DEFAULT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `clickHit` int(11) DEFAULT NULL,
  `replyHit` int(11) DEFAULT NULL,
  `content` text,
  `typeId` int(11) DEFAULT NULL,
  `keyWord` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `t_blogtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`title`,`summary`,`releaseDate`,`clickHit`,`replyHit`,`content`,`typeId`,`keyWord`) values (62,'hello world','1111','2017-04-13 23:17:43',3,1,'<p>1111</p>',5,''),(63,'111','11','2017-04-13 23:21:44',1,0,'<p>11<img src=\"/static/userImages/20170413/1492096900067062177.jpg\" title=\"1492096900067062177.jpg\" alt=\"Penguins.jpg\"/></p>',5,''),(64,'111','111','2017-04-14 20:17:42',0,0,'<p>111<br/></p>',3,''),(65,'111','111','2017-04-14 21:22:21',71,1,'<p>111</p>',1,''),(66,'111','1111','2017-04-15 15:56:40',0,0,'<p><img src=\"/static/userImages/20170415/1492242983262004445.jpg\" title=\"1492242983262004445.jpg\" alt=\"Desert.jpg\"/>1111</p>',1,''),(67,'222','2222222222222','2017-04-20 21:03:06',26,2,'<p>2222222222222</p>',1,'');

/*Table structure for table `t_blogger` */

DROP TABLE IF EXISTS `t_blogger`;

CREATE TABLE `t_blogger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profile` text,
  `nickName` varchar(50) DEFAULT NULL,
  `sign` varchar(100) DEFAULT NULL,
  `imageName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_blogger` */

insert  into `t_blogger`(`id`,`userName`,`password`,`profile`,`nickName`,`sign`,`imageName`) values (1,'admin','c15955bcc3a43cf7f65514a378269323','<p style=\"margin-bottom: 5px;\">hello</p>','hello','test','20170507010814.jpg');

/*Table structure for table `t_blogtype` */

DROP TABLE IF EXISTS `t_blogtype`;

CREATE TABLE `t_blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_blogtype` */

insert  into `t_blogtype`(`id`,`typeName`,`orderNo`) values (1,'Java核心基础',1),(3,'Tomcat',3),(5,'随心生活',7),(16,'spring',2),(17,'mybatis',10);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userIp` varchar(50) DEFAULT NULL,
  `blogId` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `commentDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=341 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`userIp`,`blogId`,`content`,`commentDate`,`state`) values (336,'0:0:0:0:0:0:0:1',62,'11111','2017-04-13 23:18:16',1),(337,'0:0:0:0:0:0:0:1',65,'1111','2017-04-14 21:23:15',1),(338,'0:0:0:0:0:0:0:1',67,'1111','2017-05-01 21:07:34',1),(339,'0:0:0:0:0:0:0:1',67,'111','2017-05-01 21:11:25',1),(340,'0:0:0:0:0:0:0:1',68,'1111y突然他摇摇头要33333344444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444若434555444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444','2017-05-04 10:49:08',2);

/*Table structure for table `t_link` */

DROP TABLE IF EXISTS `t_link`;

CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(100) DEFAULT NULL,
  `linkUrl` varchar(200) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_link` */

insert  into `t_link`(`id`,`linkName`,`linkUrl`,`orderNo`) values (3,'小图标下载','http://www.easyicon.net/',3),(4,'Java贴吧','http://tieba.baidu.com/f?kw=java',4),(5,'免费logo在线制作','http://www.uugai.com/',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
