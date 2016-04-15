-- 참조되는 테이블 쪽에서 한 행을 삭제하고 싶다면 ON DELETE CASCADE 를 적어줘야 Member 테이블에서 삭제가 가능하다.
-- DELETE FROM Member WHERE id = 'kim'; ===> 이게 가능해진다.
------------------------------------
CREATE TABLE Grade(
	 score_seq int PRIMARY KEY AUTO_INCREMENT,
	 id VARCHAR(30) NOT NULL,
	 subj_seq int,
	 score int, 
	 CONSTRAINT grader_member_fk FOREIGN KEY(id)
	 REFERENCES Member(id) ON DELETE CASCADE,
	 CONSTRAINT grader_subject_fk FOREIGN KEY(subj_seq)
	 REFERENCES Subject(subj_seq) ON DELETE CASCADE
);


------------------------------------
<!-- 시퀀스명.NEXTVAL을 하면 시퀀스로 학번을 생성한다. -->
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq, 'hong', 1, 80); 
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq, 'hong', 2, 90); 
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq, 'hong', 3, 100); 
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq, 'hong', 4, 70); 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
---------------------------------
SELECT * FROM Grade;
---------------------------
DROP TABLE Grade CASCADE;
-------------------
<!-- 가상 테이블인 뷰를 만들어  이름으로 검색할 수 있게 한다. -->
CREATE VIEW v_Grade_Member
AS SELECT g.id '아이디', m.name '이름', g.hak '학번'
FROM Grade g, Member m
WHERE g.id = m.id;
----------------------------
ALTER TABLE Grade RENAME hak TO examSeq;
-----------------------------------------------------
-- 내가 생각한 grade 테이블
CREATE TABLE Grade(
	 score_seq int PRIMARY KEY AUTO_INCREMENT,
	 exam_date int NOT NULL,
	 exam_style VARCHAR(20) NOT NULL,
	 id VARCHAR(30) NOT NULL,
	 subj_seq int,
	 score int, 
	 CONSTRAINT grader_member_fk FOREIGN KEY(id)
	 REFERENCES Member(id) ON DELETE CASCADE,
	 CONSTRAINT grader_subject_fk FOREIGN KEY(subj_seq)
	 REFERENCES Subject(subj_seq) ON DELETE CASCADE
);

-- 성적 입력
INSERT INTO Grade(score_seq, exam_date, exam_style, id, subj_seq, score)
VALUES (score_seq, 150413, '중간', 'hong', 1, 80); 
INSERT INTO Grade(score_seq, exam_date, exam_style, id, subj_seq, score)
VALUES (score_seq, 150413, '기말', 'hong', 3, 50); 
INSERT INTO Grade(score_seq, exam_date, exam_style, id, subj_seq, score)
VALUES (score_seq, 150413, '중간', 'hong', 5, 30); 
INSERT INTO Grade(score_seq, exam_date, exam_style, id, subj_seq, score)
VALUES (score_seq, 150413, '중간', 'hong', 7, 100); 



-- 뷰로 성적 출력하기
CREATE OR REPLACE VIEW Grade_Res
AS 
SELECT 
	g.exam_date AS exam_date,
	g.exam_style AS exam_style,
 	g.id AS id,
	m.name AS name,
	s.subj_name AS subj_name,
	g.score AS score
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND g.subj_seq = s.subj_seq;

select * from Grade_Res

DROP VIEW Grade_Res CASCADE;
-----------------------------------------------------------