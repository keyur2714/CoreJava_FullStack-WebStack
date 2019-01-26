create table user_role(id int AUTO_INCREMENT primary key,
code varchar(20) not null unique,
description varchar(100) not null
);
insert into user_role (code,description) values('ADMIN','Admin User');
insert into user_role (code,description) values('SELLER','Sales User');

