package com.hanbit.web.board;

import org.springframework.stereotype.Component;

@Component
public class ArticleDTO{
	private int articleId;
	private String title;
	private String writerName;
	private String password;
	private String content;
	private String postingDate;
	private int readCount;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
	
	/*// sequenceNo를 이용해서 게시글의 중첩레벨을 구한다.
	public int getLevel() {
		if (sequenceNo == null) {
			return -1;
		}
		if (sequenceNo.length() != 16) {
			return -1;
		}
		if (sequenceNo.endsWith("999999")) {
			return 0;
		}
		if (sequenceNo.endsWith("9999")) {
			return 1;
		}
		if (sequenceNo.endsWith("99")) {
			return 2;
		}
		return 3;
	}*/
}
