create table order_item_list(order_item_list_id int AUTO_INCREMENT primary key,
order_id int not null,
item_id int not null,
quantity int not null,
price double not null,
foreign key (item_id) references item_details(id),
foreign key (order_id) references order_details(order_id)
)


