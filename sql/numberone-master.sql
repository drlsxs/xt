/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : numberone-master

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2020-07-28 21:48:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dk_customer
-- ----------------------------
DROP TABLE IF EXISTS `dk_customer`;
CREATE TABLE `dk_customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `status` char(1) DEFAULT '' COMMENT '客户状态',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `qualification` char(1) DEFAULT NULL COMMENT '学历',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `marriage` char(1) DEFAULT NULL COMMENT '婚姻状态',
  `address` varchar(512) DEFAULT NULL COMMENT '家庭住址',
  `type` char(1) DEFAULT NULL COMMENT '客户类型',
  `level` char(1) DEFAULT NULL COMMENT '级别',
  `source` char(1) DEFAULT NULL COMMENT '来源',
  `manager_id` bigint(20) DEFAULT NULL COMMENT '客户经理ID',
  `manager_name` varchar(255) DEFAULT NULL COMMENT '客户经理姓名',
  `hwy_id` bigint(20) DEFAULT NULL COMMENT '话务员ID',
  `hwy_name` varchar(255) DEFAULT NULL COMMENT '话务员姓名',
  `money_require` double(8,0) DEFAULT NULL COMMENT '资金需求',
  `money_use` varchar(512) DEFAULT NULL COMMENT '资金用途',
  `next_follow_date` datetime DEFAULT NULL COMMENT '下次跟进时间',
  `status2` char(1) DEFAULT NULL COMMENT '客户状态2',
  `fc` mediumtext COMMENT '房产',
  `car` mediumtext COMMENT '车辆',
  `bx` mediumtext COMMENT '保险',
  `credit_card` mediumtext COMMENT '信用卡',
  `fz` mediumtext COMMENT '负债',
  `contact` mediumtext,
  `follow` mediumtext COMMENT '跟进',
  `contract` mediumtext COMMENT '签约',
  `sk` mediumtext COMMENT '收款',
  `follow_time` datetime DEFAULT NULL COMMENT '跟进时间',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of dk_customer
-- ----------------------------
INSERT INTO `dk_customer` VALUES ('7', '张三', '15029613854', '', '0', '', '测试销售2', '2019-06-08 18:08:12', '105', '2019-06-09 23:53:30', '', '61011198901184019', '2019-06-08 00:00:00', '0', '陕西省', '西安市', '1', '陕西省西安市灞桥区毛西村', '6', '0', '0', '104', '测试销售', '104', '测试销售', null, null, '2019-06-09 00:00:00', '0', '房屋面积 76', null, '2年3次 缴费金额 5800', null, null, null, '贷款咨询', null, null, '2019-06-08 18:09:18', '108');
INSERT INTO `dk_customer` VALUES ('8', '李四', '1502963897', '', '0', '', '测试销售2', '2019-06-08 18:13:34', '105', '2019-06-10 00:15:27', '', '61374274712834783215', '2019-06-08 00:00:00', '0', '陕西省', '西安市', '0', null, '7', '0', '0', '105', '测试销售2', '105', '测试销售2', '50', '买房', '2019-06-13 00:00:00', '0', '有房', null, null, null, null, null, '客户咨询，明天确认是否办理', null, null, '2019-06-10 00:15:28', '108');
INSERT INTO `dk_customer` VALUES ('9', '测试导入', '1111111111', '', '0', '', '测试销售', '2019-06-09 23:22:51', '104', '2019-06-09 23:44:07', '房贷,车贷', null, null, null, null, null, null, null, '5', null, null, null, null, null, null, '111', null, null, null, null, null, null, null, null, null, '有需求', null, null, '2019-06-09 23:44:08', '103');
INSERT INTO `dk_customer` VALUES ('10', '丁伞', '16029714875', '', '0', '', '测试销售', '2019-06-09 23:41:41', '104', null, '有房：按揭房  有车按揭车', null, null, null, null, null, null, null, '5', null, null, null, null, null, null, '50', null, null, null, null, null, null, null, null, null, null, null, null, null, '103');
INSERT INTO `dk_customer` VALUES ('11', '陈思明', '17098745624', '', '0', '', '测试销售', '2019-06-09 23:41:41', '104', '2020-07-28 19:52:06', '客服', null, null, null, null, null, null, null, '6', null, null, null, null, null, null, '60', null, null, null, null, null, null, null, null, null, null, null, null, null, '103');
INSERT INTO `dk_customer` VALUES ('12', '建国', '18868831595', '', '0', '', 'admin', '2020-07-28 20:36:12', '1', null, '45345', '170305199405085313', '2020-07-28 00:00:00', '1', '北京市', '北京市市辖区', '0', '大武大无', '0', '0', '0', '2', 'NumberOne', '1', 'NumberOne', '45', '3534534', '2020-07-01 00:00:00', '0', null, null, null, null, null, null, null, null, null, null, '103');

-- ----------------------------
-- Table structure for dk_order
-- ----------------------------
DROP TABLE IF EXISTS `dk_order`;
CREATE TABLE `dk_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别',
  `status` char(1) DEFAULT '' COMMENT '状态',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `age` varchar(10) DEFAULT NULL COMMENT '年龄',
  `sign_time` datetime DEFAULT NULL COMMENT '签约时间',
  `manager_id` bigint(20) DEFAULT NULL COMMENT '客服经理ID',
  `manager_name` varchar(255) DEFAULT NULL COMMENT '客服经理姓名',
  `dk_type` char(1) DEFAULT NULL COMMENT '贷款方式',
  `hk_type` char(1) DEFAULT NULL COMMENT '还款方式',
  `apply_money` double(8,0) DEFAULT NULL COMMENT '申请金额',
  `period` int(7) DEFAULT NULL COMMENT '还款期数',
  `service_money` double(8,0) DEFAULT NULL COMMENT '信息服务费',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `manager_dept_id` bigint(20) DEFAULT NULL COMMENT '客服经理部门ID',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of dk_order
