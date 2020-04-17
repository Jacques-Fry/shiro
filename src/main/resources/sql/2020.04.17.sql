/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.27 : Database - common
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
  `user_id` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(255) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `params` text COMMENT '请求参数',
  `result` varchar(255) DEFAULT NULL COMMENT '操作结果',
  `ip` varchar(4000) DEFAULT NULL COMMENT 'IP地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`name`,`user_id`,`username`,`operation`,`time`,`method`,`params`,`result`,`ip`,`create_time`) values ('1251118861826342912','登录','100201','泪雨千殇','user:login',196,'com.jacques.shiro.controller.UserController.login','[\"泪雨千殇\",\"123456\"]','登陆成功','127.0.0.1','2020-04-17 20:02:35'),('1251121003039461376','登录','100201','泪雨千殇','user:login',247,'com.jacques.shiro.controller.UserController.login','[\"泪雨千殇\",\"123456\"]','登陆成功','127.0.0.1','2020-04-17 20:11:06'),('1251121169603661824','退出登录',NULL,NULL,'user:logout',2,'com.jacques.shiro.controller.UserController.logout','[]','退出成功','127.0.0.1','2020-04-17 20:11:46'),('1251121635662184448','退出登录',NULL,NULL,'user:logout',106,'com.jacques.shiro.controller.UserController.logout','[]','退出成功','127.0.0.1','2020-04-17 20:13:37'),('1251121913811623936','退出登录',NULL,NULL,'user:logout',64,'com.jacques.shiro.controller.UserController.logout','[]','退出成功','127.0.0.1','2020-04-17 20:14:43'),('1251125820088573952','退出登录',NULL,NULL,'user:logout',3,'com.jacques.shiro.controller.UserController.logout','[]','退出成功','127.0.0.1','2020-04-17 20:30:14'),('1251126483728130048','退出登录',NULL,NULL,'user:logout',2,'com.jacques.shiro.controller.UserController.logout','[]','退出成功','127.0.0.1','2020-04-17 20:32:53'),('1251126487062601728','退出登录',NULL,NULL,'user:logout',2,'com.jacques.shiro.controller.UserController.logout','[]','退出成功','127.0.0.1','2020-04-17 20:32:53'),('1251126702125539328','登录','100201','泪雨千殇','user:login',194,'com.jacques.shiro.controller.UserController.login','[\"泪雨千殇\",\"123456\"]','登陆成功','127.0.0.1','2020-04-17 20:33:45'),('1251129370311057408','访问用户home','100201','泪雨千殇','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','访问home成功','127.0.0.1','2020-04-17 20:44:21'),('1251129425059307520','访问用户home','100201','泪雨千殇','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','访问home成功','127.0.0.1','2020-04-17 20:44:34'),('1251129635911163904','访问用户home','100201','泪雨千殇','user:home',2,'com.jacques.shiro.controller.UserController.home','[]','访问home成功','127.0.0.1','2020-04-17 20:45:24');

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
