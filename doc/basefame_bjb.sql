-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: baseframe
-- ------------------------------------------------------
-- Server version	5.7.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_dictgroup`
--

DROP TABLE IF EXISTS `sys_dictgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dictgroup` (
  `DICTGROUP_ID` bigint(3) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DICTGROUP_CD` varchar(20) NOT NULL COMMENT '类型代码',
  `DICTGROUP_NM` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间戳',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  `DICTGROUP_ORDER` int(11) DEFAULT NULL COMMENT '排序值',
  `DICTGROUP_OTHER1` varchar(256) DEFAULT '',
  `DICTGROUP_OTHER2` varchar(256) DEFAULT '',
  `DICTGROUP_OTHER3` varchar(256) DEFAULT '',
  PRIMARY KEY (`DICTGROUP_ID`),
  UNIQUE KEY `cd_unique` (`DICTGROUP_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dictgroup`
--

LOCK TABLES `sys_dictgroup` WRITE;
/*!40000 ALTER TABLE `sys_dictgroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dictgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dictvalue`
--

DROP TABLE IF EXISTS `sys_dictvalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dictvalue` (
  `DICTVALUE_ID` char(32) NOT NULL COMMENT '主键',
  `DICTGROUP_CD` varchar(20) NOT NULL COMMENT '类型代码',
  `DICTVALUE_VALUE` varchar(128) NOT NULL COMMENT '类型值',
  `DICTVALUE_MEAN` varchar(256) DEFAULT NULL COMMENT '值含义',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间戳',
  `DICTVALUE_ORDER` int(11) DEFAULT NULL COMMENT '排序值',
  `DICTVALUE_OTHER1` varchar(256) DEFAULT '',
  `DICTVALUE_OTHER2` varchar(256) DEFAULT '',
  `DICTVALUE_OTHER3` varchar(256) DEFAULT '',
  PRIMARY KEY (`DICTVALUE_ID`),
  KEY `AK_Key_2` (`DICTGROUP_CD`,`DICTVALUE_VALUE`),
  KEY `Index_1` (`DICTGROUP_CD`),
  KEY `INDEX_DICTMEAN` (`DICTVALUE_MEAN`),
  KEY `INDEX_DICTVALUE` (`DICTVALUE_VALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典值表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dictvalue`
--

LOCK TABLES `sys_dictvalue` WRITE;
/*!40000 ALTER TABLE `sys_dictvalue` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dictvalue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_img`
--

DROP TABLE IF EXISTS `sys_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_img` (
  `IMG_ID` bigint(1) NOT NULL AUTO_INCREMENT,
  `IMG_TYPE` int(2) NOT NULL DEFAULT '1' COMMENT '图片类型',
  `IMG_REMARKS` varchar(256) DEFAULT NULL COMMENT '描述',
  `IMG_URL` varchar(100) NOT NULL COMMENT '图片地址',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `ORG_CD` char(9) DEFAULT NULL COMMENT '组织机构代码',
  `IMG_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IMG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_img`
--

LOCK TABLES `sys_img` WRITE;
/*!40000 ALTER TABLE `sys_img` DISABLE KEYS */;
INSERT INTO `sys_img` VALUES (4,1,NULL,'http://localhost:8088/my/static/images/root/1/20190318/1552880496354_375.jpg','2019-03-18 03:41:36','root',NULL),(5,1,NULL,'http://localhost:8088/my/static/images/root/1/20190319/1552976965151_73.jpg','2019-03-19 06:29:25','root',NULL),(6,1,NULL,'http://localhost:8088/my/static/images/root/1/20190319/1552979437512_685.jpg','2019-03-19 07:10:37','root',NULL),(7,1,NULL,'http://localhost:8088/my/static/images/root/1/20190319/1552979445730_837.gif','2019-03-19 07:10:45','root',NULL),(8,1,'123445','http://localhost:8088/my/static/images/root/1/20190319/1552979606946_607.jpg','2019-03-19 07:13:26','root',NULL),(9,1,'123备注','http://localhost:8088/my/static/images/root/1/20190319/1552980385607_420.jpg','2019-03-19 07:26:25','root','123'),(10,1,'','http://localhost:8088/my/static/images/root/1/20190401/1554083713700_943.png','2019-04-01 01:55:13','root','单页'),(11,1,'','http://localhost:8088/my/static/images/root/1/20190401/1554083799674_19.png','2019-04-01 01:56:39','root','单页编辑');
/*!40000 ALTER TABLE `sys_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `MENU_ID` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MENU_CD` varchar(30) DEFAULT NULL COMMENT '菜单code',
  `MENU_NM` varchar(256) DEFAULT NULL COMMENT '菜单名称',
  `MENU_ORDER` int(11) DEFAULT NULL COMMENT '菜单排序值',
  `SUP_MENU_CD` varchar(30) DEFAULT NULL COMMENT '父级菜单code',
  `MENU_INDEX` text COMMENT '菜单索引',
  `MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `MENU_IMG` text COMMENT '菜单图片',
  `MENU_TYPE` varchar(256) DEFAULT NULL COMMENT '菜单类型',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  `MENU_ISPARENT` smallint(5) unsigned DEFAULT '0' COMMENT '是否有子级',
  `PAGE_TYPE` varchar(255) DEFAULT NULL COMMENT '页面类型',
  `BTN_POSITION` varchar(255) DEFAULT NULL COMMENT '按钮位置',
  `MENU_OTHER1` varchar(255) DEFAULT NULL COMMENT '按钮方法',
  `MENU_OTHER2` varchar(255) DEFAULT NULL COMMENT '打开图标',
  `MENU_OTHER3` varchar(255) DEFAULT NULL COMMENT '关闭图标',
  `MENU_OTHER4` varchar(255) DEFAULT '0' COMMENT '基础按钮',
  `MENU_OTHER5` varchar(255) DEFAULT NULL,
  `MENU_OTHER6` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`),
  UNIQUE KEY `cd_unique` (`MENU_CD`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'root','root',1,' ','root',NULL,NULL,NULL,'2019-05-30 05:59:19',NULL,1,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL),(11,'sysOrg','组织机构',10,'xtgn','root_xtgn_sysOrg','sysOrg',NULL,'2','2019-05-31 02:25:04',NULL,0,'1','1','','','','0',NULL,NULL),(14,'sysUser','用户管理',10,'xtgn','xtgn_xtgn_sysUser','sysUser',NULL,'2','2019-05-31 02:25:40',NULL,0,'1','1','','','','0',NULL,NULL),(15,'sysRole','角色管理',10,'xtgn','xtgn_xtgn_sysRole','sysRole',NULL,'2','2019-05-31 02:25:33',NULL,0,'1','1','','','','0',NULL,NULL),(16,'sysMenu','菜单管理',10,'xtgn','root_xtgn_sysMenu','sysMenu',NULL,'2','2019-05-31 02:25:16',NULL,0,'1','1','','','','0',NULL,NULL),(17,'xtgn','系统功能',10,'root','root_xtgn','',NULL,'2','2019-05-30 08:33:33',NULL,1,'2','1','','','','0',NULL,NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_org` (
  `org_id` bigint(3) NOT NULL AUTO_INCREMENT,
  `ORG_NM` varchar(100) NOT NULL COMMENT '组织机构名称',
  `ORG_CD` char(9) NOT NULL COMMENT '组织机构代码',
  `ORG_TYPE` int(11) NOT NULL COMMENT '组织机构类型',
  `ORG_SHNM` varchar(40) DEFAULT NULL COMMENT '组织机构简称',
  `CONTACT` varchar(20) DEFAULT NULL COMMENT '联系人',
  `PHONE` varchar(22) DEFAULT NULL COMMENT '联系电话',
  `E_MAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `AD_CD` char(6) DEFAULT NULL COMMENT '行政区划代码',
  `ADDR` varchar(100) DEFAULT NULL COMMENT '地址',
  `TEL` varchar(22) DEFAULT NULL COMMENT '办公室电话',
  `FAX` varchar(22) DEFAULT NULL COMMENT '传真号码',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  `ORG_STATUS` int(11) DEFAULT '1' COMMENT '状态',
  `ENG_MAN_CD` char(9) DEFAULT NULL COMMENT '所属组织机构代码',
  `ORG_INDEX` text COMMENT '索引',
  `MAJ_BUS` varchar(1024) DEFAULT NULL COMMENT '主要业务内容',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `ORG_ISPARENT` smallint(5) unsigned DEFAULT '0' COMMENT '是否有子节点',
  `ORG_IMG` varchar(255) DEFAULT NULL,
  `ORG_ORDER` int(11) DEFAULT NULL,
  `ORG_WELCOME` varchar(255) DEFAULT NULL COMMENT '首页地址',
  `ORG_STYLELIB` varchar(255) DEFAULT NULL COMMENT '样式库',
  `login_bgImg` varchar(255) DEFAULT NULL COMMENT '登录背景图',
  PRIMARY KEY (`org_id`),
  UNIQUE KEY `cd_unique` (`ORG_CD`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='组织机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_org`
--

LOCK TABLES `sys_org` WRITE;
/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` VALUES (1,'黄壁庄2','hbz2',1,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,1,'hb','root_hb_hbz2',NULL,'2019-10-02 05:25:41',1,NULL,1,'sysOrg','hbz','http://localhost:8088/my/static/images/root/1/20190318/1552880496354_375.jpg'),(2,'root','root',1,'根','whm','15176867639','862971433@qq.com',NULL,NULL,NULL,NULL,NULL,1,NULL,'root',NULL,'2019-04-01 02:06:20',1,NULL,0,'sysOrg',NULL,NULL),(3,'介休水资源','jx_szy',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'root','root_jx_szy',NULL,'2019-04-01 09:15:07',1,NULL,18,'',NULL,''),(5,'tre2','tret3',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbz','root_tre2t33',NULL,'2019-05-31 01:07:55',0,NULL,10,'',NULL,''),(8,'3','3',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'jx_szy','root_jx_szy_3',NULL,'2019-04-01 09:13:47',0,NULL,10,'',NULL,''),(9,'32','32',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbz','root_32',NULL,'2019-05-31 01:07:46',1,NULL,10,'',NULL,''),(12,'测试2','test2',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'jsgyy','root_hb_sjz_qxq_jsgyy_test2',NULL,'2019-05-31 02:15:18',1,NULL,10,'',NULL,''),(13,'tre','tre2',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'test2','root_hb_sjz_qxq_jsgyy_test2_tre2',NULL,'2019-10-02 04:08:57',0,NULL,10,'',NULL,''),(25,'石家庄','sjz',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hb','root_hb_sjz',NULL,'2019-05-31 02:13:24',1,NULL,10,'',NULL,''),(26,'河北','hb',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'root','root_hb',NULL,'2019-05-31 02:13:24',1,NULL,10,'',NULL,''),(28,'桥西区','qxq',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'sjz','root_hb_sjz_qxq',NULL,'2019-05-31 02:11:17',1,NULL,10,'',NULL,''),(29,'金石工业园','jsgyy',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'qxq','root_hb_sjz_qxq_jsgyy',NULL,'2019-05-31 02:15:18',1,NULL,10,'',NULL,''),(31,'恒源水务','hysw',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbz2','root_hb_hbz22_hysw',NULL,'2019-05-31 02:14:28',0,NULL,10,'',NULL,'');
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_parameter`
--

DROP TABLE IF EXISTS `sys_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_parameter` (
  `PARAMETER_ID` bigint(3) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PARAMETER_NM` varchar(120) NOT NULL COMMENT '参数名称',
  `PARAMETER_CD` varchar(20) NOT NULL COMMENT '参数code',
  `PARAMETER_VALUE` varchar(128) NOT NULL COMMENT '参数值',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间戳',
  `PARAMETER_ORDER` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`PARAMETER_ID`),
  UNIQUE KEY `cd_unique` (`PARAMETER_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_parameter`
--

LOCK TABLES `sys_parameter` WRITE;
/*!40000 ALTER TABLE `sys_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `ROLE_ID` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_NM` varchar(128) NOT NULL COMMENT '角色名称',
  `ROLE_CD` varchar(30) NOT NULL COMMENT '角色code',
  `ROLE_STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '角色状态',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `ROLE_ORDER` int(11) DEFAULT NULL COMMENT '排序值',
  `ORG_CD` char(9) NOT NULL COMMENT '组织机构代码',
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `role_cd_unique` (`ROLE_CD`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (8,'1','1',0,'1','2019-05-17 03:58:05',10,'root'),(9,'3','3',0,'3','2019-05-21 05:52:39',10,'root'),(10,'tre','tre',0,'','2019-05-30 08:44:23',10,'tre2');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_rolemenu`
--

DROP TABLE IF EXISTS `sys_rolemenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_rolemenu` (
  `ROLEMENU_ID` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_CD` varchar(30) NOT NULL COMMENT '角色code',
  `MENU_CD` varchar(30) NOT NULL COMMENT '菜单code',
  PRIMARY KEY (`ROLEMENU_ID`),
  UNIQUE KEY `com_unique` (`ROLE_CD`,`MENU_CD`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_rolemenu`
--

LOCK TABLES `sys_rolemenu` WRITE;
/*!40000 ALTER TABLE `sys_rolemenu` DISABLE KEYS */;
INSERT INTO `sys_rolemenu` VALUES (15,'1','4'),(18,'1','5'),(16,'1','e'),(17,'1','ee'),(26,'3','21'),(23,'3','4'),(24,'3','5');
/*!40000 ALTER TABLE `sys_rolemenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `USER_ID` bigint(1) NOT NULL AUTO_INCREMENT,
  `USER_CD` varchar(50) NOT NULL COMMENT '登录名',
  `USER_NM` varchar(50) DEFAULT NULL COMMENT '姓名',
  `USER_PW` varchar(50) DEFAULT NULL COMMENT '密码',
  `USER_SEX` int(1) NOT NULL COMMENT '性别',
  `USER_STATUS` int(1) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `AD_CD` char(6) DEFAULT NULL COMMENT '行政区划代码',
  `ADDR` varchar(100) DEFAULT NULL COMMENT '地址',
  `USER_TEL` varchar(22) DEFAULT NULL COMMENT '联系电话',
  `USER_QQ` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `USER_E_MAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `ORG_CD` char(9) DEFAULT NULL COMMENT '组织机构代码',
  `USER_SALT` varchar(60) NOT NULL COMMENT '加密盐',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `cd_unique` (`USER_CD`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'superadmin','超级管理员','9859A8ADBEB5BC97F5B9380F2394332275DB2EAB5A572374',2,1,NULL,NULL,'15176867639',NULL,NULL,'2019-05-22 03:12:22','root','qdvftgbhyjmk'),(2,'admin','管理员','9859A8ADBEB5BC97F5B9380F2394332275DB2EAB5A572374',1,1,NULL,NULL,' ',NULL,NULL,'2019-10-02 02:01:43','hbz2','qdvftgbhyjmk'),(3,'1','1','9859A8ADBEB5BC97F5B9380F2394332275DB2EAB5A572374',1,1,NULL,NULL,'1',NULL,NULL,'2019-05-23 01:46:39','root','qdvftgbhyjmk'),(5,'3','3','321C6EBFC1373C8B1008ED33B1687CA412E89B75F5D32B90',1,1,NULL,NULL,'3',NULL,NULL,'2019-05-23 02:11:25','root','336033'),(6,'tre','tre','3638D41F6ACB24C7E53AD3ABF141ECB2FF6286265B337AC0',1,1,NULL,NULL,'',NULL,NULL,'2019-05-30 08:44:07','tre','917342'),(7,'hhbz_user','hbz_user','0212811C1683497F3459BA6A85E2B09DE060F2A817E5D1EE',2,1,NULL,NULL,'16176867680',NULL,NULL,'2019-10-01 13:52:37','hbz2','668189');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_usermenu`
--

DROP TABLE IF EXISTS `sys_usermenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_usermenu` (
  `USERMENU_ID` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MENU_CD` varchar(30) NOT NULL COMMENT '菜单code',
  `USER_CD` varchar(50) NOT NULL COMMENT '登录名',
  PRIMARY KEY (`USERMENU_ID`),
  UNIQUE KEY `com_unique` (`MENU_CD`,`USER_CD`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_usermenu`
--

LOCK TABLES `sys_usermenu` WRITE;
/*!40000 ALTER TABLE `sys_usermenu` DISABLE KEYS */;
INSERT INTO `sys_usermenu` VALUES (31,'root','superadmin'),(33,'sysMenu','superadmin'),(34,'sysOrg','superadmin'),(35,'sysRole','superadmin'),(36,'sysUser','superadmin'),(32,'xtgn','superadmin');
/*!40000 ALTER TABLE `sys_usermenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_userrole`
--

DROP TABLE IF EXISTS `sys_userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_userrole` (
  `USERROLE_ID` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户id',
  `ROLE_CD` varchar(30) NOT NULL COMMENT '角色code',
  PRIMARY KEY (`USERROLE_ID`),
  UNIQUE KEY `com_unique` (`USER_ID`,`ROLE_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_userrole`
--

LOCK TABLES `sys_userrole` WRITE;
/*!40000 ALTER TABLE `sys_userrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-15 22:35:25