-- ----------------------------
INSERT INTO `dk_order` VALUES ('1', '李四', '1502963897', '0', '0', 'admin', '2020-07-28 20:36:48', '1', null, '45345', '61374274712834783215', '2019-06-08 00:00:00', null, '2020-06-30 00:00:00', null, null, '1', '1', '45', '45', '534', '8', '103', null);

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES ('2', 'test', '大范围', 'Test', 'crud', 'com.numberone.project.system', 'system', 'test', '大范围', 'numberone', null, 'admin', '2020-04-25 10:47:10', '', null, null);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES ('2', '2', 'id', 'ID', 'int(10)', 'Integer', 'id', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', 'admin', '2020-04-25 10:47:10', '', null);
INSERT INTO `gen_table_column` VALUES ('3', '2', 'name', '名称', 'varchar(255)', 'String', 'name', '0', '0', null, '1', '1', '1', '1', 'LIKE', 'input', '', '2', 'admin', '2020-04-25 10:47:10', '', null);

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', null, 'com.numberone.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372002C636F6D2E6E756D6265726F6E652E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002D636F6D2E6E756D6265726F6E652E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3130202A202A202A202A203F74001172795461736B2E72794E6F506172616D7374000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC8974000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', null, 'com.numberone.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372002C636F6D2E6E756D6265726F6E652E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002D636F6D2E6E756D6265726F6E652E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3135202A202A202A202A203F74001572795461736B2E7279506172616D7328277279272974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000002740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC8974000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', null, 'com.numberone.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372002C636F6D2E6E756D6265726F6E652E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002D636F6D2E6E756D6265726F6E652E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3230202A202A202A202A203F74003872795461736B2E72794D756C7469706C65506172616D7328277279272C20747275652C20323030304C2C203331362E3530442C203130302974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000003740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E5A49AE58F82EFBC8974000133740001317800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RuoyiScheduler', 'DESKTOP-GB9H6Q41595944009480', '1595944102179', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', null, '1595944010000', '-1', '5', 'PAUSED', 'CRON', '1595944009000', '0', null, '2', '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', null, '1595944020000', '-1', '5', 'PAUSED', 'CRON', '1595944009000', '0', null, '2', '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', 'TASK_CLASS_NAME3', 'DEFAULT', null, '1595944020000', '-1', '5', 'PAUSED', 'CRON', '1595944009000', '0', null, '2', '');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `sys_config` VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', 'NumberOne科技', '0', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', 'NumberOne', '15888888888', '2689766486@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '性别男');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '性别女');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '性别未知');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '显示菜单');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '默认分组');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '系统分组');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '系统默认是');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '系统默认否');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '通知');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '公告');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '关闭状态');
INSERT INTO `sys_dict_data` VALUES ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '修改操作');
INSERT INTO `sys_dict_data` VALUES ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '删除操作');
INSERT INTO `sys_dict_data` VALUES ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '授权操作');
INSERT INTO `sys_dict_data` VALUES ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '导出操作');
INSERT INTO `sys_dict_data` VALUES ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '导入操作');
INSERT INTO `sys_dict_data` VALUES ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '强退操作');
INSERT INTO `sys_dict_data` VALUES ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '生成操作');
INSERT INTO `sys_dict_data` VALUES ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '清空操作');
INSERT INTO `sys_dict_data` VALUES ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2019-06-05 18:02:28', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('100', '0', '高中以内', '0', 'qualification', '', 'default', 'Y', '0', 'admin', '2019-06-05 17:59:50', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('101', '1', '大专', '1', 'qualification', '', '', 'Y', '0', 'admin', '2019-06-05 18:00:22', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('102', '2', '本科', '2', 'qualification', '', '', 'Y', '0', 'admin', '2019-06-05 18:00:33', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('103', '4', '硕士及以上', '4', 'qualification', '', '', 'Y', '0', 'admin', '2019-06-05 18:00:58', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('104', '3', '研究生', '3', 'qualification', '', '', 'Y', '0', 'admin', '2019-06-05 18:02:39', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('105', '0', '未婚', '0', 'marriage', '', '', 'Y', '0', 'admin', '2019-06-05 22:03:50', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('106', '1', '已婚', '1', 'marriage', '', '', 'Y', '0', 'admin', '2019-06-05 22:03:59', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('107', '2', '离异', '2', 'marriage', '', '', 'Y', '0', 'admin', '2019-06-05 22:04:08', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('108', '3', '再婚', '3', 'marriage', '', '', 'Y', '0', 'admin', '2019-06-05 22:04:24', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('109', '4', '丧偶', '4', 'marriage', '', '', 'Y', '0', 'admin', '2019-06-05 22:04:41', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('110', '0', '目标客户', '0', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:11:15', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('111', '1', '意向客户', '1', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:11:26', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('112', '2', '上门客户', '2', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:11:43', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('113', '3', '签单客户', '3', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:12:02', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('114', '4', '回款客户', '4', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:12:20', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('115', '5', '首播客户', '5', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:12:34', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('116', '6', '公海客户', '6', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-05 22:12:53', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('120', '0', 'A类', '0', 'customerLevel', '', '', 'Y', '0', 'admin', '2019-06-05 22:14:53', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('121', '1', 'B类', '1', 'customerLevel', '', '', 'Y', '0', 'admin', '2019-06-05 22:15:09', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('122', '2', 'C类', '2', 'customerLevel', '', '', 'Y', '0', 'admin', '2019-06-05 22:15:19', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('123', '3', 'D类', '3', 'customerLevel', '', '', 'Y', '0', 'admin', '2019-06-05 22:15:28', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('124', '0', '网络来源', '0', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:18:35', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('125', '1', '渠道来源', '1', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:18:46', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('126', '2', 'QQ聊天', '2', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:18:58', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('127', '3', '微信聊天', '3', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:19:09', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('128', '4', '易贷网', '4', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:19:18', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('129', '5', '公司分配', '5', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:19:35', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('130', '6', '数据导入', '6', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:19:46', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('131', '7', '朋友介绍', '7', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:20:00', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('132', '8', '推荐客户', '8', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:20:10', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('133', '9', '融360', '9', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:20:22', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('134', '10', '自主开发', '10', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:20:35', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('135', '11', '同行收单', '11', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:20:50', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('136', '12', '电销', '12', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:21:13', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('137', '13', '其它', '12', 'customerSource', '', '', 'Y', '0', 'admin', '2019-06-05 22:21:25', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('138', '0', '私客', '0', 'customerType2', '', '', 'Y', '0', 'admin', '2019-06-05 23:36:41', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('139', '1', '公客', '1', 'customerType2', '', '', 'Y', '0', 'admin', '2019-06-05 23:37:14', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('140', '0', '信贷', '0', 'dkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:31:14', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('141', '1', '抵押', '1', 'dkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:31:29', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('142', '2', '税贷', '2', 'dkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:31:41', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('143', '3', '其他', '3', 'dkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:31:53', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('144', '0', '等额本息', '0', 'hkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:32:50', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('145', '1', '先息后本', '1', 'hkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:33:01', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('146', '2', '等额本金', '2', 'hkType', '', '', 'Y', '0', 'admin', '2019-06-07 23:33:10', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('147', '0', '提交状态', '0', 'orderStatus', '', '', 'Y', '0', 'admin', '2019-06-08 00:03:43', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('148', '1', '确认放款', '1', 'orderStatus', '', '', 'Y', '0', 'admin', '2019-06-08 00:03:55', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('149', '2', '作废', '2', 'orderStatus', '', '', 'Y', '0', 'admin', '2019-06-08 00:04:09', 'admin', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('150', '3', '确认回款', '3', 'orderStatus', '', '', 'Y', '0', 'admin', '2019-06-08 11:09:32', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('151', '7', '放款客户', '7', 'customerType', '', '', 'Y', '0', 'admin', '2019-06-08 11:28:40', '', '2019-06-05 18:02:28', '');
INSERT INTO `sys_dict_data` VALUES ('152', '4', '已接单', '4', 'orderStatus', '', '', 'Y', '0', 'admin', '2019-06-08 11:36:49', '', '2019-06-05 18:02:28', '');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '任务分组列表');
INSERT INTO `sys_dict_type` VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES ('102', '客户类型', 'customerType', '0', 'admin', '2019-06-05 22:08:21', '', '2020-07-28 19:48:09', '');
INSERT INTO `sys_dict_type` VALUES ('103', '客户级别', 'customerLevel', '0', 'admin', '2019-06-05 22:14:28', '', '2020-07-28 19:48:12', '');
INSERT INTO `sys_dict_type` VALUES ('104', '客户来源', 'customerSource', '0', 'admin', '2019-06-05 22:17:58', '', '2020-07-28 19:48:14', '');
INSERT INTO `sys_dict_type` VALUES ('105', '客户状态', 'customerType2', '0', 'admin', '2019-06-05 23:35:37', '', '2020-07-28 19:48:17', '');
INSERT INTO `sys_dict_type` VALUES ('106', '贷款方式', 'dkType', '0', 'admin', '2019-06-07 23:30:46', '', '2020-07-28 19:48:21', '');
INSERT INTO `sys_dict_type` VALUES ('107', '还款方式', 'hkType', '0', 'admin', '2019-06-07 23:32:38', '', '2020-07-28 19:48:23', '');
INSERT INTO `sys_dict_type` VALUES ('108', '订单状态', 'orderStatus', '0', 'admin', '2019-06-08 00:03:27', '', '2020-07-28 19:48:26', '');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES ('2', '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES ('3', '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES ('100', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-12 19:32:58');
INSERT INTO `sys_logininfor` VALUES ('101', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-12 19:36:46');
INSERT INTO `sys_logininfor` VALUES ('102', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-12 19:50:17');
INSERT INTO `sys_logininfor` VALUES ('103', 'numberone', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-12 20:01:21');
INSERT INTO `sys_logininfor` VALUES ('104', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-14 14:26:27');
INSERT INTO `sys_logininfor` VALUES ('105', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-14 14:39:25');
INSERT INTO `sys_logininfor` VALUES ('106', 'numberone', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-14 14:39:37');
INSERT INTO `sys_logininfor` VALUES ('107', 'numberone', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-14 14:45:12');
INSERT INTO `sys_logininfor` VALUES ('108', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-14 14:45:17');
INSERT INTO `sys_logininfor` VALUES ('109', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-14 14:51:13');
INSERT INTO `sys_logininfor` VALUES ('110', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误1次', '2020-03-14 14:51:21');
INSERT INTO `sys_logininfor` VALUES ('111', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误2次', '2020-03-14 14:51:29');
INSERT INTO `sys_logininfor` VALUES ('112', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误3次', '2020-03-14 14:51:40');
INSERT INTO `sys_logininfor` VALUES ('113', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误4次', '2020-03-14 14:52:02');
INSERT INTO `sys_logininfor` VALUES ('114', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误5次', '2020-03-14 14:52:08');
INSERT INTO `sys_logininfor` VALUES ('115', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误5次，帐户锁定10分钟', '2020-03-14 14:54:31');
INSERT INTO `sys_logininfor` VALUES ('116', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-14 14:55:39');
INSERT INTO `sys_logininfor` VALUES ('117', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-14 14:59:19');
INSERT INTO `sys_logininfor` VALUES ('118', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误1次', '2020-04-25 10:40:52');
INSERT INTO `sys_logininfor` VALUES ('119', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误2次', '2020-04-25 10:41:04');
INSERT INTO `sys_logininfor` VALUES ('120', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2020-04-25 10:41:18');
INSERT INTO `sys_logininfor` VALUES ('121', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-04-25 10:41:21');
INSERT INTO `sys_logininfor` VALUES ('122', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误1次', '2020-07-27 22:26:30');
INSERT INTO `sys_logininfor` VALUES ('123', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误2次', '2020-07-27 22:26:38');
INSERT INTO `sys_logininfor` VALUES ('124', 'numberone', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-07-27 22:26:49');
INSERT INTO `sys_logininfor` VALUES ('125', 'numberone', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-07-27 22:27:18');
INSERT INTO `sys_logininfor` VALUES ('126', 'manager', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '用户不存在/密码错误', '2020-07-27 22:27:38');
INSERT INTO `sys_logininfor` VALUES ('127', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误3次', '2020-07-27 22:29:19');
INSERT INTO `sys_logininfor` VALUES ('128', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-07-27 22:29:55');
INSERT INTO `sys_logininfor` VALUES ('129', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-07-28 21:48:12');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2021 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', '#', '', 'M', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '3', '#', '', 'M', '0', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', '/system/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', '/system/role', '', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', '/system/menu', '', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', '/system/dept', '', 'C', '0', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', '/system/post', '', 'C', '0', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', '/system/dict', '', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', '/system/config', '', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', '/system/notice', '', 'C', '0', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', '#', '', 'M', '0', '', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', '/monitor/online', '', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', '/monitor/job', '', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', '/monitor/data', '', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '服务监控', '2', '3', '/monitor/server', '', 'C', '0', 'monitor:server:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES ('113', '表单构建', '3', '1', '/tool/build', '', 'C', '0', 'tool:build:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('114', '代码生成', '3', '2', '/tool/gen', '', 'C', '0', 'tool:gen:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('115', '系统接口', '3', '3', '/tool/swagger', '', 'C', '0', 'tool:swagger:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', '/monitor/operlog', '', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1006', '重置密码', '100', '7', '#', '', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1007', '角色查询', '101', '1', '#', '', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1008', '角色新增', '101', '2', '#', '', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1009', '角色修改', '101', '3', '#', '', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1010', '角色删除', '101', '4', '#', '', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1011', '角色导出', '101', '5', '#', '', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1016', '部门查询', '103', '1', '#', '', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1017', '部门新增', '103', '2', '#', '', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1018', '部门修改', '103', '3', '#', '', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1019', '部门删除', '103', '4', '#', '', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1020', '岗位查询', '104', '1', '#', '', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位新增', '104', '2', '#', '', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位修改', '104', '3', '#', '', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位删除', '104', '4', '#', '', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1024', '岗位导出', '104', '5', '#', '', 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1025', '字典查询', '105', '1', '#', '', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1026', '字典新增', '105', '2', '#', '', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1027', '字典修改', '105', '3', '#', '', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1028', '字典删除', '105', '4', '#', '', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1029', '字典导出', '105', '5', '#', '', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1030', '参数查询', '106', '1', '#', '', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1031', '参数新增', '106', '2', '#', '', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1032', '参数修改', '106', '3', '#', '', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1033', '参数删除', '106', '4', '#', '', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1034', '参数导出', '106', '5', '#', '', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1035', '公告查询', '107', '1', '#', '', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1036', '公告新增', '107', '2', '#', '', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1037', '公告修改', '107', '3', '#', '', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1038', '公告删除', '107', '4', '#', '', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1039', '操作查询', '500', '1', '#', '', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1040', '操作删除', '500', '2', '#', '', 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1041', '详细信息', '500', '3', '#', '', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1046', '账户解锁', '501', '4', '#', '', 'F', '0', 'monitor:logininfor:unlock', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1047', '在线查询', '109', '1', '#', '', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1048', '批量强退', '109', '2', '#', '', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1049', '单条强退', '109', '3', '#', '', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1050', '任务查询', '110', '1', '#', '', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1051', '任务新增', '110', '2', '#', '', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1052', '任务修改', '110', '3', '#', '', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1053', '任务删除', '110', '4', '#', '', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1054', '状态修改', '110', '5', '#', '', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1055', '任务详细', '110', '6', '#', '', 'F', '0', 'monitor:job:detail', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1056', '任务导出', '110', '7', '#', '', 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1057', '生成查询', '114', '1', '#', '', 'F', '0', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1058', '生成修改', '114', '2', '#', '', 'F', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1059', '生成删除', '114', '3', '#', '', 'F', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1060', '预览代码', '114', '4', '#', '', 'F', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1061', '生成代码', '114', '5', '#', '', 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('2000', '客户列表', '2020', '1', '/crm/customer', 'menuItem', 'C', '0', 'system:customer:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-07-28 21:42:04', '客户菜单');
INSERT INTO `sys_menu` VALUES ('2001', '客户查询', '2000', '1', '#', '', 'F', '0', 'system:customer:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2002', '客户新增', '2000', '2', '#', '', 'F', '0', 'system:customer:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2003', '客户修改', '2000', '3', '#', '', 'F', '0', 'system:customer:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2004', '客户删除', '2000', '4', '#', '', 'F', '0', 'system:customer:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2007', '订单列表', '2020', '1', '/crm/order', 'menuItem', 'C', '0', 'system:order:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-07-28 21:42:38', '订单菜单');
INSERT INTO `sys_menu` VALUES ('2008', '订单查询', '2007', '1', '#', '', 'F', '0', 'system:order:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2009', '订单新增', '2007', '2', '#', '', 'F', '0', 'system:order:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2010', '订单修改', '2007', '3', '#', '', 'F', '0', 'system:order:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2011', '订单删除', '2007', '4', '#', '', 'F', '0', 'system:order:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2013', '公海删除', '2000', '5', '#', 'menuItem', 'F', '0', 'system:customer:gh', '#', 'admin', '2019-06-08 14:54:32', '', '2020-07-27 22:33:43', '');
INSERT INTO `sys_menu` VALUES ('2014', '接单', '2007', '5', '#', 'menuItem', 'F', '0', 'system:order:accept', '#', 'admin', '2019-06-08 15:01:41', '', '2020-07-27 22:33:45', '');
INSERT INTO `sys_menu` VALUES ('2015', '确认放款收款', '2007', '6', '#', 'menuItem', 'F', '0', 'system:order:confirm', '#', 'admin', '2019-06-08 15:02:16', '', '2020-07-27 22:33:46', '');
INSERT INTO `sys_menu` VALUES ('2016', '作废', '2007', '7', '#', 'menuItem', 'F', '0', 'system:order:refuse', '#', 'admin', '2019-06-08 15:02:36', '', '2020-07-27 22:33:49', '');
INSERT INTO `sys_menu` VALUES ('2017', '签单', '2000', '6', '#', 'menuItem', 'F', '0', 'system:customer:order', '#', 'admin', '2019-06-09 19:24:39', '', '2020-07-27 22:33:51', '');
INSERT INTO `sys_menu` VALUES ('2018', '导入', '2000', '7', '#', 'menuItem', 'F', '0', 'system:customer:import', '#', 'admin', '2019-06-09 23:29:41', '', '2020-07-27 22:33:53', '');
INSERT INTO `sys_menu` VALUES ('2019', '迁移', '2000', '8', '#', 'menuItem', 'F', '0', 'system:customer:transfer', '#', 'admin', '2019-06-09 23:30:13', '', '2020-07-27 22:33:55', '');
INSERT INTO `sys_menu` VALUES ('2020', '贷款CRM', '0', '4', '#', 'menuItem', 'M', '0', null, 'fa fa-heart', 'admin', '2020-07-28 21:41:26', '', null, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '温馨提醒：2018-07-01 NumberOne新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES ('2', '维护通知：2018-07-01 NumberOne系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES ('100', '重置密码', '2', 'com.numberone.project.system.user.controller.UserController.resetPwd()', 'GET', '1', 'admin', '研发部门', '/system/user/resetPwd/2', '127.0.0.1', '内网IP', '{}', '\"system/user/resetPwd\"', '0', null, '2020-03-12 19:57:47');
INSERT INTO `sys_oper_log` VALUES ('101', '重置密码', '2', 'com.numberone.project.system.user.controller.UserController.resetPwdSave()', 'POST', '1', 'admin', '研发部门', '/system/user/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"2\"],\"loginName\":[\"numberone\"],\"password\":[\"admin123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-12 19:58:01');
INSERT INTO `sys_oper_log` VALUES ('102', '角色管理', '2', 'com.numberone.project.system.role.controller.RoleController.editSave()', 'POST', '1', 'admin', '研发部门', '/system/role/edit', '127.0.0.1', '内网IP', '{\"roleId\":[\"2\"],\"roleName\":[\"普通角色\"],\"roleKey\":[\"common\"],\"roleSort\":[\"2\"],\"status\":[\"0\"],\"remark\":[\"普通角色\"],\"menuIds\":[\"1,100,1000,1004,101,1007,102,1012,103,1016,104,1020,1024,105,1025,1029,106,1030,1034,107,1035,108,500,1039,1040,1041,1042,501,1043,1044,1045,1046,2,109,1047,1048,1049,110,1050,1055,1056,111,112,3,113,114,1057,1060,1061\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-14 14:39:20');
INSERT INTO `sys_oper_log` VALUES ('103', '重置密码', '2', 'com.numberone.project.system.user.controller.ProfileController.resetPwd()', 'POST', '1', 'numberone', '测试部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"2\"],\"loginName\":[\"numberone\"],\"oldPassword\":[\"admin123\"],\"newPassword\":[\"admin\"],\"confirm\":[\"admin\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-14 14:41:33');
INSERT INTO `sys_oper_log` VALUES ('104', '重置密码', '2', 'com.numberone.project.system.user.controller.ProfileController.resetPwd()', 'POST', '1', 'numberone', '测试部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"2\"],\"loginName\":[\"numberone\"],\"oldPassword\":[\"admin\"],\"newPassword\":[\"admin123\"],\"confirm\":[\"admin123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-14 14:43:08');
INSERT INTO `sys_oper_log` VALUES ('105', '重置密码', '2', 'com.numberone.project.system.user.controller.ProfileController.resetPwd()', 'POST', '1', 'admin', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"oldPassword\":[\"admin123\"],\"newPassword\":[\"admin\"],\"confirm\":[\"admin\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-14 14:45:34');
INSERT INTO `sys_oper_log` VALUES ('106', '重置密码', '2', 'com.numberone.project.system.user.controller.ProfileController.resetPwd()', 'POST', '1', 'admin', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"oldPassword\":[\"admin\"],\"newPassword\":[\"admin111\"],\"confirm\":[\"admin111\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-14 14:47:48');
INSERT INTO `sys_oper_log` VALUES ('107', '重置密码', '2', 'com.numberone.project.system.user.controller.UserController.resetPwd()', 'GET', '1', 'admin', '研发部门', '/system/user/resetPwd/1', '127.0.0.1', '内网IP', '{}', '\"system/user/resetPwd\"', '0', null, '2020-03-14 14:57:36');
INSERT INTO `sys_oper_log` VALUES ('108', '重置密码', '2', 'com.numberone.project.system.user.controller.UserController.resetPwd()', 'GET', '1', 'admin', '研发部门', '/system/user/resetPwd/1', '127.0.0.1', '内网IP', '{}', '\"system/user/resetPwd\"', '0', null, '2020-03-14 14:59:24');
INSERT INTO `sys_oper_log` VALUES ('109', '重置密码', '2', 'com.numberone.project.system.user.controller.UserController.resetPwdSave()', 'POST', '1', 'admin', '研发部门', '/system/user/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"password\":[\"deng88452387\"]}', 'null', '1', '不允许操作超级管理员用户', '2020-03-14 14:59:30');
INSERT INTO `sys_oper_log` VALUES ('110', '重置密码', '2', 'com.numberone.project.system.user.controller.ProfileController.resetPwd()', 'POST', '1', 'admin', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"oldPassword\":[\"admin123\"],\"newPassword\":[\"deng88452387\"],\"confirm\":[\"deng88452387\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-03-14 15:00:18');
INSERT INTO `sys_oper_log` VALUES ('111', '代码生成', '6', 'com.numberone.project.tool.gen.controller.GenController.importTableSave()', 'POST', '1', 'admin', '研发部门', '/tool/gen/importTable', '127.0.0.1', '内网IP', '{\"tables\":[\"test\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-04-25 10:43:01');
INSERT INTO `sys_oper_log` VALUES ('112', '代码生成', '3', 'com.numberone.project.tool.gen.controller.GenController.remove()', 'POST', '1', 'admin', '研发部门', '/tool/gen/remove', '127.0.0.1', '内网IP', '{\"ids\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-04-25 10:47:06');
INSERT INTO `sys_oper_log` VALUES ('113', '代码生成', '6', 'com.numberone.project.tool.gen.controller.GenController.importTableSave()', 'POST', '1', 'admin', '研发部门', '/tool/gen/importTable', '127.0.0.1', '内网IP', '{\"tables\":[\"test\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-04-25 10:47:10');
INSERT INTO `sys_oper_log` VALUES ('114', '菜单管理', '1', 'com.numberone.project.system.menu.controller.MenuController.addSave()', 'POST', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"贷款CRM\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"fa fa-star\"],\"visible\":[\"0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-27 22:31:36');
INSERT INTO `sys_oper_log` VALUES ('115', '客户', '1', 'com.numberone.project.crm.customer.controller.CustomerController.addSave()', 'POST', '1', 'admin', '研发部门', '/crm/customer/add', '127.0.0.1', '内网IP', '{\"name\":[\"建国\"],\"phone\":[\"18868831595\"],\"idCard\":[\"170305199405085313\"],\"sex\":[\"0\"],\"birthday\":[\"2020-07-28\"],\"qualification\":[\"1\"],\"province\":[\"北京市\"],\"city\":[\"北京市市辖区\"],\"address\":[\"大武大无\"],\"marriage\":[\"0\"],\"type\":[\"0\"],\"level\":[\"0\"],\"source\":[\"0\"],\"status2\":[\"0\"],\"managerId\":[\"2\"],\"managerName\":[\"NumberOne\"],\"hwyId\":[\"1\"],\"hwyName\":[\"NumberOne\"],\"moneyRequire\":[\"45\"],\"moneyUse\":[\"3534534\"],\"nextFollowDate\":[\"2020-07-01\"],\"remark\":[\"45345\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 20:36:12');
INSERT INTO `sys_oper_log` VALUES ('116', '订单', '1', 'com.numberone.project.crm.order.controller.OrderController.addSave()', 'POST', '1', 'admin', '研发部门', '/crm/order/add', '127.0.0.1', '内网IP', '{\"customerId\":[\"8\"],\"name\":[\"李四\"],\"signTime\":[\"2020-06-30\"],\"dkType\":[\"1\"],\"hkType\":[\"1\"],\"applyMoney\":[\"45\"],\"period\":[\"45\"],\"serviceMoney\":[\"534\"],\"remark\":[\"45345\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 20:36:48');
INSERT INTO `sys_oper_log` VALUES ('117', '菜单管理', '1', 'com.numberone.project.system.menu.controller.MenuController.addSave()', 'POST', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"贷款CRM\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"fa fa-heart\"],\"visible\":[\"0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:41:26');
INSERT INTO `sys_oper_log` VALUES ('118', '菜单管理', '2', 'com.numberone.project.system.menu.controller.MenuController.editSave()', 'POST', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2000\"],\"parentId\":[\"2020\"],\"menuType\":[\"C\"],\"menuName\":[\"客户列表\"],\"url\":[\"/crm/customer\"],\"target\":[\"menuItem\"],\"perms\":[\"system:customer:view\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:42:04');
INSERT INTO `sys_oper_log` VALUES ('119', '菜单管理', '2', 'com.numberone.project.system.menu.controller.MenuController.editSave()', 'POST', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2006\"],\"parentId\":[\"2005\"],\"menuType\":[\"C\"],\"menuName\":[\"我的客户\"],\"url\":[\"/crm/customer?isOwn=1\"],\"target\":[\"menuItem\"],\"perms\":[\"system:customer:view\"],\"orderNum\":[\"2\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:42:16');
INSERT INTO `sys_oper_log` VALUES ('120', '菜单管理', '2', 'com.numberone.project.system.menu.controller.MenuController.editSave()', 'POST', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2006\"],\"parentId\":[\"2020\"],\"menuType\":[\"C\"],\"menuName\":[\"我的客户\"],\"url\":[\"/crm/customer?isOwn=1\"],\"target\":[\"menuItem\"],\"perms\":[\"system:customer:view\"],\"orderNum\":[\"2\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:42:28');
INSERT INTO `sys_oper_log` VALUES ('121', '菜单管理', '2', 'com.numberone.project.system.menu.controller.MenuController.editSave()', 'POST', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2007\"],\"parentId\":[\"2020\"],\"menuType\":[\"C\"],\"menuName\":[\"订单列表\"],\"url\":[\"/crm/order\"],\"target\":[\"menuItem\"],\"perms\":[\"system:order:view\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:42:38');
INSERT INTO `sys_oper_log` VALUES ('122', '菜单管理', '3', 'com.numberone.project.system.menu.controller.MenuController.remove()', 'GET', '1', 'admin', '研发部门', '/system/menu/remove/2006', '127.0.0.1', '内网IP', '{}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:42:57');
INSERT INTO `sys_oper_log` VALUES ('123', '菜单管理', '3', 'com.numberone.project.system.menu.controller.MenuController.remove()', 'GET', '1', 'admin', '研发部门', '/system/menu/remove/2005', '127.0.0.1', '内网IP', '{}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:43:00');
INSERT INTO `sys_oper_log` VALUES ('124', '菜单管理', '3', 'com.numberone.project.system.menu.controller.MenuController.remove()', 'GET', '1', 'admin', '研发部门', '/system/menu/remove/2012', '127.0.0.1', '内网IP', '{}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:43:02');
INSERT INTO `sys_oper_log` VALUES ('125', '重置密码', '2', 'com.numberone.project.system.user.controller.ProfileController.resetPwd()', 'POST', '1', 'admin', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"oldPassword\":[\"deng88452387\"],\"newPassword\":[\"admin123\"],\"confirm\":[\"admin123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', '0', null, '2020-07-28 21:47:53');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'numberone', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-14 14:39:20', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('2', '100');
INSERT INTO `sys_role_dept` VALUES ('2', '101');
INSERT INTO `sys_role_dept` VALUES ('2', '105');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '100');
INSERT INTO `sys_role_menu` VALUES ('2', '101');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '105');
INSERT INTO `sys_role_menu` VALUES ('2', '106');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '108');
INSERT INTO `sys_role_menu` VALUES ('2', '109');
INSERT INTO `sys_role_menu` VALUES ('2', '110');
INSERT INTO `sys_role_menu` VALUES ('2', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '112');
INSERT INTO `sys_role_menu` VALUES ('2', '113');
INSERT INTO `sys_role_menu` VALUES ('2', '114');
INSERT INTO `sys_role_menu` VALUES ('2', '500');
INSERT INTO `sys_role_menu` VALUES ('2', '501');
INSERT INTO `sys_role_menu` VALUES ('2', '1000');
INSERT INTO `sys_role_menu` VALUES ('2', '1004');
INSERT INTO `sys_role_menu` VALUES ('2', '1007');
INSERT INTO `sys_role_menu` VALUES ('2', '1012');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1025');
INSERT INTO `sys_role_menu` VALUES ('2', '1029');
INSERT INTO `sys_role_menu` VALUES ('2', '1030');
INSERT INTO `sys_role_menu` VALUES ('2', '1034');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1039');
INSERT INTO `sys_role_menu` VALUES ('2', '1040');
INSERT INTO `sys_role_menu` VALUES ('2', '1041');
INSERT INTO `sys_role_menu` VALUES ('2', '1042');
INSERT INTO `sys_role_menu` VALUES ('2', '1043');
INSERT INTO `sys_role_menu` VALUES ('2', '1044');
INSERT INTO `sys_role_menu` VALUES ('2', '1045');
INSERT INTO `sys_role_menu` VALUES ('2', '1046');
INSERT INTO `sys_role_menu` VALUES ('2', '1047');
INSERT INTO `sys_role_menu` VALUES ('2', '1048');
INSERT INTO `sys_role_menu` VALUES ('2', '1049');
INSERT INTO `sys_role_menu` VALUES ('2', '1050');
INSERT INTO `sys_role_menu` VALUES ('2', '1055');
INSERT INTO `sys_role_menu` VALUES ('2', '1056');
INSERT INTO `sys_role_menu` VALUES ('2', '1057');
INSERT INTO `sys_role_menu` VALUES ('2', '1060');
INSERT INTO `sys_role_menu` VALUES ('2', '1061');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', 'NumberOne', '00', '2689766486@qq.com', '15888888888', '1', '', '04bdc63de4ac128607342f4d2684c0a5', 'eca7dd', '0', '0', '127.0.0.1', '2020-07-27 22:29:56', 'admin', '2018-03-16 11:33:00', 'numberone', '2020-07-28 21:47:53', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', 'numberone', 'NumberOne', '00', '2689766486@qq.com', '15666666666', '1', '', '2a1c81e614c95ad52df4e5ad1182b207', 'bbacd5', '0', '0', '127.0.0.1', '2020-07-27 22:26:50', 'admin', '2018-03-16 11:33:00', 'numberone', '2020-07-27 22:26:49', '测试员');

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------
INSERT INTO `sys_user_online` VALUES ('5de9af91-0b35-4f5a-a393-a5eef5f29da0', 'admin', '研发部门', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', 'on_line', '2020-07-28 21:40:39', '2020-07-28 21:43:00', '1800000');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(10) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大范围';

-- ----------------------------
-- Records of test
-- ----------------------------
