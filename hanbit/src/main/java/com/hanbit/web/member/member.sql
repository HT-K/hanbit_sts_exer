-- mysql 에서는 varchar2라는게 없다 오직 varchar!
-- mysql 에서는 number가 아니다! decimal로 숫자지정!

------------------------------------------------
-- 완성된 멤버테이블
CREATE TABLE Member( 
	id VARCHAR(30) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	major varchar(50),
	subject varchar(30),
	profile_img varchar(50),
	cate INT
);
------------------------------------------------

--------------------------------------------------------------------------------------------------------
-- Member 테이블에 값 넣어보기
INSERT INTO Member(id, password, name, addr, birth, major, subject, profile_img, cate)
VALUES ('hong','1','홍길동','서울',901013, '정보통신공학과', 'java/jsp/sql/spring', 'default_profile.png', 1);
INSERT INTO Member(id, password, name, addr, birth, major, subject, profile_img, cate)
VALUES ('kim','1','김유신','경기',920821, '멀티미디어시스템 공학과', 'java/jsp/sql/spring', 'default_profile.png', 1);
INSERT INTO Member(id, password, name, addr, birth, major, subject, profile_img, cate)
VALUES ('lee','1','이준기','부산',850810, '소프트웨어공학과', 'java/jsp/sql/spring', 'default_profile.png', 1);
INSERT INTO Member(id, password, name, addr, birth, major, subject, profile_img, cate)
VALUES ('song','1','송중기','대전',810519, '정보통신공학과', 'java/jsp/sql/spring', 'default_profile.png', 1);
INSERT INTO Member(id, password, name, addr, birth, major, subject, profile_img, cate)
VALUES ('yoon','1','윤시윤','인천',000918, '멀티미디어시스템', 'java/jsp/sql/spring', 'default_profile.png', 1);
INSERT INTO Member(id, password, name, addr, birth, major, subject, profile_img, cate)
VALUES ('kim2','1','김유신','LA',850510, '소프트웨어공학과', 'java/jsp/sql/spring', 'default_profile.png', 1);
---------------------------------------------------------------------------------------------------------

-------------------------
-- Member 테이블의 모든 내용 검색
SELECT * FROM Member;
-------------------------

---------------------------
-- Member 테이블 삭제하기
DROP TABLE Member CASCADE;
---------------------------

--------------------------------------
-- 조건에 맞는 Member 검색하기
SELECT * FROM Member WHERE id = 'kim';

SELECT * FROM Member
WHERE id = 'kim' and password = '1';
--------------------------------------

-------------------------------------------------
-- 조건에 맞는 테이블 row 삭제하기
DELETE FROM Member WHERE id = 'kim';
-------------------------------------------------

-------------------------------------------------
-- 테이블에 컬럼추가하기 ex1)
ALTER TABLE Member ADD COLUMN cate INT;

-- 테이블에 컬럼 추가하기 ex2)
ALTER TABLE Member ADD subject varchar(100); -- java/sql/spring
ALTER TABLE Member ADD major varchar(20); -- java/sql/spring
ALTER TABLE Member ADD profile_img varchar(100); -- 프로필 사진 
-------------------------------------------------

--------------------------------------------------------
-- 추가된 열에 값 넣기 ex1) (WHERE 조건을 안넣으면 모든 컬럼에 같은 값이 들어간다.)
UPDATE Member SET cate = 1;
UPDATE Member SET profile_img = 'default_profile.png';

-- 추가된 열에 조건추가해서 값 넣기 ex2)
-- id가 admin이면 cate컬럼을 3번으로 설정!
UPDATE Member SET cate = 3 WHERE id = 'admin';
--------------------------------------------------------

-----------------------------------------------------------------------------------------------
-- 여러 컬럼에 동시에 값넣기 (콤마(,)로 컬럼을 구분해서 값을 넣어주면 완성!
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'hong';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'kim';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'lee';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'song';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'yoon';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'kim2';
-----------------------------------------------------------------------------------------------

-----------------------------------------------------------------
-- DDL 테이블 수정

-- 1. 컬럼 추가
ALTER TABLE Member ADD subject varchar(100); -- java/sql/spring
ALTER TABLE Member ADD major varchar(20); -- java/sql/spring
ALTER TABLE Member ADD profile_img varchar(100); -- 프로필 사진 

-- 2. 컬럼 수정(이름)
ALTER TABLE Member RENAME COLUMN password TO pass; 
-- 3. 컬럼 수정(타입)
ALTER TABLE Member MODIFY birth DATE;
-----------------------------------------------------------------