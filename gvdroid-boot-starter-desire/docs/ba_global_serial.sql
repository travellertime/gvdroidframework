/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2020-12-29 21:43:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ba_global_serial`
-- ----------------------------
DROP TABLE IF EXISTS `ba_global_serial`;
CREATE TABLE `ba_global_serial` (
  `id` bigint(20) NOT NULL,
  `sequenceKey` varchar(32) NOT NULL,
  `sequenceValue` int(11) NOT NULL,
  `sequenceDate` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `in_ba_global_serial_1` (`sequenceKey`,`sequenceDate`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ba_global_serial
-- ----------------------------
INSERT INTO `ba_global_serial` VALUES ('2', '1', '5', '20201111');
