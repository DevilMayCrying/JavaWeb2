SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` varchar(255) NOT NULL,
  `module_name` varchar(255) NOT NULL,
  `page_url` varchar(255) DEFAULT NULL,
  `api_url` varchar(10000) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `fcode` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `module_type` int(11) DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `parent_alias` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_date` varchar(19) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `update_date` varchar(19) DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('20190408140043147', '系统管理', null, null, null, null, '1', '1', '1', 'xtgl', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408140336803', '用户管理', null, null, '20190408140043147', null, '2', '1', '1', 'yhgl', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408140517989', '角色管理', null, null, '20190408140043147', null, '2', '2', '1', 'jsgl', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408140608316', '模块管理', null, null, '20190408140043147', null, '2', '3', '1', 'mkgl', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141509095', '查询用户', null, '/web/pc/sys/user/list', '20190408140336803', null, '3', '1', '2', 'yhlb', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141522656', '新增用户', null, '/web/pc/sys/user/add', '20190408140336803', null, '3', '2', '2', 'xzyh', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141538196', '修改用户', null, '/web/pc/sys/user/modify,/web/pc/sys/user/detail', '20190408140336803', null, '3', '3', '2', 'xgyh', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141553730', '删除用户', null, '/web/pc/sys/user/delete', '20190408140336803', null, '3', '4', '2', 'scyh', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141702725', '用户详情', null, '/web/pc/sys/user/detail', '20190408140336803', null, '3', '5', '2', 'yhxq', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141702726', '用户角色信息', null, '/web/pc/sys/user/userRoleInfo', '20190408140336803', null, '3', '6', '2', 'yhjsxx', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141702727', '用户角色分配', null, '/web/pc/sys/user/userRoleAssignment,/web/pc/sys/user/userRoleInfo', '20190408140336803', null, '3', '7', '2', 'yhjsfp', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141702728', '用户模块信息', null, '/web/pc/sys/user/userModuleInfo', '20190408140336803', null, '3', '8', '2', 'yhmkxx', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141702729', '用户模块分配', null, '/web/pc/sys/user/userModuleAssignment,/web/pc/sys/user/userModuleInfo', '20190408140336803', null, '3', '9', '2', 'yhmkfp', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141815822', '新增角色', null, '/web/pc/sys/role/add', '20190408140517989', null, '3', '1', '2', 'xzjs', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141827174', '修改角色', null, '/web/pc/sys/role/modify,/web/pc/sys/role/detail', '20190408140517989', null, '3', '2', '2', 'xgjs', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141852659', '查询角色', null, '/web/pc/sys/role/list', '20190408140517989', null, '3', '3', '2', 'jslb', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141902486', '角色详情', null, '/web/pc/sys/role/detail', '20190408140517989', null, '3', '4', '2', 'jsxq', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408141916424', '删除角色', null, '/web/pc/sys/role/delete', '20190408140517989', null, '3', '5', '2', 'scjs', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142025602', '角色模块分配', null, '/web/pc/sys/role/roleModuleAssignment,/web/pc/sys/role/roleModuleInfo', '20190408140517989', null, '3', '6', '2', 'jsmkfp', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142025603', '角色模块信息', null, '/web/pc/sys/role/roleModuleInfo', '20190408140517989', null, '3', '7', '2', 'jsmkxx', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142112268', '查询模块', null, '/web/pc/sys/module/list', '20190408140608316', null, '3', '1', '2', 'mklb', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142122024', '模块详情', null, '/web/pc/sys/module/detail', '20190408140608316', null, '3', '2', '2', 'mkxq', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142132292', '新增模块', null, '/web/pc/sys/module/add', '20190408140608316', null, '3', '3', '2', 'xzmk', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142143289', '删除模块', null, '/web/pc/sys/module/delete', '20190408140608316', null, '3', '4', '2', 'scmk', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');
INSERT INTO `module` VALUES ('20190408142154821', '修改模块', null, '/web/pc/sys/module/modify,/web/pc/sys/module/detail', '20190408140608316', null, '3', '5', '2', 'xgmk', null, null, null, '1', '2018-02-08 17:02:21', 'admin123456', null, null, '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `fcode` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT '0',
  `type` int(11) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `create_date` varchar(19) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `update_date` varchar(19) DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_module`
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `module_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role_module
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `fcode` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `create_date` varchar(19) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `update_date` varchar(19) DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `del_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_module`
-- ----------------------------
DROP TABLE IF EXISTS `user_module`;
CREATE TABLE `user_module` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `module_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_module
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `strategy` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
