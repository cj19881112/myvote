/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-01-26 13:33:09
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
  PRIMARY KEY (`craft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_craft
-- ----------------------------
INSERT INTO `t_craft` VALUES ('4', '1', '1', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('5', '1', '1', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('6', '1', '1', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('7', '1', '2', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('8', '1', '2', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('9', '1', '2', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('10', '1', '3', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('11', '1', '3', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('12', '1', '3', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('13', '1', '4', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('14', '1', '4', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('15', '1', '4', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('16', '1', '5', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('17', '1', '5', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('18', '1', '5', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('19', '1', '6', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('20', '1', '6', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('21', '1', '6', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('22', '1', '7', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('23', '1', '7', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('24', '1', '7', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('25', '1', '8', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('26', '1', '8', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('27', '1', '8', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('28', '1', '9', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('29', '1', '9', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('30', '1', '9', '作品3', '/imgs/craft-avatar.jpg', '描述3');
INSERT INTO `t_craft` VALUES ('31', '1', '10', '作品1', '/imgs/craft-avatar.jpg', '描述1');
INSERT INTO `t_craft` VALUES ('32', '1', '10', '作品2', '/imgs/craft-avatar.jpg', '描述2');
INSERT INTO `t_craft` VALUES ('33', '1', '10', '作品3', '/imgs/craft-avatar.jpg', '描述3');

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
  PRIMARY KEY (`sense_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sense
-- ----------------------------
INSERT INTO `t_sense` VALUES ('2', '1', '年度最佳策略奖入围作品', '0', '1', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('3', '1', '年度最佳互动奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('4', '1', '年度最佳视觉奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('5', '1', '年度最佳文案奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('6', '1', '年度最佳平面奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('7', '1', '年度最佳新媒体奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('8', '1', '年度最佳客户奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('9', '1', '年度最佳企业文化建设奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');
INSERT INTO `t_sense` VALUES ('10', '1', '年度最佳新秀人物奖入围作品', '0', '0', '/imgs/sense-avatar.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vote
-- ----------------------------
