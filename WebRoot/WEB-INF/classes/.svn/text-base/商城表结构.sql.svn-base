drop database if exists shop;
create database shop;
use shop;
/*删除管理员表*/
drop table if exists account;
/*删除用户表*/
drop table if exists users;
/*删除商品类别表*/
drop table if exists category;
/*删除商品表*/
drop table if exists goods;
/*删除购物车表*/
drop table if exists forder;
/*删除购物项表*/
drop table if exists sorder;
/*删除日志表*/
drop table if exists logs;
/*删除状态表*/
drop table if exists status;

/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   aid                  int not null auto_increment,
   /* 管理员登录名  */
   alogin               varchar(20),
   /* 管理员姓名  */
   aname                varchar(20),
   /* 管理员密码 */
   apass                varchar(20),
   /* 设置编号为主键 */
   primary key (aid)
);

/*============================*/
/* Table: 用户表结构 		  */
/*============================*/
create table users
(
   /* 用户编号,自动增长 */
   uid                  int not null auto_increment,
   /* 用户登录名 */
   ulogin               varchar(20),
   /* 用户真实姓名 */
   uname                varchar(20),
   /* 用户登录密码 */
   upass                varchar(20),
   /* 用户性别 */
   usex                 varchar(20),
   /* 用户电话 */
   uphone               varchar(20),
   /* 用户邮编 */
   upost                varchar(10),
   /* 用户Email */
   uemail               varchar(20),
   /* 用户所在地址 */
   uaddress             varchar(20),
   /* 设置用户编号为主键 */
   primary key (uid)
);

/*=============================*/
/* Table: 商品类别表结构 		   */
/*=============================*/
create table category
(
   /* 类别编号,自动增长 */
   cid                  int not null auto_increment,
   /* 类别名称 */
   ctype                varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   chot                 bool default false,
   /* 外键,此类别由哪位管理员管理 */
   aid                  int,
   /* 设置类别编号为主键 */
   primary key (cid)
);

/*=============================*/
/* Table: 商品表结构	 		   */
/*=============================*/
create table goods
(
   /* 商品编号,自动增长 */
   gid                  int not null auto_increment,
   /* 商品名称 */
   gname                varchar(20),
   /* 商品价格 */
   gprice               decimal(8,2),
   /* 商品图片 */
   gpic                 varchar(200),
   /* 商品简单介绍 */
   gremark              longtext,
   /* 商品详细介绍 */
   gxremark             longtext,
   /* 商品生产日期 */
   gdate                timestamp default CURRENT_TIMESTAMP,
   /* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
   gcommend             bool,
   /* 是否为有效商品,有效商品才有可能显示在商城首页 */
   gopen                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   /* 设置商品编号为主键 */
   primary key (gid)
);

/*=============================*/
/* Table: 订单表结构	 		   */
/*=============================*/
create table forder
(
   /* 订单编号,自动增长 */
   fid                  int not null auto_increment,
   /* 收件人名字 */
   fname                varchar(20),
   /* 收件人电话 */
   fphone               varchar(20),
   /* 配送信息 */
   fremark              varchar(20),
   /* 收件人邮箱 */
   femail               varchar(20),
   /* 下单日期 */
   fdate                timestamp default CURRENT_TIMESTAMP,
   /* 订单总金额 */
   ftotal               decimal(8,2),
   /* 收件人邮编 */
   fpost                varchar(20),
   /* 会员编号 */
   uid                  int,
   /* 订单状态 */
   sid                  int,
   /* 设置订单编号为主键 */
   primary key (fid)
);
/* 修改自动增长的初始值 */
ALTER TABLE forder AUTO_INCREMENT = 2113121801;

/*=============================*/
/* Table: 订单项表结构 		   */
/*=============================*/
create table sorder
(
   /* 购物项编号,自动增长 */
   sid                  int not null auto_increment,
   /* 被购买商品的名称 */
   sname                varchar(20),
   /* 购买时商品的价格 */
   sprice               decimal(8,2),
   /* 购买的数量 */
   snumber              int not null,
   /* 所属商品编号 */
   gid                  int,
   /* 此订单项,所属的订单编号 */
   fid                  int,
   /* 设置购物项编号为主键 */
   primary key (sid)
);

