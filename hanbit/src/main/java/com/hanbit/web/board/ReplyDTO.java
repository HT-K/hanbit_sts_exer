package com.hanbit.web.board;

import org.springframework.stereotype.Component;

@Component
public class ReplyDTO {
	private int reply_seq;
	private int articleId;
	private String reply_content;
	
	public ReplyDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ReplyDTO(int articleId, String reply_content) {
		this.articleId = articleId;
		this.reply_content = reply_content;
	}
	
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	
	
}
