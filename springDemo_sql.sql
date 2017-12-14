drop table song_info;
create table song_info (
	songId integer,
	title varchar(255),
	artist varchar(255),
	album varchar(255),
	band varchar(255),
	rate varchar(255),
	len varchar(255),
	publishYear varchar(255),
	downSite varchar(255),
	onsale char(1),
	langType varchar(255),
	fileType varchar(255),
	isDownload char(1),
	localPath varchar(255),
	createTime timestamp,
	updateTime timestamp
);
create table song_lable (
	songId integer,
	labelName varchar(255),
	labelValue char(1),
	createTime timestamp
);
ALTER TABLE `song_info` ADD PRIMARY KEY(`songId`);
ALTER TABLE `song_info` CHANGE `songId` `songId` INT(11) NOT NULL AUTO_INCREMENT;
truncate table song_info;

select songid,title,artist,album from song_info order by songid desc;
select count(*) from song_info;
select count(*) from song_info where album is null;
select * from song_info where album is null;
select * from song_info where isDownload = 1;
select songid,title,artist,album from song_info where title in (
	select title from song_info group by title having count(*) > 1);
	
create table user_test (
	loginid varchar(50),
	`password`	varchar(50),
	salt	varchar(50),
	username varchar(50),
	mobile	varchar(20),
	email varchar(50),
	state varchar(1),
	birthday date,
	create_time	timestamp,
	update_time	timestamp
);
insert into user_test(loginid, `password`) values ("jzz", "123");

create table file_upload (
	fileName varchar(255),
	fileType varchar(255),
	filePath varchar(255),
	downloadTimes int,
	create_time timestamp,
	update_time timestamp
);

select * from user_test;
select * from address_test;
	