/*=============================*/
/* Table: 日志表结构	 		   */
/*=============================*/
create table logs
(
   /* 日志编号,自动增长 */
   lid                  int not null auto_increment,
   /* 请求路径 */
   lpath                varchar(200),
   /* 请求参数 */
   lparam               varchar(500),
   /* 请求的时间 */
   ldate                timestamp default CURRENT_TIMESTAMP,
   /* 如果是用户请求,存储用户编号 */
   uid                  int,
   /* 如果是管理员请求,存储管理员编号 */
   aid                  int,
   /* 设置日志编号为主键 */
   primary key (lid)
);

/*  ****Action_save.action   cid=5,ctype=男士休闲,chot=false*/


/*=============================*/
/* Table: 订单状态表结构 		   */
/*=============================*/
create table status
(
   /* 状态编号,自动增长 */
   sid                  int not null auto_increment,
   /* 订单状态 */
   status               varchar(10),
   /* 设置订单编号为主键 */
   primary key (sid)
);

/* 设置主外键约束,真实开发中,通过开发语言来约束而非数据库外键约束 */
/*
alter table sorder add constraint foreign key (gid)
      references goods (gid) on delete SET NULL on update SET NULL;

alter table sorder add constraint foreign key (fid)
      references forder (fid) on delete SET NULL on update SET NULL;

alter table category add constraint foreign key (aid)
      references account (aid) on delete SET NULL  on update SET NULL;

alter table forder add constraint foreign key (sid)
      references status (sid) on delete SET NULL on update SET NULL;

alter table forder add constraint foreign key (uid)
      references users (uid) on delete SET NULL on update SET NULL;

alter table goods add constraint foreign key (cid)
      references category (cid) on delete set null on update set null;

alter table logs add constraint foreign key (aid)
      references account (aid) on delete SET NULL on update SET NULL;

alter table logs add constraint foreign key (uid)
      references users (uid) on delete SET NULL on update SET NULL;
*/

/* 管理员测试用例*/
INSERT INTO account (alogin,aname,apass) VALUES ('admin','小超','admin');

/* 用户测试用例 */
INSERT INTO users (ulogin,uname,upass,usex,uphone,upost,uemail,uaddress)
VALUES ('user','小刚','user','男','13812345678','423456','10000@qq.com','中国钓鱼岛');

INSERT INTO users (ulogin,uname,upass,usex,uphone,upost,uemail,uaddress)
VALUES ('user2','小琴','user2','女','13812345679','888888','20000@qq.com','中国琉球岛');

/* 类别测试用例 */
INSERT INTO category (ctype,chot,aid) VALUES ('男士休闲',true,1);

INSERT INTO category (ctype,chot,aid) VALUES ('女士休闲',true,1);

INSERT INTO category (ctype,chot,aid) VALUES ('数码商品',true,1);

INSERT INTO category (ctype,chot,aid) VALUES ('日用百货',true,1);

