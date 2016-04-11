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
CREATE TABLE Article (
	article_id INT NOT NULL AUTO_INCREMENT,
	group_id INT NOT NULL,
	sequence_no CHAR(16) NOT NULL,
	posting_date datetime NOT NULL,
	read_count INT NOT NULL,
	writer_name VARCHAR(20) NOT NULL,
	password VARCHAR(10),
	title VARCHAR(100),
	content TEXT,
	PRIMARY KEY(article_id),
	INDEX(sequence_no)
);
--------------------------------------------
SELECT * FROM Article;
-----------------------------------------
DROP TABLE Article CASCADE;
----------------------------------------