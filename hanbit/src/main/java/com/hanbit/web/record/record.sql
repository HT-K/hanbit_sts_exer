DROP VIEW Record CASCADE;
---------------------------------
SELECT * FROM Record;
-----------------------------------
-- view 생성 (모든 테이블에서 필요한 것만 추출해온다. (외래키들을 이용해서 원하는 값들을 가져오게 된다)
CREATE OR REPLACE VIEW Record -- REPLACE는 오버라이드 의미이다. (뷰의 장점), 추가 되는 컬럼이 있으면 적고 다시 CREATE VIEW를 해도 된다! (원래는 DROP하고 다시해야되지만 REPLACE가 붙어 있어서 가능하다!)
AS
SELECT
	g.score_seq AS seq, -- int
	g.id AS id, -- varchar
	m.name AS name, -- varchar
	s.subj_name AS subject, -- varchar
	g.score AS score, -- int
	g.exam_date AS exam_date, -- 나중에 추가 됨 , varchar
	s.prof_id AS prof_id,
	a.name AS prof_name
FROM Member m, Grade g, Subject s, Admin a
WHERE m.id = g.id AND g.subj_seq = s.subj_seq AND a.id = s.prof_id
------------------------------------------------

-------------------------------------------------
SELECT * FROM Record
WHERE id = 'kim' AND exam_date = '2016-03-31'
----------------------------------------------

----------------------------------------------------
-- id가 kim인 김유신 학생의 'java' 점수를 60점으로 바꾼다.
UPDATE Record SET score = 60
WHERE id = 'kim' AND exam_date = '2016-03-31' AND subject = 'java';
----------------------------------------------------

------------------------------------------------
-- GROUP BY and HAVING 예제
CREATE OR REPLACE VIEW Record
AS
SELECT
	g.score_seq AS seq, -- int
	g.id AS id, -- varchar
	m.name AS name, -- varchar
	s.subj_name AS subject, -- varchar
	g.score AS score, -- int
	g.exam_date AS exam_date -- 나중에 추가 됨 , varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND m.id = 'kim' AND g.subj_seq = s.subj_seq AND g.exam_date='2016-03-31'
GROUP BY s.subj_name -- 중복되는 것을 제거
HAVING score IS NOT NULL -- GROUP BY의 WHERE절
--------------------------------------------------

--------------------------------------------------
CREATE OR REPLACE VIEW Record
AS
SELECT
	g.score_seq AS seq, -- int
	g.id AS id, -- varchar
	m.name AS name, -- varchar
	s.subj_name AS subject, -- varchar
	g.score AS score, -- int
	g.exam_date AS exam_date -- 나중에 추가 됨 , varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND g.subj_seq = s.subj_seq
GROUP BY s.subj_name -- 중복되는 것을 제거 , 여기에 이걸 추가해버리면 모든 학생이 과목이름이 같으므로 단 한명의 성적만 뷰로 생성되게 된다. 이렇게 쓰면 안된다!
---------------------------------------------------

