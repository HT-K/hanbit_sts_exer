CREATE TABLE Admin(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER,
	role varchar2(30) DEFAULT 'admin'   
);

INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('admin','관리자','admin','서울',901013,'admin');

SELECT * FROM Admin;