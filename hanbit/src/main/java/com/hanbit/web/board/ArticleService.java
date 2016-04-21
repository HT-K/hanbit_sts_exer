package com.hanbit.web.board;

import java.util.List;

import com.hanbit.web.global.Command;

public interface ArticleService {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> getListAll(Command command);
	public List<ArticleDTO> getBySearch(Command command);
	public ArticleDTO getById(int articleId);
	public int countAll();
	public int countBySearch(Command command);
	public int update(ArticleDTO article);
	public int delete(int articleId);
	
	public int replyInsert(ReplyDTO reply);
	public List<ReplyDTO> getReplyAll(int articleId);
	
}
