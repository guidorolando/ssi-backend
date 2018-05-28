-- product items
insert into product(id, description, name, price) values(1, 'Retornable', 'Coca-Cola', 10);
insert into product(id, description, name, price) values(2, 'Etiqueta Negra', 'Casa Real', 75);
insert into product(id, description, name, price) values(3, 'Etiqueta Roja', 'Casa Real', 75);
insert into product(id, description, name, price) values(4, '620', 'Huari', 15);
insert into product(id, description, name, price) values(5, 'Sin Alcohol', 'Huari', 10);
insert into product(id, description, name, price) values(6, 'Cigarrillo LM Azul', 'LM Azul', 12);
insert into product(id, description, name, price) values(7, 'Cigarrillo LM Rojo', 'LM Rojo', 12);
insert into product(id, description, name, price) values(8, 'Cigarrillo Derby Antiguo', 'Derby Antiguo', 8.5);


-- customer items
insert into customer(id, first_name, last_name, address, gender, image_url) values(1, 'garance', 'joly', 'Quillacollo', 'FEMALE', 'https://randomuser.me/api/portraits/thumb/women/51.jpg');
insert into customer(id, first_name, last_name, address, gender, image_url) values(2, 'christian', 'lenz', 'Vinto', 'MALE', 'https://randomuser.me/api/portraits/thumb/men/86.jpg');
insert into customer(id, first_name, last_name, address, gender, image_url) values(3, 'lauren', 'peterson', 'Punata', 'FEMALE', 'https://randomuser.me/api/portraits/thumb/women/9.jpg');
insert into customer(id, first_name, last_name, address, gender, image_url) values(4, 'Dalmiro', 'Cuellar', 'Sipe-Sipe', 'MALE', 'https://randomuser.me/api/portraits/thumb/men/71.jpg');
insert into customer(id, first_name, last_name, address, gender, image_url) values(5, 'Lia', 'Saldazo', 'Sacaba', 'FEMALE', 'https://randomuser.me/api/portraits/thumb/women/93.jpg');


-- security
INSERT INTO role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

insert into person (id, first_name, last_name, birth_date, gender) values (1, 'admin', 'admin', '2000-05-26', 'MALE');
insert into person (id, first_name, last_name, birth_date, gender) values (2, 'john', 'doe', '2000-05-26', 'MALE');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO user (id, password, username, person_id) VALUES (1, '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'john.doe', 2);
INSERT INTO user (id, password, username, person_id) VALUES (2, '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin.admin', 1);


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

insert into employee (id, first_name, last_name, birth_date, gender, email, phone, address, salary) values (1, 'carmen', 'guzman', '1990-05-26', 'FEMALE', 'carmen@guzman.com', 70304856, 'sacaba', 4000.00);
insert into employee (id, first_name, last_name, birth_date, gender, email, phone, address, salary) values (2, 'Carlos', 'Cori', '1980-05-26', 'MALE', 'carlos@cori.com', 70304800, 'tiquepaya', 4000.00);
insert into employee (id, first_name, last_name, birth_date, gender, email, phone, address, salary) values (3, 'Maximilian', 'Toro', '1985-05-26', 'MALE', 'maxi@toro.com', 60574635, 'quillacollo', 5000.00);
insert into employee (id, first_name, last_name, birth_date, gender, email, phone, address, salary) values (4, 'Marco', 'Herrera', '1986-05-26', 'MALE', 'marco@herrera.com', 67453634, 'sebastian pagador', 5000.00);
