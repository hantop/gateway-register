# api服务注册与订阅
## 说明
后端开发的服务，通过注册服务器向网关提供功能。注册服务器主要有如下功能。但它不同于soa服务自动发现的注册服务器，它只是前后端进行协议定义的收集地。关于注册与订阅是否要作成自动发现，这个有待商榷。原因是api在使用的过程中，前后端需要先定义协议，后面进入开发与使用，是面向协议编程，而非面向接口或面向对象。如果为了提高网关对于api的服务器信息及权限校验信息的更高效可以将这部分数据作缓存，而无需作自动注册与发现。

## 主要功能
### 注册主要功能

- 系统注册
- api注册
- 服务器注册


它们的关系是，一个系统提供n个api服务，该系统的服务器是由服务器绑定来提供。

### 注册功能表结构


         create table t_sys_info(
			oid bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
			sys_name varchar(200) not null comment '系统名字' ,
			sys_remark varchar(20) not null COMMENT '系统说明' ,
			created_at datetime DEFAULT NULL COMMENT '创建时间' ,
	 		updated_at datetime DEFAULT NULL COMMENT '更新时间' ,
	  		created_by varchar(100) DEFAULT NULL COMMENT '创建人' ,
	  		updated_by varchar(100) DEFAULT NULL COMMENT '更新人',
	  		PRIMARY KEY (oid)
		)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api系统注册表';
		
		
	
		create table t_api_info(
    	oid bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
		api_name varchar(200) not null comment 'api的名字',
    	api_id varchar(200) not null comment 'api的唯一标识',
		api_version varchar(20) not null default '1.0.0' comment 'api版本号', 
		api_paras_name varchar(200) comment '请求参数名,多个用逗号隔开',
		api_req_method varchar(20) comment '支持的请求方法,多个用英文逗号隔开', 
		f_sys_info_id bigint(20) not null comment  '所属系统id',
		api_url varchar(200) not null  comment '请求路径,即对应的spring mvc requestmapping的value值',
		created_at datetime DEFAULT NULL COMMENT '创建时间',
 		updated_at datetime DEFAULT NULL COMMENT '更新时间',
  		created_by varchar(100) DEFAULT NULL COMMENT '创建人',
  		updated_by varchar(100) DEFAULT NULL COMMENT '更新人',
  		PRIMARY KEY (oid)  	
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api注册表';
	create unique index api_id_version on t_api_info(api_id,api_version);
	
	

	 create table t_machine_info(
    	oid bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
    	m_ip varchar(200) not null comment '服务器ip',
		m_port int not null comment '服务器端口',  
		f_sys_info_id bigint(20) not null COMMENT  '所属系统id',
		created_at datetime DEFAULT NULL COMMENT '创建时间',
 		updated_at datetime DEFAULT NULL COMMENT '更新时间',
  		created_by varchar(100) DEFAULT NULL COMMENT '创建人',
  		updated_by varchar(100) DEFAULT NULL COMMENT '更新人',
  		PRIMARY KEY (oid)  	
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='服务器注册表';;

	alter table t_api_info add is_online tinyint(4) not null default 1 comment '是否在线，1在线0下线';
	alter table t_machine_info add is_online tinyint(4) not null default 1 comment '是否在线，1在线0下线';
	alter table t_api_info add api_protocol varchar(20) not null default 'http' comment '请求协议,http,https';

### app订阅主要功能

- 订阅app的创建
- 该app 所订阅的api服务
###app订阅api数据表结构

    create table t_app_subscription(
			oid bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk' ,
			app_name varchar(200) not null comment '系统名字' ,
			app_remark varchar(20) not null COMMENT '系统说明' ,
			app_id  varchar(20) not null comment 'app的唯一标识',
			app_token varchar(20) not null comment 'app的渠道token',
			created_at datetime DEFAULT NULL COMMENT '创建时间' ,
	 		updated_at datetime DEFAULT NULL COMMENT '更新时间' ,
	  		created_by varchar(100) DEFAULT NULL COMMENT '创建人' ,
	  		updated_by varchar(100) DEFAULT NULL COMMENT '更新人',
	  		PRIMARY KEY (oid)
		)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='app订阅表';
	
		create unique index idx_app_id_token on t_app_subscription(app_id,app_token);

		create table t_api_subscription(
			oid bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
			f_app_subscription_id bigint(20) not null comment  'app订阅系统id',
			f_api_info_id bigint(20) not null comment '订阅的apiid',
			created_at datetime DEFAULT NULL COMMENT '创建时间' ,
	 		updated_at datetime DEFAULT NULL COMMENT '更新时间' ,
	  		created_by varchar(100) DEFAULT NULL COMMENT '创建人' ,
	  		updated_by varchar(100) DEFAULT NULL COMMENT '更新人',
  		PRIMARY KEY (oid)  	
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api订阅表';
