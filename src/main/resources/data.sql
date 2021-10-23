INSERT INTO tb_user(name, nick, email, password) VALUES ('Maria', 'nickname', 'maria@gmail.com','1348.74');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Joao Silva', 'nickname','joao@gmail.com','9276.62');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Carlos Silva', 'nickname','carlos@gmail.com','7318.75');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Adriana', 'nickname','adriana@gmail.com','10688.93');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Karina','nickname', 'karina@gmail.com','7251.28');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Carlos Marques', 'nickname','carlos@gmail.com','5485.79');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Carlos Pereira','nickname', 'carlos@gmail.com','3519.41');
INSERT INTO tb_user(name, nick, email, password) VALUES ('Ana Maria','nickname', 'ana@gmail.com','2569.20');

INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Maicon Cardoso', '44991682996', '07545268980', 'maiconscardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');
INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Maria Cardoso', '44991156978', '08577693258', 'maris2cardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');
INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Heitor Cardoso', null, '44654654654', 'heitorcardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');
INSERT INTO tb_customer(name, fone, cpf, email, city, address, cep) VALUES ('Helena Cardoso', null, '65465465465', 'helenacardoso@hotmail.com', 'Paranavaí', 'Rua João Capixaba', '87706443');

INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-10-23', 0, 1, 7657.0);
INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-10-23', 1, 2, 5457.0);
INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-08-10', 3, 3, 77.0);
INSERT INTO tb_order(creation_date, status, id_customer, amount) VALUES ('2020-10-23', 2, 4, 857.0);