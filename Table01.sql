/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云-深圳
 Source Server Type    : MySQL
 Source Server Version : 50557
 Source Host           : 不告诉你:3306
 Source Schema         : R1_DB

 Target Server Type    : MySQL
 Target Server Version : 50557
 File Encoding         : 65001

 Date: 13/04/2019 17:22:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Table01
-- ----------------------------
DROP TABLE IF EXISTS `Table01`;
CREATE TABLE `Table01` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `question` text COLLATE utf8mb4_bin NOT NULL COMMENT '问题答案',
  `a` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'a答案',
  `b` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'b答案',
  `c` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'c答案',
  `d` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'd答案',
  `ta` tinyint(4) NOT NULL COMMENT '正确答案第几个',
  `imageurl` text COLLATE utf8mb4_bin COMMENT '资源图片url',
  `bestanswer` text COLLATE utf8mb4_bin NOT NULL COMMENT '答案详解',
  `bestanswerid` varchar(85) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '不知道什么东西',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `sinaimg` varchar(85) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
