INSERT INTO tb_user(name, nick, email, password) VALUES ('Maria', 'nickname', 'maria@gmail.com','1348.74');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Joao Silva', 'nickname','joao@gmail.com','9276.62');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Carlos Silva', 'nickname','carlos@gmail.com','7318.75');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Adriana', 'nickname','adriana@gmail.com','10688.93');

INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Maicon Cardoso', '44991682996', '07545268980', 'maiconscardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');
INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Maria Cardoso', '44991156978', '08577693258', 'maris2cardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');
INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Heitor Cardoso', null, '44654654654', 'heitorcardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');
INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Helena Cardoso', null, '65465465465', 'helenacardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');

INSERT INTO tb_provider(name, phone_number, cnpj, email, city, address, cep) VALUES ('Rolles Distribuidora', '44 34252970', '01.826.338/0001-60', 'rolles@gmail.com', 'Maringá', 'Av Colombo', '87085152');
INSERT INTO tb_provider(name, phone_number, cnpj, email, city, address, cep) VALUES ('Vespor Automotive', '44 34252970', '01.826.338/0001-60', 'vespor_automotive@hotmail.com', 'Maringá', 'Av Colombo', '87085152');

INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-10-23T14:18:23Z', 0, 1, 0.0);
INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-10-23T13:25:12Z', 1, 2, 0.0);
INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-08-10T08:14:54Z', 3, 3, 0.0);
INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-10-23T15:33:59Z', 2, 4, 0.0);

INSERT INTO tb_product (name, provider_id, factory_code, group_name, price, brand) VALUES ('Bronzina', 1, 4566998, 'Motor A.P', 25.60, 'MAHLE');
INSERT INTO tb_product (name, provider_id, factory_code, group_name, price, brand) VALUES ('Mancal', 2, 636995, 'Motor GM', 25.60, 'MAHLE');
INSERT INTO tb_product (name, provider_id, factory_code, group_name, price, brand) VALUES ('Arruela de Encosto', 2, 122545, 'Motor FORD', 25.60, 'TAKAO');
INSERT INTO tb_product (name, provider_id, factory_code, group_name, price, brand) VALUES ('Bucha de Biela', 1, 998874, 'Motor HONDA', 25.60, 'TAKAO');

INSERT INTO tb_labor (description, price, group_name) VALUES ('Retifica de Biela', 25.5, 'Motor AP');
INSERT INTO tb_labor (description, price, group_name) VALUES ('Retifica de Virabrequim', 120.0, 'Motor GM');
INSERT INTO tb_labor (description, price, group_name) VALUES ('Retifica de Bloco', 60.0, 'Motor Ford');
INSERT INTO tb_labor (description, price, group_name) VALUES ('Troca de Guia', 12.8, 'Motor Hunday');

INSERT INTO tb_order_item(quantity, price, product_id, order_id) VALUES (1, 50.5, 1, 1);
INSERT INTO tb_order_item(quantity, price, product_id, order_id) VALUES (1, 36.20, 3, 2);
INSERT INTO tb_order_item(quantity, price, product_id, order_id) VALUES (2, 158.35, 2, 1);
INSERT INTO tb_order_item(quantity, price, product_id, order_id) VALUES (2, 167.30, 4, 3);

INSERT INTO tb_order_labor(quantity, price, labor_id, order_id) VALUES (1, 50.5, 1, 1);
INSERT INTO tb_order_labor(quantity, price, labor_id, order_id) VALUES (1, 36.20, 3, 2);
INSERT INTO tb_order_labor(quantity, price, labor_id, order_id) VALUES (2, 158.35, 2, 1);
INSERT INTO tb_order_labor(quantity, price, labor_id, order_id) VALUES (2, 167.30, 4, 3);
