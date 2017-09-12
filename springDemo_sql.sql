drop table song_info;
create table song_info (
	songId integer,
	title varchar(100),
	artist varchar(100),
	album varchar(100),
	band varchar(100),
	rate varchar(20),
	len varchar(20),
	publishYear varchar(20),
	downSite varchar(10),
	onsale char(1),
	langType varchar(10),
	fileType varchar(10),
	isDownload char(1),
	localPath varchar(200),
	createTime timestamp,
	updateTime timestamp
);
create table song_lable (
	songId integer,
	labelName varchar(50),
	labelValue char(1),
	createTime timestamp
);

ALTER TABLE `song_info` ADD PRIMARY KEY(`songId`);
ALTER TABLE `song_info` CHANGE `songId` `songId` INT(11) NOT NULL AUTO_INCREMENT;

select * from song_info where title like '%東方妖々夢%';
select * from song_info where onsale is null;
select * from song_info where isDownload = 0;
select count(*) from song_info;
select * from song_info where title in (
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
	fileName varchar(100),
	fileType varchar(100),
	filePath varchar(100),
	downloadTimes int,
	create_time timestamp,
	update_time timestamp
);
	