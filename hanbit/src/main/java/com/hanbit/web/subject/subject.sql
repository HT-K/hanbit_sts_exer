-- 오라클 시퀀스 생성과 Mysql 시퀀스 생성은 다르다.
CREATE TABLE Subject (
	subj_seq int PRIMARY KEY AUTO_INCREMENT,
	subj_name VARCHAR(30),
	prof_id VARCHAR(30),
	prof_name VARCHAR(30)
	CONSTRAINT subj_admin_fk FOREIGN KEY prof_id REFERENCES Admin(id) -- Admin 테이블의 id와 외래키로 연결~
);
------------------------------------------------------------------------------------
DROP TABLE Subject CASCADE;
-----------------------------------------------------------------------------------
-- subj_seq, subj_name는 생략이 가능하지만 가능하면 써주고 안쓰면 VALUES에서 컬럼 수만큼 타입도 정확히 값을 넣어야한다.
INSERT INTO Subject(subj_seq, subj_name, prof_id, prof_name) 
VALUES(1,'java','prof_kim');
INSERT INTO Subject(subj_seq, subj_name, prof_id, prof_name) 
VALUES(subj_seq,'jsp','prof_kim');
INSERT INTO Subject(subj_seq, subj_name, prof_id, prof_name) 
VALUES(subj_seq,'sql','prof_lee');
INSERT INTO Subject(subj_seq, subj_name, prof_id, prof_name) 
VALUES(subj_seq,'spring','prof_lee');
INSERT INTO Subject(subj_seq, subj_name, prof_id, prof_name) 
VALUES(subj_seq,'nodejs','prof_park');
INSERT INTO Subject(subj_seq, subj_name, prof_id, prof_name) 
VALUES(subj_seq,'python','prof_park');
INSERT INTO Subject(subj_seq, subj_name, prof_id,.prof_name) 
VALUES(subj_seq,'android','prof_park');
--------------------------------------------
SELECT * FROM Subject;
------------------------------------------------
ALTER TABLE Subject ADD COLUMN prof_id VARCHAR(30)
ALTER TABLE Subject ADD COLUMN prof_name VARCHAR(30);
-------------------------------------------------
ALTER TABLE Subject
ADD FOREIGN KEY(prof_id)
REFERENCES Admin(id)
------------------------------------
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
------------------------------------------

SELECT
	s.subj_seq AS subjSeq,
	s.subj_name AS subjName,
	s.prof_id AS profID,
	a.name AS profName
FROM Subject s, Admin a
WHERE s.prof_id = a.id;