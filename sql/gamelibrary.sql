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

/*Table structure for table `game_category` */

DROP TABLE IF EXISTS `game_category`;

CREATE TABLE `game_category` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `name` varchar(255) NOT NULL COMMENT '类型名称',
  `nickname` varchar(255) DEFAULT NULL COMMENT '类型别称',
  `hots` bigint(20) DEFAULT '0' COMMENT '热度',
  `fans` bigint(20) DEFAULT '0' COMMENT '关注人数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_game_category_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='游戏类型';

/*Data for the table `game_category` */

insert  into `game_category`(`id`,`name`,`nickname`,`hots`,`fans`,`create_time`,`update_time`) values (1,'角色扮演','RPG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(2,'动作','ACT',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(3,'冒险','AVG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(4,'射击','STG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(5,'第一人称射击','FPS',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(6,'第三人称射击','TPS',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(7,'格斗','FTG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(8,'网络','MUD',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(9,'即时战略','RTS',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(10,'策略战棋','SLG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(11,'多人在线战术竞技','MOBA',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(12,'集换式卡牌','TCG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(13,'赛车','RAC',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(14,'运动','SPG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(15,'养成','EDU',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(16,'模拟飞行','FLY',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(17,'模拟经营','SIM',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(18,'体育','SPT',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(19,'桌面棋牌','TAB',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(20,'休闲','ETC',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(21,'益智','PUZ',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(22,'音乐','MUG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(23,'动作角色扮演','A-RPG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(24,'战略角色扮演','S-RPG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(25,'日式角色扮演','J-RPG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(26,'动作冒险','A-AVG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(27,'大型多人在线角色扮演','MMORPG',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52'),(28,'其他','OTH',0,0,'2020-04-10 10:51:52','2020-04-10 10:51:52');

/*Table structure for table `game_company` */

DROP TABLE IF EXISTS `game_company`;

CREATE TABLE `game_company` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '公司编号',
  `name` varchar(255) NOT NULL COMMENT '公司名称',
  `logo` text COMMENT '公司Logo',
  `profile` text COMMENT '公司简介',
  `hots` bigint(20) DEFAULT '0' COMMENT '热度',
  `fans` bigint(20) DEFAULT '0' COMMENT '关注人数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_game_company_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='游戏公司';

/*Data for the table `game_company` */

/*Table structure for table `game_platform` */

DROP TABLE IF EXISTS `game_platform`;

CREATE TABLE `game_platform` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '平台编号',
  `name` varchar(255) NOT NULL COMMENT '平台名称',
  `nickname` varchar(255) DEFAULT NULL COMMENT '平台别称',
  `logo` text COMMENT '平台Logo',
  `note` text COMMENT '说明',
  `url` varchar(255) DEFAULT NULL COMMENT '平台地址',
  `hots` bigint(20) DEFAULT '0' COMMENT '热度',
  `fans` bigint(20) DEFAULT '0' COMMENT '关注人数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_game_platform_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='游戏平台';

/*Data for the table `game_platform` */

insert  into `game_platform`(`id`,`name`,`nickname`,`logo`,`note`,`url`,`hots`,`fans`,`create_time`,`update_time`) values (1,'Steam',NULL,NULL,'Steam 是畅玩游戏、讨论游戏、创造游戏的终极目的地。','https://store.steampowered.com/',0,0,'2020-04-10 13:58:21',NULL),(2,'Origin','橘子',NULL,'Origin是由美国艺电游戏公司(Electronic Arts Inc,简称EA)于2011年发布的游戏社交平台。 主要起到供EA游戏de玩家进行游戏方面交流的作用。','https://www.origin.com/',0,0,'2020-04-10 13:58:26',NULL),(3,'Rockstar Games Launcher','R星游戏启动器',NULL,'Rockstar Games Launcher是R星推出的游戏平台,也可以叫做R星游戏平台,玩家可以在R星游戏平台购买R星推出的PC版游戏,R星游戏平台只有R星自己发行的游戏,没有第三方的游戏作品。','https://www.rockstargames.com/',0,0,'2020-04-10 13:58:28',NULL),(4,'Uplay','育碧',NULL,'Uplay是Ubisoft为扩展自家游戏的延伸价值而开发的，正版玩家可以在游戏过程中解锁各种成就，然后用成就点数换取特殊奖励，比如特殊套装等，同时也会提供一些收费道具给玩家购买。','https://www.ubisoft.com.cn/',0,0,'2020-04-10 13:58:31',NULL),(5,'Battlenet','暴雪战网',NULL,'战网是暴雪公司制作游戏的免费对战平台。','https://www.blizzardgames.cn/',0,0,'2020-04-10 13:58:34',NULL),(6,'Epic',NULL,NULL,'Epic游戏商城是一座精心打造的PC与Mac数字商店，设计时兼顾玩家和创作者的需求。它致力于为玩家提供出色的游戏，并为游戏开发者提供公平的交易。玩家在Epic游戏商城购买游戏时，售价的88%直接归开发者所有。而在许多其他商城中，开发者分成只占70%。这可以帮助开发者投资设计更大、更优质的游戏。','https://www.epicgames.com/',0,0,'2020-04-10 13:58:36',NULL),(7,'Xbox','微软XBox',NULL,'Xbox是由美国微软公司创造并所有的电子游戏品牌。产品包括家用游戏机硬件、游戏制作与发行服务、线上游戏服务和内容订阅服务。','https://www.xbox.com/',0,0,'2020-04-10 13:58:39',NULL),(8,'PlayStation','索尼PS',NULL,'PlayStation(简称PS)是日本索尼公司的著名游戏机系列，中文意为“游戏站”。PS已经推出的版本有PS、PSone、PS2、PSP、PS3、PSV、PSV TV 、PS4。','https://www.playstation.com.cn/',0,0,'2020-04-10 13:58:42',NULL),(9,'Nintendo eshop','任天堂eshop',NULL,'任天堂eShop（日语：ニンテンドーeショップ，英语：NintendoeShop）是一个建立在任天堂Network上的网络商店，针对任天堂3DS,WiiU和Switch主机提供软件销售下载等服务。','https://www.nintendo.com/',0,0,'2020-04-10 13:58:44',NULL),(10,'GOG.com',NULL,NULL,'“GOG.com”（旧称：Good Old Games）是一个数字游戏发行平台。由GOG公司运营，母公司为CD Projekt。“GOG.com”通过无数字版权管理（DRM-free）的方式提供Windows、OS X和Linux的电子游戏。早期，GOG只发行年代较久的游戏，自2012年3月，它开始售卖较为新款的游戏。','https://www.gog.com/',0,0,'2020-04-10 13:58:46',NULL),(11,'杉果',NULL,NULL,'杉果游戏是一款集中了游戏、应用软件的软件市场。它的主要功能是基于web2.0 的扩散性传播特点，对PC、MAC、智能手机、平板电脑等多平台游戏及多平台账户进行同步整合管理，以游戏社区为纽带，构造正版游戏数字商店和对战平台，为玩家提供一站式的游戏服务和体验。','https://www.sonkwo.com/',0,0,'2020-04-10 13:58:48',NULL),(12,'GMG','小绿人',NULL,NULL,'https://www.greenmangaming.com/',0,0,'2020-04-10 13:58:50',NULL);

/*Table structure for table `game_studio` */

DROP TABLE IF EXISTS `game_studio`;

CREATE TABLE `game_studio` (
  `id` varchar(50) NOT NULL COMMENT '工作室编号',
  `name` varchar(255) NOT NULL COMMENT '工作室名称',
  `logo` text COMMENT '工作室Logo',
  `profile` text COMMENT '工作室简介',
  `hots` bigint(20) DEFAULT '0' COMMENT '热度',
  `fans` bigint(20) DEFAULT '0' COMMENT '关注人数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_game_studio_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='游戏工作室';

/*Data for the table `game_studio` */

/*Table structure for table `game_tag` */

DROP TABLE IF EXISTS `game_tag`;

CREATE TABLE `game_tag` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '标签编号',
  `name` varchar(255) NOT NULL COMMENT '标签名称',
  `hots` bigint(20) DEFAULT '0' COMMENT '热度',
  `fans` bigint(20) DEFAULT '0' COMMENT '关注人数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_game_tag_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='游戏标签';

/*Data for the table `game_tag` */

/*Table structure for table `game_way` */

DROP TABLE IF EXISTS `game_way`;

CREATE TABLE `game_way` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '方式编号',
  `name` varchar(255) NOT NULL COMMENT '方式名称',
  `note` text COMMENT '方式说明',
  `hots` bigint(20) DEFAULT '0' COMMENT '热度',
  `fans` bigint(20) DEFAULT '0' COMMENT '关注人数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_game_way_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='游戏方式';

/*Data for the table `game_way` */

insert  into `game_way`(`id`,`name`,`note`,`hots`,`fans`,`create_time`,`update_time`) values (1,'单人',NULL,0,0,'2020-04-10 11:21:53','2020-04-10 11:21:53'),(2,'多人在线',NULL,0,0,'2020-04-10 11:21:53','2020-04-10 11:21:53'),(3,'本地多人',NULL,0,0,'2020-04-10 11:21:53','2020-04-10 11:21:53');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(255) DEFAULT NULL COMMENT 'url描述',
  `nickname` varchar(255) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`id`,`url`,`name`,`nickname`) values (1,'/user','user:user',NULL),(2,'/user/add','user:add',NULL),(3,'/user/delete','user:delete',NULL),(4,'/user/upd','user:upd',NULL),(5,'/user/home','user:home',NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `nickname` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`nickname`) values (1,'system','超级管理员'),(2,'admin','测试账户');

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
  `method` varchar(255) DEFAULT '' COMMENT '请求方法',
  `params` varchar(255) DEFAULT '' COMMENT '请求参数',
  `ip` varchar(255) DEFAULT '' COMMENT 'IP地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `result` text COMMENT '返回值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`name`,`user_id`,`username`,`operation`,`time`,`method`,`params`,`ip`,`create_time`,`result`) values ('1249566327076261888','登录','100','久伴天明','user:login',67,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.16.11.106','2020-04-13 13:13:22',NULL),('1249566403253211136','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:13:41',NULL),('1249566651992215552','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:14:40',NULL),('1249567840829935616','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:19:14',NULL),('1249567874350813184','访问用户home','100','久伴天明','user:home',53292,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:18:34',NULL),('1249568026339807232','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:20:07',NULL),('1249568786871889920','访问用户home','100','久伴天明','user:home',2,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:23:09',NULL),('1249570429445287936','访问用户home','100','久伴天明','user:home',9,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:29:40',NULL),('1249570518125457408','登录','100','久伴天明','user:login',167,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 13:30:01',NULL),('1249570553374388224','退出登录','100','久伴天明','user:logout',5,'com.jacques.shiro.controller.UserController.logout','[]','127.0.0.1','2020-04-13 13:30:10',NULL),('1249570600795189248','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 13:30:21',NULL),('1249570696643424256','退出登录','100','久伴天明','user:logout',1,'com.jacques.shiro.controller.UserController.logout','[]','172.16.11.106','2020-04-13 13:30:44',NULL),('1249571525467254784','登录','100','久伴天明','user:login',187,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:02',NULL),('1249571526952038400','登录','100','久伴天明','user:login',148,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:02',NULL),('1249571527870590976','登录','100','久伴天明','user:login',129,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:02',NULL),('1249571696192204800','登录','100','久伴天明','user:login',166,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:34:42',NULL),('1249572001105522688','登录','100','久伴天明','user:login',169,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.29.5.88','2020-04-13 13:35:55',NULL),('1249572099206098944','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.29.5.88','2020-04-13 13:36:19',NULL),('1249572813969993728','访问用户home','100','久伴天明','user:home',1,'com.jacques.shiro.controller.UserController.home','[]','172.29.5.88','2020-04-13 13:39:09',NULL),('1249572846970777600','登录','100','久伴天明','user:login',80,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 13:39:17',NULL),('1249573068610428928','登录','100','久伴天明','user:login',856,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.16.11.106','2020-04-13 13:40:09',NULL),('1249573139016015872','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-13 13:40:26',NULL),('1249575489524948992','登录','100','久伴天明','user:login',178,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 13:49:47',NULL),('1249577197479063552','登录','100','久伴天明','user:login',830,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','172.16.11.106','2020-04-13 13:56:33',NULL),('1249579597283651584','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:06:06',NULL),('1249581130264014848','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:12:12',NULL),('1249581412939132928','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:13:19',NULL),('1249581435382853632','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:13:24',NULL),('1249584893599084544','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','172.16.11.106','2020-04-13 14:27:09',NULL),('1249626278679212032','登录','100','久伴天明','user:login',163,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-13 17:11:36',NULL),('1249626392000917504','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-13 17:12:03',NULL),('1249980986254061568','登录','100','久伴天明','user:login',834,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-14 16:41:04',NULL),('1249981765392166912','访问用户home','100','久伴天明','user:home',0,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-14 16:44:11',NULL),('1249981905419005952','登录','100','久伴天明','user:login',150,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-14 16:44:44',NULL),('1249981950063177728','登录','100','久伴天明','user:login',146,'com.jacques.shiro.controller.UserController.login','[\"久伴天明\",\"123456\"]','127.0.0.1','2020-04-14 16:44:54',NULL),('1249985401128095744','访问用户home','100','久伴天明','user:home',5,'com.jacques.shiro.controller.UserController.home','[]','127.0.0.1','2020-04-14 16:58:37',NULL),('1283566941142175744','登录',NULL,'','user:login',353,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"123456\"]','0:0:0:0:0:0:0:1','2020-07-16 08:59:40','用户名或密码错误'),('1283566965171343360','登录',NULL,'','user:login',344,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"jacques\"]','0:0:0:0:0:0:0:1','2020-07-16 08:59:46','用户名或密码错误'),('1283566992203632640','登录',NULL,'','user:login',362,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"123456\"]','0:0:0:0:0:0:0:1','2020-07-16 08:59:52','用户名或密码错误'),('1283567004522303488','登录',NULL,'','user:login',334,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"111111\"]','0:0:0:0:0:0:0:1','2020-07-16 08:59:55','用户名或密码错误'),('1283567017667252224','登录',NULL,'','user:login',340,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"qwe123\"]','0:0:0:0:0:0:0:1','2020-07-16 08:59:58','用户名或密码错误'),('1283567075116634112','登录',NULL,'','user:login',369,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"qwe123\"]','0:0:0:0:0:0:0:1','2020-07-16 09:00:12','用户名或密码错误'),('1283567334446256128','登录','1','admin','user:login',808,'com.jacques.shiro.controller.UserController.login','[\"admin\",\"123456\"]','0:0:0:0:0:0:0:1','2020-07-16 09:01:13','登陆成功');

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

insert  into `user`(`id`,`username`,`password`,`tel`,`create_time`,`status`,`role_id`) values (1,'admin','03807a341da26eee919fb89949ad1d8e','13025029606','2019-12-13 16:10:06',0,1),(100,'久伴天明','03807a341da26eee919fb89949ad1d8e','13025029501','2019-12-26 18:00:04',0,2),(100201,'泪雨千殇','03807a341da26eee919fb89949ad1d8e','13025029612','2019-12-26 18:00:04',0,2),(100231,'漫天花落','03807a341da26eee919fb89949ad1d8e','13025029621','2019-12-26 18:00:04',0,2),(1002311,'无知罪人','03807a341da26eee919fb89949ad1d8e','13025029636','2019-12-26 18:00:04',0,2),(1002501,'情怀千古','03807a341da26eee919fb89949ad1d8e','13025029669','2019-12-26 18:00:04',0,2),(1002511,'无心之过','03807a341da26eee919fb89949ad1d8e','13025029647','2019-12-26 18:00:04',0,2);

/*Table structure for table `website_statistics` */

DROP TABLE IF EXISTS `website_statistics`;

CREATE TABLE `website_statistics` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '网站名',
  `visits` bigint(64) DEFAULT '0' COMMENT '浏览数',
  `url` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `website_statistics` */

insert  into `website_statistics`(`id`,`name`,`visits`,`url`,`create_time`) values ('1204290268715565056','Music2.0',1,'6s.net579.com:24630','2019-12-10 14:42:32'),('1204290491131162624','Music2.0',0,'6s.net579.com:24630','2019-12-10 14:43:25'),('1204290713613889536','Music2.0',6,'6s.net579.com:24630','2019-12-10 14:44:18'),('1204291928959537152','Music2.0',0,'6s.net579.com:24630','2019-12-10 14:49:08');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
