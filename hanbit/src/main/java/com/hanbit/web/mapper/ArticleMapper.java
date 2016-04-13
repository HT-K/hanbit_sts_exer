package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.board.ArticleDTO;
import com.hanbit.web.global.Command;

@Repository
public interface ArticleMapper {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> selectList(Command command);
	public List<ArticleDTO> selectBySearch(Command command);
	public ArticleDTO selectById(String id);
	public int countAll();
	public int countBySearch(Command command);
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
}
