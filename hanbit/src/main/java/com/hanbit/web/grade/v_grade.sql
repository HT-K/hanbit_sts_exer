<!-- 가상 테이블인 뷰를 만들어  이름으로 검색할 수 있게 한다. -->
<!-- Member 테이블과 Grade 테이블을 조인하여 가상 뷰에 합친 모습을 보이게 한다. -->
<!-- Member 테이블과 Grade 테이블의 id 컬럼의 이름이 같으므로 둘 중 하나만 SELECT에 적어줘야한다. -->
CREATE OR REPLACE VIEW v_Member_Grade
AS 
SELECT 
	g.score_seq AS score_seq,
 	g.id AS id,
	m.name AS name,
	s.subj_name AS subject,
	g.score AS score
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND g.subj_seq = s.subj_seq;
-----------------------------------------------------
SELECT * FROM v_Member_Grade;
-----------------------------------------------------
SELECT * FROM v_Member_Grade
WHERE id = 'hong';
-----------------------------------------------------
DROP VIEW v_Member_Grade CASCADE; <!-- 뷰 제거 명령어 -->
-----------------------------------------------------
SELECT COUNT(*) AS count -- 열의 수 구하는 방법, 결과 값을 count 컬럼에다 바로 넣는다.(int 값으로 들어간다) 
FROM v_Member_Grade;


-----------------------------------------------------
-- ANSI JOIN(Natural JOIN)
SELECT 
	g.score_seq AS score_seq,
 	g.id AS id,
	m.name AS name,
	s.subj_name AS subject,
	g.score AS score
FROM Member m NATURAL JOIN Grade g NATURAL JOIN Subject s

-- ANSI JOIN(USING)
SELECT 
	g.score_seq AS score_seq,
 	g.id AS id,
	m.name AS name,
	s.subj_name AS subject,
	g.score AS score
FROM Member m JOIN Grade g USING(id)
JOIN Subject s USING(subj_seq)
