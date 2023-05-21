create table users
(
	userid varchar(10) primary key,
	password varchar(15) not null,
	username varchar(8) not null,
	hash text
);
select * from users;
create table sessionlog
(
logid varchar(10) primary key,
logtype varchar(10) not null,
logdescription text,
userid varchar(10),
foreign key (userid)references  users(userid));
alter table sessionlog add column createdat timestamp;


create table post
(
	postid varchar(10) primary key,
	userid varchar(10) not null,
	posttitle varchar(15) not null,
	postdescription text ,
	createdat timestamp ,
	foreign key (userid) references users(userid)

)
create table media
(
mediaid varchar(10) primary key,
mediatype varchar(25) not null,
media bytea not null,
mediatitle text ,
mediadescription text,
createdat timestamp,
userid varchar(10),
foreign key(userid) references users(userid));
alter table users alter column username SET DATA TYPE text;