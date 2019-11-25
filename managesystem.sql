/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : xsxx

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-04-28 23:23:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cj
-- ----------------------------
DROP TABLE IF EXISTS `cj`;
CREATE TABLE `cj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `xk_id` int(11) DEFAULT NULL,
  `df` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lfbh3i425jj80yy3qrs69onyp` (`teacher_id`),
  KEY `FK_ayor6mxsy2finelbp7f4r7jg9` (`user_id`),
  KEY `FK_a69ssx5nmwbmpx401c9xhxmlf` (`xk_id`),
  CONSTRAINT `FK_a69ssx5nmwbmpx401c9xhxmlf` FOREIGN KEY (`xk_id`) REFERENCES `xk` (`id`),
  CONSTRAINT `FK_ayor6mxsy2finelbp7f4r7jg9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_lfbh3i425jj80yy3qrs69onyp` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cj
-- ----------------------------
INSERT INTO `cj` VALUES ('1', null, null, '1', '1', '5', '34');
INSERT INTO `cj` VALUES ('2', null, null, '1', '1', '2', '45');
INSERT INTO `cj` VALUES ('3', null, null, '1', '1', '6', '4');
INSERT INTO `cj` VALUES ('4', null, null, '1', '1', '1', '68');
INSERT INTO `cj` VALUES ('5', null, null, '1', '4', '2', '33');
INSERT INTO `cj` VALUES ('6', null, null, '1', '4', '6', '54');
INSERT INTO `cj` VALUES ('7', null, null, '1', '3', '8', '45');

-- ----------------------------
-- Table structure for class_room
-- ----------------------------
DROP TABLE IF EXISTS `class_room`;
CREATE TABLE `class_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `zy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_np8vk70qrxf36lajgrqpfcy7g` (`zy_id`),
  CONSTRAINT `FK_np8vk70qrxf36lajgrqpfcy7g` FOREIGN KEY (`zy_id`) REFERENCES `zy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_room
-- ----------------------------
INSERT INTO `class_room` VALUES ('1', '0', '计算机一班', '6');
INSERT INTO `class_room` VALUES ('2', '0', '计算机二班', '6');
INSERT INTO `class_room` VALUES ('3', '0', '语言学研究1班', '4');
INSERT INTO `class_room` VALUES ('4', '0', '语言学研究2班', '3');
INSERT INTO `class_room` VALUES ('5', '1', '1班', '2');

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES ('1', 'admin', '111111', '管理员', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `xy_id` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c8cb92gekfe419vgui3fkj4nu` (`xy_id`),
  CONSTRAINT `FK_c8cb92gekfe419vgui3fkj4nu` FOREIGN KEY (`xy_id`) REFERENCES `xy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '0', '111111', '333', '教师2', 'js2', '4', '1');
INSERT INTO `teacher` VALUES ('2', '0', '33331', '5551', '教师31', 'js31', '3', '1');
INSERT INTO `teacher` VALUES ('3', '1', '1111111', '1111', '1', '1', '3', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `classroom_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_st2tkimjnhcj7ns2v5leu4tm4` (`classroom_id`),
  CONSTRAINT `FK_st2tkimjnhcj7ns2v5leu4tm4` FOREIGN KEY (`classroom_id`) REFERENCES `class_room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '23', null, '0', '111111', '123456', '张三', '2', '2017001', '1');
INSERT INTO `user` VALUES ('2', '58', null, '0', '33331', '33331', '教师311', '1', 'js31', '1');
INSERT INTO `user` VALUES ('3', '1', null, '1', '1111111', '18260357078', '1', '2', '1', '1');
INSERT INTO `user` VALUES ('4', '34', null, '0', '1111111', '222', '王五', '2', '201700356', '3');
INSERT INTO `user` VALUES ('5', null, null, '0', '111111', '1111', '教师1', '2', 'js1', '1');

-- ----------------------------
-- Table structure for xk
-- ----------------------------
DROP TABLE IF EXISTS `xk`;
CREATE TABLE `xk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xk
-- ----------------------------
INSERT INTO `xk` VALUES ('1', '0', '语文');
INSERT INTO `xk` VALUES ('2', '0', '数学');
INSERT INTO `xk` VALUES ('3', '0', '英语');
INSERT INTO `xk` VALUES ('4', '0', '美术');
INSERT INTO `xk` VALUES ('5', '0', '音乐');
INSERT INTO `xk` VALUES ('6', '0', '历史');
INSERT INTO `xk` VALUES ('7', '1', '1');
INSERT INTO `xk` VALUES ('8', '0', '政治');
INSERT INTO `xk` VALUES ('9', '0', '化学');

-- ----------------------------
-- Table structure for xy
-- ----------------------------
DROP TABLE IF EXISTS `xy`;
CREATE TABLE `xy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy
-- ----------------------------
INSERT INTO `xy` VALUES ('1', '0', '计算机');
INSERT INTO `xy` VALUES ('2', '1', '艺术系2');
INSERT INTO `xy` VALUES ('3', '0', '信电学院');
INSERT INTO `xy` VALUES ('4', '0', '美术学院');
INSERT INTO `xy` VALUES ('5', '0', '人文学院');
INSERT INTO `xy` VALUES ('6', '0', '数学学院');

-- ----------------------------
-- Table structure for zy
-- ----------------------------
DROP TABLE IF EXISTS `zy`;
CREATE TABLE `zy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `xy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fgk6esgnu67mcp2enkqm7ehv1` (`xy_id`),
  CONSTRAINT `FK_fgk6esgnu67mcp2enkqm7ehv1` FOREIGN KEY (`xy_id`) REFERENCES `xy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy
-- ----------------------------
INSERT INTO `zy` VALUES ('2', '0', '社会学', '5');
INSERT INTO `zy` VALUES ('3', '0', '社会工作', '5');
INSERT INTO `zy` VALUES ('4', '0', '民族学', '5');
INSERT INTO `zy` VALUES ('5', '0', '汉语言文学', '5');
INSERT INTO `zy` VALUES ('6', '0', '电子信息工程', '3');
INSERT INTO `zy` VALUES ('7', '1', '通信工程2', '1');
