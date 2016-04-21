SELECT * FROM TEST;

-- mysql 에서는 varchar2라는게 없다 오직 varchar!
-- mysql 에서는 number가 아니다! decimal로 숫자지정!
CREATE TABLE Member( 
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth DECIMAL,
	cate DECIMAL
);

INSERT INTO Member(id,password,name,addr,birth)
VALUES ('hong','1','홍길동','서울',901013);
INSERT INTO Member(id,password,name,addr,birth)
VALUES ('kim','1','김유신','경기',920821);
INSERT INTO Member(id,password,name,addr,birth)
VALUES ('lee','1','이준기','부산',850810);
INSERT INTO Member(id,password,name,addr,birth)
VALUES ('song','1','송중기','대전',810519);
INSERT INTO Member(id,password,name,addr,birth)
VALUES ('yoon','1','윤시윤','인천',000918);
INSERT INTO Member(id,password,name,addr,birth)
VALUES ('kim2','1','김유신','LA',850510);

SELECT * FROM Member;

DROP TABLE Member CASCADE;

SELECT * FROM Member WHERE id = 'kim';

SELECT * FROM Member
WHERE id = 'kim' and password = '1';

----------------------------------------------------
DELETE FROM Member WHERE id = 'kim';
-------------------------------------------------
-- 테이블에 컬럼추가하기
ALTER TABLE Member ADD COLUMN cate DECIMAL;
-------------------------------------------------
-- 추가된 열에 값 넣기 (WHERE 조건을 안넣으면 모든 컬럼에 같은 값이 들어간다.)
UPDATE Member SET cate = 1;
-------------------------------------------------
-- id가 admin이면 cate컬럼을 3번으로 설정!
UPDATE Member SET cate = 3 WHERE id = 'admin';
-------------------------------------------------

UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'hong';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'kim';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'lee';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'song';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'yoon';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'kim2';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'jang2';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'jun';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'jang';

UPDATE Member SET profile_img = 'default_profile.png';

DELETE FROM Member WHERE id = 'choi';

SELECT * FROM Member;

SELECT * FROM Member
WHERE id = 'song';

SELECT * FROM Member
WHERE id = 'kim' and password = '1';

-- DDL 테이블 수정

-- 1. 컬럼 추가
ALTER TABLE Member ADD subject varchar(100); -- java/sql/spring
ALTER TABLE Member ADD major varchar(20); -- java/sql/spring
ALTER TABLE Member ADD profile_img varchar(100); -- 프로필 사진 

-- 2. 컬럼 수정(이름)
ALTER TABLE Member RENAME COLUMN password TO pass; 
-- 3. 컬럼 수정(타입)
ALTER TABLE Member MODIFY birth DATE;