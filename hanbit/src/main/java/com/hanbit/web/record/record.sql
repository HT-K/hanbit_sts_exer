DROP VIEW Record CASCADE;
---------------------------------
SELECT * FROM Record;
-----------------------------------
-- view 생성
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
WHERE m.id = g.id AND g.subj_seq = s.subj_seq;
------------------------------------------------