SELECT * FROM TEST;

-- mysql 에서는 varchar2라는게 없다 오직 varchar!
-- mysql 에서는 number가 아니다! decimal로 숫자지정!
CREATE TABLE Member( 
	id VARCHAR(30) PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth DECIMAL
);

INSERT INTO Member(id,name,password,addr,birth)
VALUES ('hong','홍길동','1','서울',901013);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('kim','김유신','1','경기',801210);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('lee','이순신','1','부산',850810);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('song','송중기','1','대전',810519);
INSERT INTO Member
VALUES ('yoon','윤손하','1','인천',000918);
INSERT INTO Member
VALUES ('kim2','김유신','1','LA',850510);


SELECT * FROM Member;

DROP TABLE Member CASCADE CONSTRAINT;

SELECT * FROM Member WHERE id = 'kim';

SELECT * FROM Member
WHERE id = 'kim' and password = '1';