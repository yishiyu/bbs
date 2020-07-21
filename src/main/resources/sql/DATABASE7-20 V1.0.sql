drop database gittub;
CREATE DATABASE gittub;
USE gittub;

SET @@global.auto_increment_increment = 1;

CREATE TABLE IF NOT EXISTS IMAGES(
`IID` INT NOT NULL AUTO_INCREMENT,
`URL` VARCHAR(1000) DEFAULT NULL,
PRIMARY KEY(`IID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS BLOCKS(
`BID` INT NOT NULL AUTO_INCREMENT,
`BLOCKNAME` VARCHAR(100) DEFAULT NULL,
`LOGO` INT NOT NULL,
CONSTRAINT FOREIGN KEY(`LOGO`) REFERENCES IMAGES(`IID`),
PRIMARY KEY(`BID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS USER(
`UID` INT NOT NULL AUTO_INCREMENT,
`USERNAME` VARCHAR(50) DEFAULT '未设置昵称！！',
`PASSWORD` VARCHAR(50) NOT NULL,
`EMAIL` VARCHAR(50) NOT NULL,
`HEAD_PORTRAIT` INT DEFAULT 1,
`ADMIN_PERMISSION` TINYINT(1) DEFAULT 0,
`STATUS` VARCHAR(5) DEFAULT 'N',
`CODE` VARCHAR(20) DEFAULT NULL,
`COMMENT` VARCHAR(100) DEFAULT '这个人很懒，什么都没有写',
`LIKEDTIME` INT DEFAULT 0,
`MYPOSTLIKEDTIME` INT DEFAULT 0,
CONSTRAINT FOREIGN KEY(`HEAD_PORTRAIT`) REFERENCES IMAGES(`IID`),
PRIMARY KEY(`UID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS POSTS(
`PID` INT NOT NULL AUTO_INCREMENT,
`UID` INT NOT NULL,
`BID` INT NOT NULL,
`TITLE` VARCHAR(50) NOT NULL,
`ABSTRACT` VARCHAR(50) NOT NULL,
`CONTENT` VARCHAR(2000) DEFAULT NULL,
`TIME` DATETIME DEFAULT '9999-12-31 23:59:59',
`SHOW` TINYINT(1) DEFAULT 1,
`VIEW` INT DEFAULT 0,
`LIKED` INT DEFAULT 0,
CONSTRAINT FOREIGN KEY(`UID`) REFERENCES USER(`UID`),
CONSTRAINT FOREIGN KEY(`BID`) REFERENCES BLOCKS(`BID`),
PRIMARY KEY(`PID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS REPLY(
`REID` INT NOT NULL AUTO_INCREMENT,
`UID` INT NOT NULL,
`PID` INT NOT NULL,
`CONTENT` VARCHAR(1000) DEFAULT NULL,
`TIME` DATETIME DEFAULT '9999-12-31 23:59:59',
`SHOW` TINYINT(1) DEFAULT 1,
CONSTRAINT FOREIGN KEY(`UID`) REFERENCES USER(`UID`),
CONSTRAINT FOREIGN KEY(`PID`) REFERENCES POSTS(`PID`),
PRIMARY KEY(`REID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS FAVORITE_UID(
`FUID` INT NOT NULL AUTO_INCREMENT,
`UID` INT NOT NULL,
`LIKEDUID` INT NOT NULL,
`TIME` DATETIME DEFAULT '9999-12-31 23:59:59',
CONSTRAINT FOREIGN KEY(`UID`) REFERENCES USER(`UID`),
CONSTRAINT FOREIGN KEY(`LIKEDUID`) REFERENCES USER(`UID`),
PRIMARY KEY(`FUID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS FAVORITE_PID(
`FPID` INT NOT NULL AUTO_INCREMENT,
`UID` INT NOT NULL,
`PID` INT NOT NULL,
`TIME` DATETIME DEFAULT '9999-12-31 23:59:59',
CONSTRAINT FOREIGN KEY(`UID`) REFERENCES USER(`UID`),
CONSTRAINT FOREIGN KEY(`PID`) REFERENCES POSTS(`PID`),
PRIMARY KEY(`FPID`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO IMAGES (`URL`) VALUES
('https://pic3.zhimg.com/50/v2-e2361d82ce7465808260f87bed4a32d0_qhd.jpg'),
('http://qdnhdgyix.bkt.clouddn.com/111'),
('http://qdnhdgyix.bkt.clouddn.com/222'),
('http://qdnhdgyix.bkt.clouddn.com/333'),
('http://qdnhdgyix.bkt.clouddn.com/444');

INSERT INTO BLOCKS (`BLOCKNAME`, `LOGO`) VALUES
('美食', 1),
('书籍', 1),
('体育', 1),
('财经', 1),
('政治', 1),
('学习', 1);

INSERT INTO USER (`USERNAME`, `PASSWORD`, `EMAIL`, `HEAD_PORTRAIT`, `ADMIN_PERMISSION`, `STATUS`, `CODE`, `COMMENT`, `LIKEDTIME`, `MYPOSTLIKEDTIME`) VALUES
('狗管理一号', SHA1('12345678'), '1146186018@qq.com', 2, 1, 'Y', 'QWER', '虽千万人吾亦往矣', 2, 2),
('狗管理二号', SHA1('87654321'), '814384981@qq.com', 3, 1, 'Y', 'tyui', '海不邀我自来也！！！', 2, 1),
('贾丁', SHA1('qwertyui'), '814384981@qq.com', 4, 0, 'Y', '1284', '别和我闹了', 2, 3),
('毕展语', SHA1('11111111'), '814384981@qq.com', 1, 0, 'Y', '1k4g', '让我们一起大喊——666！', 2, 3),
('李泽宇', SHA1('12345679'), '814384981@qq.com', 1, 0, 'N', 's8cr', '海上升明月', 0, 0);

INSERT INTO POSTS (`UID`, `BID`, `TITLE`, `ABSTRACT`, `CONTENT`, `TIME`, `SHOW`, `VIEW`, `LIKED`)VALUES
(1, 1, '给大家介绍学校周边好吃的', '学校 周边 美食', '想来想去也不知道今天中午吃什么，于是我灵机一动，打算开个帖子说说学校周边的美食', '2020-7-16 14:05:20', 1, 20, 2),
(2, 1, '学校边上的KFC挺好吃的', '星期四 开封菜 优惠', '今天晚上大家一起去吃开封菜好啦！！今天是疯狂星期四哦~', '2020-7-16 15:05:20', 1, 25, 1),
(3, 1, '今天夜宵出摊吗', '夜宵 饿', '没赶上前两波，只能吃夜宵了……', '2020-7-16 20:05:20', 1, 14, 2),
(4, 1, '学校的伙食太差了！', '食堂 学校 伙食', '我觉得学校的伙食实在太差了，真的难以下咽！', '2020-7-16 20:02:20', 1, 30, 3),
(2, 1, '学校边上的金拱门不太好吃', '优惠 金拱门', 'rt,你们真的不觉得学校旁边的金拱门没有开封菜好吃吗？？', '2020-7-16 23:05:20', 1, 22, 0),
(3, 1, '今天夜宵还出摊吗', '夜宵 饿', '是我，我又饿了，没办法就问问夜宵的状况', '2020-7-17 20:15:20', 1, 14, 1),
(4, 1, '这是一个隐藏贴，如果能看见请检查设置是否可见', '隐藏 测试', 'rt，这是一个隐藏贴，如果能看见请检查设置是否可见', '2020-7-18 22:54:20', 0, 0, 0);

INSERT INTO REPLY (`UID`, `PID`, `CONTENT`, `TIME`, `SHOW`) VALUES
(1, 1, '学校周边的好吃的很多，比如川湘菜馆和小六汤包，就是上等中的上等！', '2020-7-16 14:11:20', 1),
(1, 1, '还有外婆印象！也是很好的选择', '2020-7-16 14:15:20', 1),
(1, 1, '包括煎饼屋和百姓厨房，学校周边好吃的还是很多的', '2020-7-16 14:22:43', 1),
(2, 1, 'UPUP！赞一个', '2020-7-16 14:43:22', 1),
(3, 1, '确实，我也觉得这些都很好吃！', '2020-7-16 14:53:22', 1),
(1, 2, '胡扯，根本不好吃，开封菜炸鸡太老了！', '2020-7-16 15:11:20', 1),
(2, 2, '你个人的口味不要代表大众的口味，你没看到那么多人都在吃吗？', '2020-7-16 15:19:30', 1),
(1, 2, '哦？那你说说有多少人在吃呢？', '2020-7-16 15:21:20', 1),
(2, 2, '实话告诉你，学校里3/4的人都在吃！', '2020-7-16 15:25:40', 1),
(3, 2, '建议楼上和楼上上打一架，我最喜欢吃他家的薯条，真的好吃', '2020-7-16 15:26:20', 1),
(3, 3, '真的好饿，有没有人理我一下', '2020-7-16 20:23:20', 1),
(2, 3, '不知道，帮顶', '2020-7-16 20:25:20', 1),
(1, 3, '好像是10点吧', '2020-7-16 20:27:20', 1),
(4, 3, '十点半，今天有城管', '2020-7-16 20:33:20', 1),
(1, 4, '引战？虽然确实挺难吃的', '2020-7-16 20:34:20', 1),
(2, 4, '别说了，别老诋毁学校', '2020-7-16 20:36:20', 1),
(4, 4, '老子就是骂学校了怎么了？（这也是个隐藏回复，请测试是否可以显示）', '2020-7-16 20:39:20', 0),
(1, 5, '什么？？还有人觉得金拱门不好吃？不会吧不会吧不会吧？！', '2020-7-16 23:34:20', 1),
(2, 5, '就是我，金拱门没有开封菜好吃的！！', '2020-7-16 23:36:33', 1),
(3, 5, '呃，各有千秋吧，感觉其实都那样', '2020-7-16 23:44:20', 1),
(2, 5, '我不管，开封菜天下第一！金拱门smddx？', '2020-7-16 23:46:50', 1),
(1, 5, '我不管，金拱门天下第一！开封菜smddx？', '2020-7-16 23:46:51', 1),
(4, 5, '笑看狗管理打起来了', '2020-7-16 23:53:50', 1),
(3, 6, '真的好饿，每天都加班到这个点，有没有人理我一下orz', '2020-7-17 20:23:20', 1),
(2, 6, '不知道，依然是我，帮顶', '2020-7-17 20:25:20', 1),
(1, 6, '好像是10点半吧，之前有人说过，说是这个点会延迟', '2020-7-17 20:27:20', 1),
(4, 6, '十点，今天城管不加班，太惨了哥们', '2020-7-17 20:33:20', 1);

INSERT INTO FAVORITE_UID (`UID`, `LIKEDUID`, `TIME`) VALUES
(1, 2, '2020-7-14 16:11:20'),
(1, 3, '2020-7-14 17:12:10'),
(1, 4, '2020-7-14 18:13:30'),
(2, 1, '2020-7-14 19:14:21'),
(2, 4, '2020-7-14 20:15:23'),
(3, 1, '2020-7-14 21:16:24'),
(4, 2, '2020-7-14 22:17:25'),
(4, 3, '2020-7-13 23:58:21');

INSERT INTO FAVORITE_PID (`UID`, `PID`, `TIME`) VALUES
(1, 1, '2020-7-17 16:11:20'),
(3, 1, '2020-7-17 15:51:20'),
(2, 2, '2020-7-14 16:11:20'),
(1, 3, '2020-7-14 16:11:20'),
(2, 3, '2020-7-14 16:11:20'),
(3, 4, '2020-7-14 16:11:20'),
(1, 4, '2020-7-14 16:11:20'),
(4, 4, '2020-7-14 16:11:20'),
(3, 6, '2020-7-17 15:51:20');