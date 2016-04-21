-------------------------------------------------------
-- reply 테이블 생성
CREATE TABLE Reply(
	reply_seq int PRIMARY KEY AUTO_INCREMENT,
	article_id int NOT NULL,
	writer_name VARCHAR(20) NOT NULL,
	reg_time datetime NOT NULL,
	reply_content TEXT,
	CONSTRAINT reply_article_fk FOREIGN KEY(article_id)
	REFERENCES Article(article_id) ON DELETE CASCADE
);

DROP TABLE Reply CASCADE;