/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : hrms

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 27/12/2022 22:10:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `leader_id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modn_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '总部', 0, 1, '启用', '2022-12-06 13:00:00');
INSERT INTO `department` VALUES (2, '人事部', 1, 1, '启用', '2022-12-13 18:25:42');
INSERT INTO `department` VALUES (4, '技术部', 1, 1, '启用', '2022-12-27 14:45:36');
INSERT INTO `department` VALUES (10, '开发部', 4, 1, '启用', '2022-12-13 18:30:59');
INSERT INTO `department` VALUES (20, '开发小组', 10, 1, '启用', '2022-12-14 18:28:44');
INSERT INTO `department` VALUES (21, '前端开发小组', 20, 1, '启用', '2022-12-27 11:43:39');
INSERT INTO `department` VALUES (22, '后端开发小组', 20, 1, '启用', '2022-12-14 18:29:46');
INSERT INTO `department` VALUES (23, 'H5开发小组', 21, 1, '启用', '2022-12-14 18:29:58');
INSERT INTO `department` VALUES (24, 'Java开发小组', 22, 1, '启用', '2022-12-14 18:30:15');
INSERT INTO `department` VALUES (25, 'Java环境搭建小组', 24, 1, '启用', '2022-12-18 20:07:44');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '吴东', '001', 1, '13145201314', '男', '13145201314@wd.com');
INSERT INTO `employee` VALUES (2, '云汐', '002', 1, '13145202020', '女', '13145202020@yx.com');
INSERT INTO `employee` VALUES (3, '老王', '007', 2, '15538996231', '男', '13145201314@lw.com');
INSERT INTO `employee` VALUES (4, '老李', '006', 1, '13145201314', '男', '1@ll.com');
INSERT INTO `employee` VALUES (15, '玩玩', '66', 1, '13445656741', '男', '22@qq.cn');

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_role
-- ----------------------------
INSERT INTO `employee_role` VALUES (1, 1, 1);
INSERT INTO `employee_role` VALUES (2, 3, 11);
INSERT INTO `employee_role` VALUES (3, 5, 12);
INSERT INTO `employee_role` VALUES (98, 15, 17);
INSERT INTO `employee_role` VALUES (99, 15, 22);
INSERT INTO `employee_role` VALUES (100, 15, 21);
INSERT INTO `employee_role` VALUES (101, 15, 18);
INSERT INTO `employee_role` VALUES (102, 15, 20);

-- ----------------------------
-- Table structure for payroll
-- ----------------------------
DROP TABLE IF EXISTS `payroll`;
CREATE TABLE `payroll`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `expiration_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payroll
-- ----------------------------
INSERT INTO `payroll` VALUES (1, '2022-11薪资', '2022-12-01', '2022-12-08');
INSERT INTO `payroll` VALUES (2, '2022-10薪资', '2022-11-01', '2022-11-08');
INSERT INTO `payroll` VALUES (3, '2022-09薪资', '2022-10-01', '2022-10-08');
INSERT INTO `payroll` VALUES (4, '2022-08薪资', '2022-09-01', '2022-09-08');
INSERT INTO `payroll` VALUES (5, '2022-07薪资', '2022-08-01', '2022-08-08');
INSERT INTO `payroll` VALUES (6, '2022-06薪资', '2022-07-01', '2022-07-08');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '查看员工信息', 'employee:select');
INSERT INTO `permission` VALUES (2, '新增员工信息', 'employee:insert');
INSERT INTO `permission` VALUES (3, '编辑员工信息', 'employee:edit');
INSERT INTO `permission` VALUES (4, '删除员工信息', 'employee:delete');
INSERT INTO `permission` VALUES (5, '给员工分配角色', 'employee:allotRole');
INSERT INTO `permission` VALUES (6, '查看部门信息', 'department:select');
INSERT INTO `permission` VALUES (7, '新增部门信息', 'department:insert');
INSERT INTO `permission` VALUES (8, '编辑部门信息', 'department:edit');
INSERT INTO `permission` VALUES (9, '删除部门信息', 'department:delete');
INSERT INTO `permission` VALUES (10, '查看角色信息', 'role:select');
INSERT INTO `permission` VALUES (11, '新增角色信息', 'role:insert');
INSERT INTO `permission` VALUES (12, '编辑角色信息', 'role:edit');
INSERT INTO `permission` VALUES (13, '删除角色信息', 'role:delete');
INSERT INTO `permission` VALUES (14, '给角色分配权限', 'role:allotPermission');
INSERT INTO `permission` VALUES (15, '查看权限信息', 'permission:select');
INSERT INTO `permission` VALUES (16, '查看薪资记录信息', 'salaryReport:select');
INSERT INTO `permission` VALUES (17, '新增薪资记录信息', 'salaryReport:insert');
INSERT INTO `permission` VALUES (18, '编辑薪资记录信息', 'salaryReport:edit');
INSERT INTO `permission` VALUES (19, '删除薪资记录信息', 'salaryReport:delete');
INSERT INTO `permission` VALUES (20, '查看薪资项目信息', 'payroll:select');
INSERT INTO `permission` VALUES (21, '新增薪资项目信息', 'payroll:insert');
INSERT INTO `permission` VALUES (22, '编辑薪资项目信息', 'payroll:edit');
INSERT INTO `permission` VALUES (23, '删除薪资项目信息', 'payroll:delete');
INSERT INTO `permission` VALUES (24, '查看薪资项目的薪资报表信息', 'payroll:selectByPayrollId');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '拥有最高权限');
INSERT INTO `role` VALUES (11, '部门管理员', '拥有部门管理权限');
INSERT INTO `role` VALUES (12, '员工管理员', '拥有员工管理权限');
INSERT INTO `role` VALUES (17, '普通员工', '拥有查看所有信息权限');
INSERT INTO `role` VALUES (18, '新增管理员', '拥有新增权限');
INSERT INTO `role` VALUES (19, '编辑管理员', '拥有编辑权限');
INSERT INTO `role` VALUES (20, '删除管理员', '拥有删除权限');
INSERT INTO `role` VALUES (21, '分配角色管理员', '拥有分配角色的权限');
INSERT INTO `role` VALUES (22, '分配权限管理员', '拥有分配权限的权限');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `permission_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (71, 12, 1);
INSERT INTO `role_permission` VALUES (72, 12, 2);
INSERT INTO `role_permission` VALUES (73, 12, 3);
INSERT INTO `role_permission` VALUES (74, 12, 4);
INSERT INTO `role_permission` VALUES (75, 12, 5);
INSERT INTO `role_permission` VALUES (76, 17, 1);
INSERT INTO `role_permission` VALUES (77, 17, 6);
INSERT INTO `role_permission` VALUES (78, 17, 10);
INSERT INTO `role_permission` VALUES (79, 17, 15);
INSERT INTO `role_permission` VALUES (80, 17, 16);
INSERT INTO `role_permission` VALUES (81, 17, 20);
INSERT INTO `role_permission` VALUES (82, 17, 24);
INSERT INTO `role_permission` VALUES (83, 18, 2);
INSERT INTO `role_permission` VALUES (84, 18, 7);
INSERT INTO `role_permission` VALUES (85, 18, 11);
INSERT INTO `role_permission` VALUES (86, 18, 17);
INSERT INTO `role_permission` VALUES (87, 18, 21);
INSERT INTO `role_permission` VALUES (88, 19, 3);
INSERT INTO `role_permission` VALUES (89, 19, 8);
INSERT INTO `role_permission` VALUES (90, 19, 12);
INSERT INTO `role_permission` VALUES (91, 19, 18);
INSERT INTO `role_permission` VALUES (92, 19, 22);
INSERT INTO `role_permission` VALUES (93, 20, 4);
INSERT INTO `role_permission` VALUES (94, 20, 9);
INSERT INTO `role_permission` VALUES (95, 20, 13);
INSERT INTO `role_permission` VALUES (96, 20, 19);
INSERT INTO `role_permission` VALUES (97, 20, 23);
INSERT INTO `role_permission` VALUES (98, 11, 7);
INSERT INTO `role_permission` VALUES (99, 11, 6);
INSERT INTO `role_permission` VALUES (100, 11, 8);
INSERT INTO `role_permission` VALUES (101, 11, 9);
INSERT INTO `role_permission` VALUES (104, 22, 14);
INSERT INTO `role_permission` VALUES (105, 21, 5);
INSERT INTO `role_permission` VALUES (106, 1, 1);
INSERT INTO `role_permission` VALUES (107, 1, 2);
INSERT INTO `role_permission` VALUES (108, 1, 3);
INSERT INTO `role_permission` VALUES (109, 1, 4);
INSERT INTO `role_permission` VALUES (110, 1, 5);
INSERT INTO `role_permission` VALUES (111, 1, 6);
INSERT INTO `role_permission` VALUES (112, 1, 7);
INSERT INTO `role_permission` VALUES (113, 1, 8);
INSERT INTO `role_permission` VALUES (114, 1, 9);
INSERT INTO `role_permission` VALUES (115, 1, 12);
INSERT INTO `role_permission` VALUES (116, 1, 11);
INSERT INTO `role_permission` VALUES (117, 1, 10);
INSERT INTO `role_permission` VALUES (118, 1, 13);
INSERT INTO `role_permission` VALUES (119, 1, 16);
INSERT INTO `role_permission` VALUES (120, 1, 19);
INSERT INTO `role_permission` VALUES (121, 1, 22);
INSERT INTO `role_permission` VALUES (122, 1, 23);
INSERT INTO `role_permission` VALUES (123, 1, 20);
INSERT INTO `role_permission` VALUES (124, 1, 17);
INSERT INTO `role_permission` VALUES (125, 1, 14);
INSERT INTO `role_permission` VALUES (126, 1, 24);
INSERT INTO `role_permission` VALUES (127, 1, 21);
INSERT INTO `role_permission` VALUES (128, 1, 18);
INSERT INTO `role_permission` VALUES (129, 1, 15);

-- ----------------------------
-- Table structure for salary_report
-- ----------------------------
DROP TABLE IF EXISTS `salary_report`;
CREATE TABLE `salary_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NULL DEFAULT NULL,
  `payroll_id` int(11) NULL DEFAULT NULL,
  `basic_wage` double(11, 0) NULL DEFAULT NULL,
  `overtime_premium` double(11, 0) NULL DEFAULT NULL,
  `other_bonuses` double(11, 0) NULL DEFAULT NULL,
  `other_subsidies` double(11, 0) NULL DEFAULT NULL,
  `other_additions` double(11, 0) NULL DEFAULT NULL,
  `absenteeism_deductions` double(11, 0) NULL DEFAULT NULL,
  `sick_leave_deductions` double(11, 0) NULL DEFAULT NULL,
  `other_deductions` double(11, 0) NULL DEFAULT NULL,
  `endowment_insurance` double(11, 0) NULL DEFAULT NULL,
  `medical_insurance` double(11, 0) NULL DEFAULT NULL,
  `unemployment_insurance` double(11, 0) NULL DEFAULT NULL,
  `accumulation_fund` double(11, 0) NULL DEFAULT NULL,
  `individual_income_tax` double(11, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary_report
-- ----------------------------
INSERT INTO `salary_report` VALUES (1, 1, 1, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (2, 1, 2, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (3, 1, 3, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (4, 1, 4, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (5, 1, 5, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (6, 1, 6, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (7, 2, 1, 1000000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000);
INSERT INTO `salary_report` VALUES (9, 4, 1, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);
INSERT INTO `salary_report` VALUES (10, 4, 2, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);
INSERT INTO `salary_report` VALUES (12, 3, 4, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '13800000002', '123456', 1);
INSERT INTO `user` VALUES (2, '13800000000', '123456', 3);
INSERT INTO `user` VALUES (3, '13800000001', '123456', 4);
INSERT INTO `user` VALUES (5, '13800000005', '123456', 2);
INSERT INTO `user` VALUES (15, '13600000002', '123456', 15);

SET FOREIGN_KEY_CHECKS = 1;
