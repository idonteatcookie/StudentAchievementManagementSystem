-- 学生表: 学号 密码 姓名
drop table if exists student;
create table student (
	sid int(9) primary key auto_increment,
	spwd varchar(20),
	sname varchar(20)
) AUTO_INCREMENT = 100000000 ;

-- 课程表: 课程号 课程名 学分
drop table if exists course;
create table course (
	cid int(9) primary key auto_increment,
	cname varchar(20),
	credit int
) AUTO_INCREMENT = 100000000 ;

-- 选课表: 学号 课程号 成绩
drop table if exists optcou;
create table optcou (
	sid int(9) not null,
	cid int(9) not null,
	score decimal(5,2) default -1,
	foreign key(sid) references student(sid) on delete cascade on update cascade,
	foreign key(cid) references course(cid) on delete cascade on update cascade,
	primary key(sid, cid)
);


insert into student(spwd,sname) values('1','小一'),('2','小二');
insert into course(cname, credit) values('高等数学',5),('大学英语',2),('线性代数',2),('大学计算机基础',1);
insert into optcou(sid,cid,score) values(100000000,100000000,80), (100000000,100000001,75), (100000000,100000002,80), (100000001,100000000,95);
insert into optcou(sid,cid) values(100000000,100000003);
