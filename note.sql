/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : note

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 20/06/2022 22:17:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_note_file
-- ----------------------------
DROP TABLE IF EXISTS `t_note_file`;
CREATE TABLE `t_note_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `folder_id` int(11) NOT NULL COMMENT '文件夹ID',
  `title` varchar(255) NOT NULL COMMENT '文件名称',
  `content` blob COMMENT '文件内容',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='笔记';

-- ----------------------------
-- Table structure for t_note_folder
-- ----------------------------
DROP TABLE IF EXISTS `t_note_folder`;
CREATE TABLE `t_note_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '文件夹名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件夹';

SET FOREIGN_KEY_CHECKS = 1;
