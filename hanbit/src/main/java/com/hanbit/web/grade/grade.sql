------------------------------------
CREATE TABLE Grade(
	 score_seq int PRIMARY KEY AUTO_INCREMENT,
	 id VARCHAR(30) NOT NULL,
	 subj_seq int,
	 score int, 
	 CONSTRAINT grader_member_fk FOREIGN KEY(id)
	 REFERENCES Member(id),
	 CONSTRAINT grader_subject_fk FOREIGN KEY(subj_seq)
	 REFERENCES Subject(subj_seq)
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
DROP TABLE Grade CASCADE CONSTRAINT;
-------------------
<!-- 가상 테이블인 뷰를 만들어  이름으로 검색할 수 있게 한다. -->
CREATE VIEW v_Grade_Member
AS SELECT g.id '아이디', m.name '이름', g.hak '학번'
FROM Grade g, Member m
WHERE g.id = m.id;
----------------------------
ALTER TABLE Grade RENAME hak TO examSeq;
-------------------------------