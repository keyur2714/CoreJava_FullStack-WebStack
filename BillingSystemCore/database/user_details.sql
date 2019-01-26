create table user_details(user_id int AUTO_INCREMENT primary key,
username varchar(50) not null unique,
password varchar(1000) not null,
active_yn char(1) default 'Y',
role_cd varchar(20) not null,
foreign key (role_cd) references user_role(code)
)
#
insert into user_details (username,password,role_cd) values('keyur','SW5kaWFAMjc=','ADMIN');
insert into user_details (username,password,role_cd) values('denish','QmhhcmF0QDI2','SELLER')

