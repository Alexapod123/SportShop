insert into orders (id, client_name, client_email, delivery_address, order_date, total_sum, user_id)
values (1, 'Ivan', 'ivanov@test.com', 'Moscow, Kuznetcova, 49/2', '2024-12-11', '800', '2');

insert into orders_products (order_id, products_id) values (1, 2);
insert into orders_products (order_id, products_id) values (1, 4);