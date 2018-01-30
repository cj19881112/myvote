/*
Navicat MySQL Data Transfer

Source Server         : 120.24.210.216
Source Server Version : 50550
Source Host           : 120.24.210.216:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-01-30 23:17:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_craft
-- ----------------------------
DROP TABLE IF EXISTS `t_craft`;
CREATE TABLE `t_craft` (
  `craft_id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` int(11) DEFAULT NULL,
  `sense_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`craft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_craft
-- ----------------------------
INSERT INTO `t_craft` VALUES ('1', '1', '1', '前线大写-云上鼓岭', '/imgs/1.png', '', '1');
INSERT INTO `t_craft` VALUES ('2', '1', '1', '数理化-福州中铁城', '/imgs/2.png', '', '2');
INSERT INTO `t_craft` VALUES ('3', '1', '1', '数理化-铁建', '/imgs/3.png', '', '3');
INSERT INTO `t_craft` VALUES ('4', '1', '2', '第六事业部-百督府', '/imgs/4.png', '', '1');
INSERT INTO `t_craft` VALUES ('5', '1', '2', '数理化-泉州保利城', '/imgs/5.png', '', '2');
INSERT INTO `t_craft` VALUES ('6', '1', '2', '前线大写-乌山九巷', '/imgs/6.png', '', '3');
INSERT INTO `t_craft` VALUES ('7', '1', '3', '创意二部-群升广场', '/imgs/7.png', '', '1');
INSERT INTO `t_craft` VALUES ('8', '1', '3', '前线大写-吕琛组-云上鼓岭', '/imgs/8.png', '', '2');
INSERT INTO `t_craft` VALUES ('9', '1', '3', '前线数理化-灿燕组-中铁城', '/imgs/9.png', '', '3');
INSERT INTO `t_craft` VALUES ('10', '1', '4', '品牌事业部-百督府', '/imgs/10.png', '', '1');
INSERT INTO `t_craft` VALUES ('11', '1', '4', '前线大写-乌山九巷', '/imgs/11.png', '', '2');
INSERT INTO `t_craft` VALUES ('12', '1', '4', '第六事业部-融信有墅', '/imgs/12.png', '', '3');
INSERT INTO `t_craft` VALUES ('13', '1', '5', '数理化-直属组-三仟栋', '/imgs/13.png', '', '1');
INSERT INTO `t_craft` VALUES ('14', '1', '5', '第六事业部-百督府', '/imgs/14.png', '', '2');
INSERT INTO `t_craft` VALUES ('15', '1', '5', '品牌事业部-武夷声声慢', '/imgs/15.png', '', '3');
INSERT INTO `t_craft` VALUES ('16', '1', '6', '数理化-文通组-利通188', '/imgs/16.png', '', '1');
INSERT INTO `t_craft` VALUES ('17', '1', '6', '前线大写-正荣悦湖湾', '/imgs/17.png', '', '2');
INSERT INTO `t_craft` VALUES ('18', '1', '6', '第六事业部-融侨观湖', '/imgs/18.png', '', '3');
INSERT INTO `t_craft` VALUES ('19', '1', '7', '数理化-泉州保利城', '/imgs/19.png', '', '1');
INSERT INTO `t_craft` VALUES ('20', '1', '7', '创意二部-香山小镇', '/imgs/20.png', '', '2');
INSERT INTO `t_craft` VALUES ('21', '1', '7', '前线大写-上江界', '/imgs/21.png', '', '3');
INSERT INTO `t_craft` VALUES ('22', '1', '8', '江帅军', '/imgs/22.jpg', '', '1');
INSERT INTO `t_craft` VALUES ('23', '1', '8', '刘可鑫', '/imgs/23.jpg', '', '2');
INSERT INTO `t_craft` VALUES ('24', '1', '8', '林尧', '/imgs/24.jpg', '', '3');

-- ----------------------------
-- Table structure for t_sense
-- ----------------------------
DROP TABLE IF EXISTS `t_sense`;
CREATE TABLE `t_sense` (
  `sense_id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` int(11) DEFAULT NULL,
  `sense_name` varchar(255) DEFAULT NULL,
  `voting` char(1) DEFAULT NULL,
  `is_current` char(1) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `stop_time` datetime DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`sense_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sense
-- ----------------------------
INSERT INTO `t_sense` VALUES ('1', '1', '年度最佳策略奖', '0', '1', '/imgs/sense-avatar.jpg', null, null, '1');
INSERT INTO `t_sense` VALUES ('2', '1', '年度最佳互动奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '2');
INSERT INTO `t_sense` VALUES ('3', '1', '年度最佳视觉奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '3');
INSERT INTO `t_sense` VALUES ('4', '1', '年度最佳文案奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '4');
INSERT INTO `t_sense` VALUES ('5', '1', '年度最佳平面奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '5');
INSERT INTO `t_sense` VALUES ('6', '1', '年度最佳新媒体奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '6');
INSERT INTO `t_sense` VALUES ('7', '1', '年度最佳客户奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '7');
INSERT INTO `t_sense` VALUES ('8', '1', '年度最佳新秀人物奖', '0', '0', '/imgs/sense-avatar.jpg', null, null, '8');

-- ----------------------------
-- Table structure for t_show
-- ----------------------------
DROP TABLE IF EXISTS `t_show`;
CREATE TABLE `t_show` (
  `vote_id` int(11) NOT NULL DEFAULT '0',
  `current_sence` int(11) DEFAULT NULL,
  `vote_name` longtext,
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_show
-- ----------------------------
INSERT INTO `t_show` VALUES ('1', '1', '默认投票');

-- ----------------------------
-- Table structure for t_vote
-- ----------------------------
DROP TABLE IF EXISTS `t_vote`;
CREATE TABLE `t_vote` (
  `user_vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `sense_id` int(11) DEFAULT NULL,
  `craft_id` int(11) DEFAULT NULL,
  `user_id` varchar(256) NOT NULL,
  `vote_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_vote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vote
-- ----------------------------
