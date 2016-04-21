package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.board.ArticleDTO;
import com.hanbit.web.board.ReplyDTO;
import com.hanbit.web.global.Command;

@Repository
public interface ArticleMapper {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> selectListAll(Command command);
	public List<ArticleDTO> selectBySearch(Command command);
	public ArticleDTO selectById(int articleId);
	public int countAll();
	public int countBySearch(Command command);
	public int update(ArticleDTO article);
	public int delete(int articleId);
	
	public int replyInsert(ReplyDTO reply);
	public List<ReplyDTO> selectReplyAll(int articleId);
}
