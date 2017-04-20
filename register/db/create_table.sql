

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_api_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_api_info`;
CREATE TABLE `t_api_info` (
`oid`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
`api_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'api的名字' ,
`api_id`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'api的唯一标识' ,
`api_version`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1.0.0' COMMENT 'api版本号' ,
`api_paras_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数名' ,
`api_req_method`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支持的请求方法,多个用英文逗号隔开' ,
`f_sys_info_id`  bigint(20) NOT NULL COMMENT '所属系统id' ,
`api_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求路径,即对应的spring mvc requestmapping的value值' ,
`created_at`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`updated_at`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`created_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`updated_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
`is_online`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否在线，1在线0下线' ,
`api_protocol`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'http' COMMENT '请求协议,http,https' ,
`resp_format`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '响应返回格式' ,
`resp_params`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '响应返回参数名，多个用逗号隔开，从外向内，从上至下逐个填写' ,
PRIMARY KEY (`oid`),
UNIQUE INDEX `api_id_version` (`api_id`, `api_version`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='api注册表'
AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `t_api_subscription`
-- ----------------------------
DROP TABLE IF EXISTS `t_api_subscription`;
CREATE TABLE `t_api_subscription` (
`oid`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
`f_app_subscription_id`  bigint(20) NOT NULL COMMENT 'app订阅系统id' ,
`f_api_info_id`  bigint(20) NOT NULL COMMENT '订阅的apiid' ,
`created_at`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`updated_at`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`created_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`updated_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
PRIMARY KEY (`oid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='api订阅表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `t_app_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_info`;
CREATE TABLE `t_app_info` (
`oid`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
`app_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统名字' ,
`app_remark`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统说明' ,
`app_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app的唯一标识' ,
`app_token`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app的渠道token' ,
`created_at`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`updated_at`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`created_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`updated_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
PRIMARY KEY (`oid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='app订阅表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `t_machine_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_machine_info`;
CREATE TABLE `t_machine_info` (
`oid`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
`m_ip`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务器ip' ,
`m_port`  int(11) NOT NULL COMMENT '服务器端口' ,
`f_sys_info_id`  bigint(20) NOT NULL COMMENT '所属系统id' ,
`created_at`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`updated_at`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`created_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`updated_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
`is_online`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否在线，1在线0下线' ,
PRIMARY KEY (`oid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='服务器注册表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `t_sys_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_info`;
CREATE TABLE `t_sys_info` (
`oid`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
`sys_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统名字' ,
`sys_remark`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统说明' ,
`created_at`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`updated_at`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`created_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`updated_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
PRIMARY KEY (`oid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='系统注册表'
AUTO_INCREMENT=14

;

-- ----------------------------
-- Auto increment value for `t_api_info`
-- ----------------------------
ALTER TABLE `t_api_info` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `t_api_subscription`
-- ----------------------------
ALTER TABLE `t_api_subscription` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `t_app_info`
-- ----------------------------
ALTER TABLE `t_app_info` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `t_machine_info`
-- ----------------------------
ALTER TABLE `t_machine_info` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `t_sys_info`
-- ----------------------------
ALTER TABLE `t_sys_info` AUTO_INCREMENT=14;
