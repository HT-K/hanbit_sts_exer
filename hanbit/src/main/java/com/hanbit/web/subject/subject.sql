-- 오라클 시퀀스 생성과 Mysql 시퀀스 생성은 다르다.
CREATE TABLE Subject (
	subj_seq int PRIMARY KEY AUTO_INCREMENT,
	subj_name VARCHAR(30)
);

DROP TABLE Subject;

-- subj_seq, subj_name는 생략이 가능하지만 가능하면 써주고 안쓰면 VALUES에서 컬럼 수만큼 타입도 정확히 값을 넣어야한다.
INSERT INTO Subject(subj_seq, subj_name) 
VALUES('java');
INSERT INTO Subject(subj_seq, subj_name) 
VALUES('jsp');
INSERT INTO Subject(subj_seq, subj_name) 
VALUES('spring');
INSERT INTO Subject(subj_seq, subj_name) 
VALUES('sql');

SELECT * FROM Subject;