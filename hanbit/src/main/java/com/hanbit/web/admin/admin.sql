CREATE TABLE Admin(
	id VARCHAR(30) PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	role VARCHAR(30)  
);
------------------------------------------------------
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('admin','관리자','admin','서울',901013,'admin');
------------------------------------------------------
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('prof_kim','김교수','1','인천',750821,'prof');
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('prof_lee','이교수','1','이천',700915,'prof');
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('prof_park','박교수','1','포항',691015,'prof');
-----------------------------------------------------------
SELECT * FROM Admin;
----------------------------------------------
DROP TABLE Admin CASCADE;