/* 商品测试用例 */
INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('圣得西服',0.1,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('罗蒙西服',1999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('衫衫西服',3999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('金利来西服',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('韩版女装',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('雪地靴',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('欧版女装',3999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('女款手套',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('佳能单反机',3998.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('金士顿优盘',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('日立硬盘',0.1,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('大水牛机箱',399.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('电脑桌',150.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('老板椅',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('空调',3599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('电视',0.1,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

/* status测试数据 */

INSERT INTO status (status) VALUES ('未支付');
INSERT INTO status (status) VALUES ('已支付');
INSERT INTO status (status) VALUES ('正在配送');
INSERT INTO status (status) VALUES ('废单');

/* Forder测试数据 */
INSERT INTO forder (fname,fphone,fremark,femail,ftotal,fpost,uid) 
VALUES ('小华','12345678','周日不要配送','10000@qq.com',0.3,'432345',1);

/* sorder 测试数据  */
INSERT INTO sorder (sname,sprice,snumber,gid,fid) VALUES ('圣得西服',0.1,1,1,2013021801);
INSERT INTO sorder (sname,sprice,snumber,gid,fid) VALUES ('电视',0.1,2,16,2013021801);

SELECT * FROM account;
SELECT * FROM users;
SELECT * FROM category;
SELECT * FROM goods;
SELECT * FROM status;
SELECT * FROM forder;
SELECT * FROM sorder;
select * from logs;

UPDATE users set uemail='soft03_test@sina.com';

/*--- 创建权限表: 存储 要控制的URL地址*/
drop table if exists role_privilege;
drop table if exists privilege;
drop table if exists role;

create table privilege(
    pid int auto_increment,
    /* 存储权限的名次   添加商品 */
    pname varchar(100),
    /* 存储权限的URL地址, goodsAction_save */
    purl varchar(200),
    isleft boolean,
    /* 此键是外键,参照自身表主键  */
    parentId int,
    primary key(pid)
);

/*  角色表: 虚拟的概念,不是真正操作员 */
create table role(
    rid int auto_increment,
    rname varchar(100),
    rdetail varchar(500),
    primary key(rid)
);

/* 权限和角色是多对多的关系, 要建立权限、角色关联表 */
create table role_privilege(
    rid int,
    pid int,
    primary key(rid,pid)
);

/* 操作员和角色是多对多的,要建立关联表 */
create table account_role(
	aid int,
	rid int,
	primary key(aid,rid)
);

SELECT * FROM account;
SELECT * FROM account_role;

alter table privilege add constraint foreign key (parentId)
references privilege (pid) on delete SET NULL on update SET NULL;

alter table role_privilege add constraint foreign key (rid)
references role (rid);

alter table role_privilege add constraint foreign key (pid)
references privilege (pid);

INSERT INTO privilege (pname,purl,isleft) values ('商品管理','goodsAction_all',true);
INSERT INTO privilege (pname,purl,isleft) values ('类别管理','categoryAction_all',true);
INSERT INTO privilege (pname,purl,isleft) values ('操作员管理','accountAction_all',true);
INSERT INTO privilege (pname,purl,isleft) values ('订单管理','accountAction_all',true);
INSERT INTO privilege (pname,purl,isleft) values ('角色管理','roleAction_all',true);

INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加商品','goodsAction_saveUI',true,1);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加商品操作','goodsAction_save',false,1);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询商品','goodsAction_queryUI',true,1);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询商品操作','goodsAction_query',false,1);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新商品','goodsAction_updateUI',false,1);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新商品操作','goodsAction_update',false,1);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('删除商品','goodsAction_delete',false,1);

INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加类别','categoryAction_saveUI',true,2);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加类别操作','categoryAction_save',false,2);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询类别','categoryAction_queryUI',true,2);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询类别操作','categoryAction_query',false,2);
/* 类别是用ajax更新的, 所以没有更新类别的UI界面 */
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新类别操作','categoryAction_update',false,2);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('删除类别','categoryAction_delete',false,2);

INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加操作员','accountAction_saveUI',true,3);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加操作员操作','accountAction_save',false,3);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询操作员','accountAction_queryUI',true,3);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询操作员操作','accountAction_query',false,3);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新操作员','accountAction_updateUI',false,3);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新操作员操作','accountAction_update',false,3);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('删除操作员','accountAction_delete',false,3);

/* 添加订单是users的操作,操作员不能添加订单  */
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询订单','forderAction_queryUI',true,4);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询订单操作','forderAction_query',false,4);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新订单','forderAction_updateUI',true,4);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新订单操作','forderAction_update',false,4);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('删除订单','forderAction_delete',false,4);

INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加角色','roleAction_saveUI',true,5);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('添加角色操作','roleAction_save',false,5);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询角色','roleAction_queryUI',true,5);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('查询角色操作','roleAction_query',false,5);
/* 对角色的属性,进行更新操作, 包括授权操作 */
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新角色','roleAction_updateUI',false,5);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('更新角色操作','roleAction_update',false,5);
INSERT INTO privilege (pname,purl,isleft,parentId) values ('删除角色','roleAction_delete',false,5);


SELECT * FROM privilege;
SELECT * FROM role;
SELECT * FROM role_privilege;

/* 查询某个角色拥有的权限菜单 */
SELECT * FROM role r inner join role_privilege rp on r.rid=rp.rid inner join privilege p on rp.pid=p.pid