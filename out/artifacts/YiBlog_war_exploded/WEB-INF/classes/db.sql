net start mysql80

mysql -uroot -p
123456

create database yiblog;

use yiblog;

create table usertable
(
id int(16) primary key not null auto_increment,
uname varchar(64) not null unique,
upwd varchar(32) not null,
nickname varchar(64) not null
);

desc usertable;


create table blogtable
(
id int(16) primary key not null auto_increment,
senderid int(16) not null references usertable(id),
content varchar(256) not null,
time varchar(16) not null,
replyto int(16) references blogtable(id)
);

alter table blogtable modify column time varchar(16);
alter table blogtable add replyto int(16) references blogtable(id);

alter table usertable add nickname varchar(64) not null;

