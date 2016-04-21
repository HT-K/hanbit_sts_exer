-- 오라클 시퀀스 생성과 Mysql 시퀀스 생성은 다르다. , AUTO_INCREMENT 해주면 row가 생성될 때마다 자동을 증가한다.

-------------------------------------------------------------------------------------------------
-- Subject 테이블 생성
CREATE TABLE Subject (
	subj_seq int PRIMARY KEY AUTO_INCREMENT,
	subj_name VARCHAR(30),
	prof_id VARCHAR(30)
	CONSTRAINT subj_admin_fk FOREIGN KEY prof_id REFERENCES Admin(id) -- Admin 테이블의 id와 외래키로 연결~
);
-------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------
-- Suject 테이블에 값 넣기~
-- subj_seq, subj_name는 생략이 가능하지만 가능하면 써주고 안쓰면 VALUES에서 컬럼 수만큼 타입도 정확히 값을 넣어야한다.
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(1, 'java', 'prof_kim');
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(subj_seq, 'jsp', 'prof_kim');
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(subj_seq, 'sql', 'prof_lee');
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(subj_seq, 'spring', 'prof_lee');
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(subj_seq, 'nodejs', 'prof_park');
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(subj_seq, 'python', 'prof_park');
INSERT INTO Subject(subj_seq, subj_name, prof_id) 
VALUES(subj_seq, 'android', 'prof_park');
--------------------------------------------

-----------------------
-- Subject 테이블 조회
SELECT * FROM Subject;
-----------------------

----------------------------
-- Subject 테이블 삭제
DROP TABLE Subject CASCADE;
----------------------------

------------------------------------------------------
-- Subject 테이블에 컬럼 추가
ALTER TABLE Subject ADD COLUMN prof_id VARCHAR(30)
ALTER TABLE Subject ADD COLUMN prof_name VARCHAR(30);
------------------------------------------------------

------------------------------------------------------
-- Subject 테이블에 외래키 제약 조건 추가 (Admin 테이블의 id와 연결시킨다)
ALTER TABLE Subject
ADD FOREIGN KEY(prof_id)
REFERENCES Admin(id)
------------------------------------------------------

----------------------------------------------------
-- Subject 테이블의 내용 업데이트
UPDATE Subject 
SET
	prof_id = 'prof_kim'
WHERE subj_name = 'java' OR subj_name = 'jsp';

UPDATE Subject 
SET
	prof_id = 'prof_lee'
WHERE subj_name = 'sql' OR subj_name = 'spring';

UPDATE Subject 
SET
	prof_id = 'prof_park'
WHERE subj_name = 'nodejs' OR subj_name = 'python' OR subj_name = 'android';
------------------------------------------------------------------------------

-------------------------------
-- 조인 검색
-- Subject 테이블과 id로 연결된 Admin 테이블
-- 아이디가 같으면 해당 교수의 이름이 검색되게 한다.
SELECT
	s.subj_seq AS subjSeq,
	s.subj_name AS subjName,
	s.prof_id AS profID,
	a.name AS profName
FROM Subject s, Admin a
WHERE s.prof_id = a.id;
-------------------------------