/*
Navicat MySQL Data Transfer

Source Server         : 10.x.x.x
Source Server Version : 50723
Source Host           : 10.x.x.x:3306
Source Database       : kbms

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
INSERT INTO `log_management` VALUES ('1925', 'admin', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@5b701bf7', '2019-03-20 16:15:25');
INSERT INTO `log_management` VALUES ('1927', 'ranxia_kbms', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@4deb932b', '2019-03-20 17:46:18');
INSERT INTO `log_management` VALUES ('1929', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@5d03df76', '2019-03-20 18:27:33');
INSERT INTO `log_management` VALUES ('1935', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@520eb9f8', '2019-03-20 18:33:40');
INSERT INTO `log_management` VALUES ('1941', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@255482cb', '2019-03-20 18:44:48');
INSERT INTO `log_management` VALUES ('1947', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@1d1da00b', '2019-03-20 18:52:21');
INSERT INTO `log_management` VALUES ('1953', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@c194c4e', '2019-03-21 09:18:45');
INSERT INTO `log_management` VALUES ('1959', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@40625ac6', '2019-03-21 09:38:14');
INSERT INTO `log_management` VALUES ('1965', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@fd5c7f6', '2019-03-21 10:21:08');
INSERT INTO `log_management` VALUES ('1971', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@3305897c', '2019-03-21 10:33:59');
INSERT INTO `log_management` VALUES ('1977', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@121c1a08', '2019-03-21 12:46:00');
INSERT INTO `log_management` VALUES ('1983', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@3a678e40', '2019-03-21 13:44:29');
INSERT INTO `log_management` VALUES ('1985', 'ranxia_kbms', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@4c4bbab4', '2019-03-21 14:07:54');
INSERT INTO `log_management` VALUES ('1987', 'admin', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@21a34f68', '2019-03-22 10:44:22');
INSERT INTO `log_management` VALUES ('1989', 'admin', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@63c1f5d4', '2019-03-22 10:53:28');
INSERT INTO `log_management` VALUES ('1991', 'admin', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@5355d5ee', '2019-03-22 15:42:01');
INSERT INTO `log_management` VALUES ('1997', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@53945f9c', '2019-03-22 15:53:48');
INSERT INTO `log_management` VALUES ('2003', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@12d8e6b6', '2019-03-22 16:30:18');
INSERT INTO `log_management` VALUES ('2009', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@79e28671', '2019-03-22 17:13:31');
INSERT INTO `log_management` VALUES ('2015', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@e5864c2', '2019-03-25 09:50:22');
INSERT INTO `log_management` VALUES ('2021', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@2b19b346', '2019-03-25 10:01:54');
INSERT INTO `log_management` VALUES ('2027', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@5d4a34ff', '2019-03-25 10:09:58');
INSERT INTO `log_management` VALUES ('2033', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@6296e4bf', '2019-03-25 10:14:44');
INSERT INTO `log_management` VALUES ('2039', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@6d911985', '2019-03-25 10:23:35');
INSERT INTO `log_management` VALUES ('2045', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@411576c7', '2019-03-25 11:48:37');
INSERT INTO `log_management` VALUES ('2051', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@21abd3a3', '2019-03-25 12:40:52');
INSERT INTO `log_management` VALUES ('2057', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@435e224d', '2019-03-25 13:46:53');
INSERT INTO `log_management` VALUES ('2063', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@80b70fd', '2019-03-25 19:38:03');
INSERT INTO `log_management` VALUES ('2069', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@1d1da00b', '2019-03-26 09:06:31');
INSERT INTO `log_management` VALUES ('2075', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@7dc9b41a', '2019-03-26 09:25:13');
INSERT INTO `log_management` VALUES ('2081', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@29280ca6', '2019-03-26 09:52:31');
INSERT INTO `log_management` VALUES ('2083', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@6bed434d', '2019-03-26 10:53:03');
INSERT INTO `log_management` VALUES ('2089', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@5e1bfe66', '2019-03-26 11:34:45');
INSERT INTO `log_management` VALUES ('2091', 'admin', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@24310f07', '2019-03-26 15:37:26');
INSERT INTO `log_management` VALUES ('2097', '未登录', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@5cbaafbd', '2019-03-26 15:48:39');
INSERT INTO `log_management` VALUES ('2099', 'admin', 'create', '创建知识订阅策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeRSSStrategy@7907ab7a', '2019-04-01 14:56:36');
INSERT INTO `log_management` VALUES ('2101', 'admin', 'delete', '删除知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@35bbd907', '2019-04-01 15:07:54');
INSERT INTO `log_management` VALUES ('2103', 'admin', 'delete', '删除知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@77c02f25', '2019-04-01 15:07:57');
INSERT INTO `log_management` VALUES ('2105', 'admin', 'delete', '删除知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@556a07a2', '2019-04-01 15:07:58');
INSERT INTO `log_management` VALUES ('2107', 'admin', 'delete', '删除知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@31234dda', '2019-04-01 15:08:29');
INSERT INTO `log_management` VALUES ('2109', 'admin', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@18cf934e', '2019-04-01 15:08:46');
INSERT INTO `log_management` VALUES ('2111', 'admin', 'create', '创建知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@2fa727ea', '2019-04-01 15:12:12');
INSERT INTO `log_management` VALUES ('2113', 'admin', 'delete', '删除知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@37680530', '2019-04-01 15:12:30');
INSERT INTO `log_management` VALUES ('2115', 'admin', 'delete', '删除知识同步策略.策略详情:com.swad.bigdata.kbms.vo.KnowledgeSYNCStrategy@4aca909b', '2019-04-01 15:27:32');
