/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.62 : Database - common
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`common` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `common`;

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(255) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`id`,`url`,`name`) values (1,'/user','user:user'),(2,'/user/add','user:add'),(3,'/user/delete','user:delete'),(4,'/user/upd','user:upd'),(5,'/user/home','user:home');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `memo` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`memo`) values (1,'system','超级管理员'),(2,'admin','测试账户');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `rid` int(11) NOT NULL COMMENT '角色id',
  `pid` int(11) NOT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

insert  into `role_permission`(`rid`,`pid`) values (1,2),(1,3),(2,1),(1,1),(1,4),(2,5);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '操作名称',
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(255) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(255) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`name`,`user_id`,`username`,`operation`,`time`,`method`,`params`,`ip`,`create_time`) values ('1249566327076261888','登录','100','久伴天明','user:login',67,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.16.11.106','2020-04-13 13:13:22'),('1249566403253211136','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:13:41'),('1249566651992215552','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:14:40'),('1249567840829935616','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:19:14'),('1249567874350813184','访问用户home','100','久伴天明','user:home',53292,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:18:34'),('1249568026339807232','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:20:07'),('1249568786871889920','访问用户home','100','久伴天明','user:home',2,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:23:09'),('1249570429445287936','访问用户home','100','久伴天明','user:home',9,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:29:40'),('1249570518125457408','登录','100','久伴天明','user:login',167,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 13:30:01'),('1249570553374388224','退出登录','100','久伴天明','user:logout',5,'com.jacques.shiro.controller.UserController.logout','[]','127.0.0.1','2020-04-13 13:30:10'),('1249570600795189248','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:30:21'),('1249570696643424256','退出登录','100','久伴天明','user:logout',1,'com.jacques.shiro.controller.UserController.logout','[]','172.16.11.106','2020-04-13 13:30:44'),('1249571525467254784','登录','100','久伴天明','user:login',187,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:02'),('1249571526952038400','登录','100','久伴天明','user:login',148,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:02'),('1249571527870590976','登录','100','久伴天明','user:login',129,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:02'),('1249571696192204800','登录','100','久伴天明','user:login',166,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:42'),('1249572001105522688','登录','100','久伴天明','user:login',169,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:35:55'),('1249572099206098944','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.29.5.88','2020-04-13 13:36:19'),('1249572813969993728','访问用户home','100','久伴天明','user:home',1,'com.jacques.shiro.controller.UserController.home','[]','172.29.5.88','2020-04-13 13:39:09'),('1249572846970777600','登录','100','久伴天明','user:login',80,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 13:39:17'),('1249573068610428928','登录','100','久伴天明','user:login',856,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.16.11.106','2020-04-13 13:40:09'),('1249573139016015872','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-13 13:40:26'),('1249575489524948992','登录','100','久伴天明','user:login',178,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 13:49:47'),('1249577197479063552','登录','100','久伴天明','user:login',830,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.16.11.106','2020-04-13 13:56:33'),('1249579597283651584','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:06:06'),('1249581130264014848','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:12:12'),('1249581412939132928','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:13:19'),('1249581435382853632','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:13:24'),('1249584893599084544','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:27:09'),('1249626278679212032','登录','100','久伴天明','user:login',163,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 17:11:36'),('1249626392000917504','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-13 17:12:03'),('1249980986254061568','登录','100','久伴天明','user:login',834,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-14 16:41:04'),('1249981765392166912','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-14 16:44:11'),('1249981905419005952','登录','100','久伴天明','user:login',150,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-14 16:44:44'),('1249981950063177728','登录','100','久伴天明','user:login',146,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-14 16:44:54'),('1249985401128095744','访问用户home','100','久伴天明','user:home',5,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-14 16:58:37');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `tel` varchar(11) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `role_id` int(11) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002512 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`tel`,`create_time`,`status`,`role_id`) values (1,'admin','6fd5042cc21a5be436bfa8dac3c55063','13025029606','2019-12-13 16:10:06',0,1),(100,'久伴天明','03807a341da26eee919fb89949ad1d8e','13025029501','2019-12-26 18:00:04',0,2),(100201,'泪雨千殇','03807a341da26eee919fb89949ad1d8e','13025029612','2019-12-26 18:00:04',0,2),(100231,'漫天花落','03807a341da26eee919fb89949ad1d8e','13025029621','2019-12-26 18:00:04',0,2),(1002311,'无知罪人','03807a341da26eee919fb89949ad1d8e','13025029636','2019-12-26 18:00:04',0,2),(1002501,'情怀千古','03807a341da26eee919fb89949ad1d8e','13025029669','2019-12-26 18:00:04',0,2),(1002511,'无心之过','03807a341da26eee919fb89949ad1d8e','13025029647','2019-12-26 18:00:04',0,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
