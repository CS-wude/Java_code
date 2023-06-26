/*创建数据库*/
CREATE DATABASE goodsale_system;
 
 
 /*创建货物表*/
CREATE TABLE tb_Goods(
Id INT PRIMARY KEY,
Goodname VARCHAR(8),
Price INT,
Number INT
);

/*创建销售人员表*/
CREATE TABLE tb_Salesperson(
Idcard INT PRIMARY KEY,
Salespersonname VARCHAR(8),
Age INT,
Workertype VARCHAR(8)
);
 
SELECT * FROM tb_Salesperson;


/*创建货物销售记录表*/
CREATE TABLE tb_goodsale(
Id VARCHAR(40) PRIMARY KEY,
Goodid INT,
Goodname VARCHAR(8),
Salespersonid INT,
Salespersonname VARCHAR(8),
Salenumber INT,
Money INT,
KEY good_id_fk (Goodid),
KEY saleperson_id_fk (Salespersonid),
CONSTRAINT good_id_fk FOREIGN KEY (Goodid) REFERENCES tb_goods (Id),
CONSTRAINT saleperson_id_fk FOREIGN KEY (Salespersonid) REFERENCES tb_salesperson (Idcard)
);
 
SELECT * FROM tb_goodsale;


/*创建账户表*/
CREATE TABLE tb_user(
username VARCHAR(20) PRIMARY KEY,
PASSWORD VARCHAR(20)
);

SELECT * FROM tb_user;