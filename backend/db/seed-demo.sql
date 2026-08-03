-- 篮球训练营演示数据
-- 仅用于本地开发与功能演示，部署到真实环境前请替换账号和业务数据。

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES (1, 'admin', 'ChangeMe123!', '管理员');
INSERT INTO `yonghu` (`zhanghao`, `mima`, `shoujihao`) VALUES ('demo_user', 'ChangeMe123!', '00000000000');
INSERT INTO `xunlianrenyuan` (`zhanghao`, `mima`, `shoujihao`) VALUES ('demo_coach', 'ChangeMe123!', '00000000000');
INSERT INTO `config` (`name`, `value`) VALUES
  ('首页轮播图1', '/springbootgslq/upload/轮播图_17.png'),
  ('首页轮播图2', '/springbootgslq/upload/轮播图_16.png'),
  ('首页轮播图3', '/springbootgslq/upload/轮播图_19.png');
INSERT INTO `news` (`addtime`, `title`, `introduction`, `picture`, `content`) VALUES
  (NOW(), '训练营开放报名通知', '新一期篮球训练营开放报名，欢迎热爱篮球运动的学员参加。', '/springbootgslq/upload/公告_18.png', '<p>欢迎来到篮球训练营。请在训练营详情页查看课程安排和报名要求。</p>');
INSERT INTO `xunlianyingxinxi` (`addtime`, `xunlianyingmingcheng`, `xunlianyingtupian`, `zhaoshourenshu`, `xiangqing`, `kaifangshijian`, `thumbsupnum`, `crazilynum`) VALUES
  (NOW(), '青少年篮球基础训练营', '/springbootgslq/upload/轮播图_17.png', '30人', '系统训练运球、传球、投篮和基础防守，适合篮球基础阶段学员。', DATE_ADD(CURDATE(), INTERVAL 14 DAY), 0, 0);
INSERT INTO `yuyueguanli` (`addtime`, `xunlianyingmingcheng`, `xunlianyingtupian`, `yuyueren`, `yuyuerendianhua`, `yuyuerennianling`, `yuyuerenxingbie`, `yuyueshijian`, `userid`) VALUES
  (NOW(), '青少年篮球基础训练营', '/springbootgslq/upload/轮播图_17.png', '演示学员', '00000000000', '12', '未设置', DATE_ADD(NOW(), INTERVAL 7 DAY), 1);
INSERT INTO `bisaiguanli` (`addtime`, `changdimingcheng`, `changditupian`, `changdidaxiao`, `changdirenshu`, `xiangqing`, `bisaishijian`) VALUES
  (NOW(), '示例体育馆篮球场', '/springbootgslq/upload/场地_10.png', '标准全场', '可容纳100人', '用于训练营内部交流赛和阶段性成果展示。', DATE_ADD(NOW(), INTERVAL 21 DAY));
INSERT INTO `qicaiguanli` (`addtime`, `qicaimingcheng`, `qicaitupian`, `qicaiyongtu`, `alllimittimes`) VALUES
  (NOW(), '标准篮球', '/springbootgslq/upload/场地_10.png', '训练和比赛通用篮球。', 20);
INSERT INTO `xunlianxiangmu` (`addtime`, `xiangmumingcheng`, `xiangmutupian`, `jiaolianxingming`, `jiaoliandianhua`, `xunlianrenshu`, `xunlianshijian`, `userid`, `sfsh`, `shhf`) VALUES
  (NOW(), '基础投篮训练', '/springbootgslq/upload/场地_10.png', '示例教练', '00000000000', '20', DATE_ADD(NOW(), INTERVAL 3 DAY), 1, '是', '演示项目已通过审核。');
INSERT INTO `forum` (`addtime`, `title`, `content`, `parentid`, `userid`, `username`, `isdone`) VALUES
  (NOW(), '如何安排每周投篮训练？', '建议根据训练目标安排固定频率，并记录每次训练的命中率和完成情况。', 0, 1, '演示用户', '进行中');
