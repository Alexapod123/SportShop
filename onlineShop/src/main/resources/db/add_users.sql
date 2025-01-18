insert into users (id, name, lastname, email, password, address)
values (1, 'Admin', 'Admin', 'admin@mail.ru', 'admin', 'address');

insert into users (id, name, lastname, email, password, address)
values (2, 'Ivan', 'Ivanov', 'ivanov@test.com', 'ivanov', 'Moscow, Kuznetcova, 49/2');

insert into user_role (user_id, roles) values (1, 'ADMIN');
insert into user_role (user_id, roles) values (2, 'CLIENT');