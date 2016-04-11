package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.board.ArticleDTO;

@Repository
public interface ArticleMapper {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> selectList();
	public List<ArticleDTO> selectByName(String name);
	public ArticleDTO selectById(String id);
	public int count();
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
}
