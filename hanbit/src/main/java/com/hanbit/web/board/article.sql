CREATE TABLE id_sequence (
	sequence_name VARCHAR(10) NOT NULL,
	next_value INT NOT NULL,
	PRIMARY KEY(sequence_name)
);
---------------------------------------------
SELECT * FROM id_sequence;
-------------------------------------------------
DROP TABLE id_sequence CASCADE;
-----------------------------------------------
INSERT INTO id_sequence
VALUES('article', 0);

-----------------------------------------------
-- Article 테이블 생성 
CREATE TABLE Article (
	article_id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100),
	writer_name VARCHAR(20) NOT NULL,
	password VARCHAR(10),
	content TEXT,
	posting_date datetime NOT NULL,
	read_count INT NOT NULL
);
-----------------------------------------------

------------------------
-- Article 테이블 조회
SELECT * FROM Article;
------------------------
----------------------------
-- Article 테이블 삭제
DROP TABLE Article CASCADE;
----------------------------

-------------------------------------
-- article_id를 기준으로 조회
SELECT  article_id AS articleId, 
		posting_date AS postingDate,
		read_count AS readCount,
		writer_name AS writerName,
		password,
		title,
		content
		FROM Article
		ORDER BY article_id DESC;
----------------------------------------


