/*
Navicat MySQL Data Transfer

Source Server         : US_x64_1
Source Server Version : 50505
Source Host           : 192.168.6.129:3306
Source Database       : ssmbase

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-12-15 11:01:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssmbase_person
-- ----------------------------
DROP TABLE IF EXISTS `ssmbase_person`;
CREATE TABLE `ssmbase_person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` char(20) DEFAULT NULL COMMENT '姓名',
  `gender` int(1) DEFAULT NULL COMMENT '性别，1-男，0-女',
  `person_addr` varchar(80) DEFAULT NULL COMMENT '地址',
  `birthday` date DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssmbase_person
-- ----------------------------
INSERT INTO `ssmbase_person` VALUES ('1', '刘德财', '1', '重庆市', '1993-10-01');
INSERT INTO `ssmbase_person` VALUES ('2', '唐琴琴', '0', '重庆市', '1995-10-01');
INSERT INTO `ssmbase_person` VALUES ('3', '刘德华', '1', '中国香港', '1961-09-27');
INSERT INTO `ssmbase_person` VALUES ('4', '邓丽君', '0', '中国台湾', '1953-01-29');
