CREATE TABLE `sys_app_info` (
  `id` smallint (4) NOT NULL AUTO_INCREMENT,
  `app_id` char (16) NOT NULL DEFAULT '' COMMENT '客户端唯一id',
  `key` char (64) NOT NULL DEFAULT '' COMMENT '秘钥',
  `platform` varchar(16) NOT NULL DEFAULT '' COMMENT '平台：Android，iOS',
  `note` varchar(500) NOT NULL DEFAULT '' COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`),
  unique key (`app_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='AppInfo';