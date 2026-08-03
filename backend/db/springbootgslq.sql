DROP TABLE IF EXISTS crk; CREATE TABLE crk (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`refid`  bigint(20) NOT NULL COMMENT '关联表id' ,
`name`  varchar(200) NOT NULL COMMENT '出入库物品名称' ,
`sl`  bigint(20) NOT NULL COMMENT '出入库数量' ,
`crkzt` varchar(200)   DEFAULT NULL COMMENT '出入库状态' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='出入库表'
AUTO_INCREMENT=1637562662544
ROW_FORMAT=DYNAMIC
;DROP TABLE IF EXISTS `news`; CREATE TABLE `news` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`title`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题' ,
`introduction`  longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '简介' ,
`picture`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '系统公告图片' ,
`content`  longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '内容' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='系统公告'
ROW_FORMAT=DYNAMIC
;DROP TABLE IF EXISTS `forum`; CREATE TABLE `forum` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`title`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '帖子标题' ,
`content`  longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '帖子内容' ,
`parentid`  bigint(20) NULL DEFAULT '0' COMMENT '父节点id' ,
`userid`  bigint(20) NOT NULL COMMENT '用户id' ,
`username`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名' ,
`isdone`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '状态' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='论坛表'
AUTO_INCREMENT=1609987952877
ROW_FORMAT=DYNAMIC
;DROP TABLE IF EXISTS `storeup`; CREATE TABLE `storeup` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`userid`  bigint(20) NOT NULL COMMENT '用户id' ,
`refid`  bigint(20) NULL DEFAULT NULL COMMENT '收藏id' ,
`tablename`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '表名' ,
`name`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '收藏名称' ,
`picture`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '收藏图片' ,
`type`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩)' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='收藏表'
AUTO_INCREMENT=1637562662544
ROW_FORMAT=DYNAMIC
;DROP TABLE IF EXISTS `config`;CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '轮播图名称',
  `value` varchar(100) DEFAULT NULL COMMENT '轮播图地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='轮播图';DROP TABLE IF EXISTS `token`; CREATE TABLE `token` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`userid`  bigint(20) NOT NULL COMMENT '用户id' ,
`username`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名' ,
`tablename`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '表名' ,
`role`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色' ,
`token`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间' ,
`expiratedtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='token表'
AUTO_INCREMENT=11
ROW_FORMAT=DYNAMIC
;
DROP TABLE IF EXISTS `users`; CREATE TABLE `users` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`username`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名' ,
`password`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码' ,
`role`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '管理员' COMMENT '角色' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='用户表'
AUTO_INCREMENT=2
ROW_FORMAT=DYNAMIC
;
DROP TABLE IF EXISTS `yonghu`; CREATE TABLE yonghu( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,zhanghao  varchar(200) COMMENT '账号',mima  varchar(200) COMMENT '密码',shoujihao  varchar(200) COMMENT '手机号',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='用户';DROP TABLE IF EXISTS `xunlianrenyuan`; CREATE TABLE xunlianrenyuan( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,zhanghao  varchar(200) COMMENT '账号',mima  varchar(200) COMMENT '密码',shoujihao  varchar(200) COMMENT '手机号',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='训练人员';DROP TABLE IF EXISTS `Discussxunlianyingxinxi`; CREATE TABLE Discussxunlianyingxinxi (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`refid`  bigint(20) NOT NULL COMMENT '关联表id' ,
`userid`  bigint(20) NOT NULL COMMENT '用户id' ,
`nickname` varchar(200)   DEFAULT NULL COMMENT '用户名' ,
`content` longtext   COMMENT '评论内容' ,
`reply` longtext  COMMENT '回复内容',
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='训练营信息评论表'
;
DROP TABLE IF EXISTS `xunlianyingxinxi`; CREATE TABLE xunlianyingxinxi( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,xunlianyingmingcheng  varchar(200) COMMENT '训练营名称',xunlianyingtupian  varchar(200) COMMENT '训练营图片',zhaoshourenshu  varchar(200) COMMENT '招收人数',xiangqing  longtext COMMENT '详情',kaifangshijian  date COMMENT '开放时间',thumbsupnum int(11)  NULL DEFAULT 0  COMMENT '赞',crazilynum int(11)  NULL DEFAULT 0 COMMENT '踩',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='训练营信息';DROP TABLE IF EXISTS `yuyueguanli`; CREATE TABLE yuyueguanli( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,xunlianyingmingcheng  varchar(200) COMMENT '训练营名称',xunlianyingtupian  varchar(200) COMMENT '训练营图片',yuyueren  varchar(200) COMMENT '预约人',yuyuerendianhua  varchar(200) COMMENT '预约人电话',yuyuerennianling  varchar(200) COMMENT '预约人年龄',yuyuerenxingbie  varchar(200) COMMENT '预约人性别',yuyueshijian  datetime COMMENT '预约时间', userid  bigint(20) COMMENT '用户id',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='预约管理';DROP TABLE IF EXISTS `Discussbisaiguanli`; CREATE TABLE Discussbisaiguanli (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`addtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`refid`  bigint(20) NOT NULL COMMENT '关联表id' ,
`userid`  bigint(20) NOT NULL COMMENT '用户id' ,
`nickname` varchar(200)   DEFAULT NULL COMMENT '用户名' ,
`content` longtext   COMMENT '评论内容' ,
`reply` longtext  COMMENT '回复内容',
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='比赛管理评论表'
;
DROP TABLE IF EXISTS `bisaiguanli`; CREATE TABLE bisaiguanli( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,changdimingcheng  varchar(200) COMMENT '场地名称',changditupian  varchar(200) COMMENT '场地图片',changdidaxiao  varchar(200) COMMENT '场地大小',changdirenshu  varchar(200) COMMENT '场地人数',xiangqing  longtext COMMENT '详情',bisaishijian  datetime COMMENT '比赛时间',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='比赛管理';DROP TABLE IF EXISTS `qicaiguanli`; CREATE TABLE qicaiguanli( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,qicaimingcheng  varchar(200) COMMENT '器材名称',qicaitupian  varchar(200) COMMENT '器材图片',qicaiyongtu  longtext COMMENT '器材用途', alllimittimes  int(11) NULL DEFAULT '-1' COMMENT '库存',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='器材管理';DROP TABLE IF EXISTS `xunlianxiangmu`; CREATE TABLE xunlianxiangmu( id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',addtime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,xiangmumingcheng  varchar(200) COMMENT '项目名称',xiangmutupian  varchar(200) COMMENT '项目图片',jiaolianxingming  varchar(200) COMMENT '教练姓名',jiaoliandianhua  varchar(200) COMMENT '教练电话',xunlianrenshu  varchar(200) COMMENT '训练人数',xunlianshijian  datetime COMMENT '训练时间', userid  bigint(20) COMMENT '用户id',sfsh  varchar(200)  DEFAULT '否' COMMENT '是否审核',shhf  longtext COMMENT '审核回复',PRIMARY KEY  (id))ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
COMMENT='训练项目';
