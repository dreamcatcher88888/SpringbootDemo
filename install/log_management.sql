/*
Navicat MySQL Data Transfer

Source Server         : 10.x.x.x
Source Server Version : 50723
Source Host           : 10.x.x.x:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-10-10 09:22:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `log_management`
-- ----------------------------
DROP TABLE IF EXISTS `log_management`;
CREATE TABLE `log_management` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user` varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  `detail` text,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_management
-- ----------------------------
INSERT INTO `log_management` VALUES ('1925', 'admin', 'create', 'xxxxxx', '2019-03-20 16:15:25');
