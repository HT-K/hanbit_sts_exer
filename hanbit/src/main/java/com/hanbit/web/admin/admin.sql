---------------------------------------
-- Admin 테이블 생성
CREATE TABLE Admin(
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	cate INT  
);

---------------------------------------------------------
-- Admin 테이블에 값 넣기
INSERT INTO Admin(id, password, name, addr, birth, cate)
VALUES ('admin', '1', '관리자', '서울', 901013, 3);
INSERT INTO Admin(id, password, name, addr, birth, cate)
VALUES ('prof_kim', '1', '김교수', '인천', 750821, 2);
INSERT INTO Admin(id, password, name, addr, birth, cate)
VALUES ('prof_lee', '1', '이교수', '이천', 700915,2);
INSERT INTO Admin(id, password, name, addr, birth, cate)
VALUES ('prof_park', '1', '박교수', '포항', 691015,2);
---------------------------------------------------------

---------------------
-- Admin 테이블 내용 조회
SELECT * FROM Admin;
---------------------

--------------------------
-- Admin 테이블 삭제
DROP TABLE Admin CASCADE;
--------------------------