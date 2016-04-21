-- 참조되는 테이블 쪽에서 한 행을 삭제하고 싶다면 ON DELETE CASCADE 를 적어줘야 Member 테이블에서 삭제가 가능하다.
-- DELETE FROM Member WHERE id = 'kim'; ===> 이게 가능해진다.

-----------------------------------------------------------
-- Grade 테이블 생성
CREATE TABLE Grade(
	 score_seq int PRIMARY KEY AUTO_INCREMENT,
	 id VARCHAR(30) NOT NULL,
	 subj_seq int,
	 score int, 
	 exam_date VARCHAR(30), -- 나중에 추가된 것
	 CONSTRAINT grader_member_fk FOREIGN KEY(id)
	 REFERENCES Member(id) ON DELETE CASCADE,
	 CONSTRAINT grader_subject_fk FOREIGN KEY(subj_seq)
	 REFERENCES Subject(subj_seq) ON DELETE CASCADE
);
-----------------------------------------------------------
------------------------------------------------------------------------------------
-- Grade 테이블에 exam_date 컬럼 추가
ALTER TABLE Grade ADD COLUMN exam_date VARCHAR(30); -- Grade 테이블에 exam_date 컬럼 추가
------------------------------------------------------------------------------------
-- grade 테이블에 값 넣기~
-- 홍길동의 3월 시험
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'hong', 1, 80, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'hong', 2, 90, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'hong', 3, 100, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'hong', 4, 70, '2016-03-31'); 

-- 김유신의 3월 시험
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'kim', 1, 50, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'kim', 2, 50, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'kim', 3, 50, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'kim', 4, 50, '2016-03-31'); 

-- 이순신의 3월 시험
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'lee', 1, 90, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'lee', 2, 90, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'lee', 3, 90, '2016-03-31'); 
INSERT INTO Grade(score_seq,id,subj_seq,score, exam_date)
VALUES (score_seq, 'lee', 4, 90, '2016-03-31');                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
------------------------------------------------------------

----------------------
-- Grade 테이블 조회
SELECT * FROM Grade;
----------------------

----------------------------
-- Grade 테이블 삭제
DROP TABLE Grade CASCADE;
----------------------------

-----------------------------------------
-- Grade 테이블 컬럼 이름 변경~
ALTER TABLE Grade RENAME hak TO examSeq;
-----------------------------------------