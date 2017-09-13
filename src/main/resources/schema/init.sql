CREATE TABLE If Not Exists `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` VARCHAR(50) NOT NULL DEFAULT '未填写' COMMENT '用户名称',
  `phone` VARCHAR(15) NOT NULL UNIQUE COMMENT '用户电话',
  `email` VARCHAR(50) NOT NULL DEFAULT '未填写' COMMENT '用户邮箱',
  `industry` VARCHAR(50) NOT NULL DEFAULT '未填写' COMMENT '用户行业',
  `type` VARCHAR(5) NOT NULL DEFAULT 'dike' COMMENT '用户咨询类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 初始化用户数据
INSERT IGNORE INTO `user` (`name`, `phone`, `email`, `industry`)
    VALUES
      ('胡佳', '13554716410', 'cshujia@qq.com', '互联网金融');