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
insert into person (id, first_name, last_name, birth_date, gender) values (3, 'nicol', 'admin', '2015-05-26', 'MALE');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO user (id, password, username, person_id) VALUES (1, '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'john.doe', 2);
INSERT INTO user (id, password, username, person_id) VALUES (2, '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin.admin', 1);


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);


--- AREA
-- insert values Area

INSERT INTO area(id,name,description,codigo) VALUES(1,'Area A','Planta Baja' ,'001');
INSERT INTO area(id,name,description,codigo) VALUES(2,'Area B','Planta Baja' ,'002');
INSERT INTO area(id,name,description,codigo) VALUES(3,'Area C','Planta Alta' ,'003');


-- ROLE
-- insert Role
INSERT INTO role(id,name,role_name,description) VALUES(1,'Area A','STANDARD_USER' ,'Jefe de Operaciones');
INSERT INTO role(id,name,role_name,description) VALUES(2,'Area B','STANDARD_USER' ,'Jefe de Operciones electricista');
INSERT INTO role(id,name,role_name,description) VALUES(3,'Area C','STANDARD_USER','Jefe de Operciones Plomero');

-- Personal Information
-- insert PersonalInformation
INSERT INTO personalInformation(id,first_name,last_name,area,capacity,role_type,observations,registration_date) VALUES(1,'firstName3','lastName3','area3','capacity3','role3','observations3','1990-05-26');
INSERT INTO personalInformation(id,first_name,last_name,area,capacity,role_type,observations,registration_date) VALUES(2,'firstName1','lastName1','area1','capacity1','role1','observations1','1990-05-26');
INSERT INTO personalInformation(id,first_name,last_name,area,capacity,role_type,observations,registration_date) VALUES(3,'firstName2','lastName2','area2','capacity2','role2','observations2','1990-05-26');



-- Employee
insert into employee (id, ci, first_name, last_name, birth_date, gender, email, phone, address, salary) values (1, '7676764', 'carmen', 'guzman', '1990-05-26', 'FEMALE', 'carmen@guzman.com', 70304856, 'sacaba', 4000.00);
insert into employee (id, ci, first_name, last_name, birth_date, gender, email, phone, address, salary) values (2, '5454345', 'Carlos', 'Cori', '1980-05-26', 'MALE', 'carlos@cori.com', 70304800, 'tiquepaya', 4000.00);
insert into employee (id, ci, first_name, last_name, birth_date, gender, email, phone, address, salary) values (3, '1234567', 'Maximilian', 'Toro', '1985-05-26', 'MALE', 'maxi@toro.com', 60574635, 'quillacollo', 5000.00);
insert into employee (id, ci, first_name, last_name, birth_date, gender, email, phone, address, salary) values (4, '1234567', 'Marco', 'Herrera', '1986-05-26', 'MALE', 'marco@herrera.com', 67453634, 'sebastian pagador', 5000.00);


--MaterialType
insert into material_type (id, name) values (1, 'proteccion personal')
insert into material_type (id, name) values (2, 'seguridad')
insert into material_type (id, name) values (3, 'Adicional')

--Material
insert into material (id, name, mat_description, material_type) values (1, 'casco', 'description01', '1')
insert into material (id, name, mat_description, material_type) values (2, 'arnez', 'description02', '2')

--Employees

