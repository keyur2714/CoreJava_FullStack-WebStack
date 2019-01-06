create table item_details(id int AUTO_INCREMENT primary key,
code varchar(20) not null unique,
description varchar(100) not null,
price double not null
)
#
insert into item_details (code,description,price) values('TEA','Ginger Masala Tea',12)
insert into item_details (code,description,price) values('COFFEE','Black Coffe',20)
insert into item_details (code,description,price) values('CCOFFEE','Cold Coffee',30)

