package com.hanbit.web.board;

import java.util.List;

public interface ArticleService {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> selectList();
	public List<ArticleDTO> selectByName(String name);
	public ArticleDTO selectById(String id);
	public int count();
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
	
}
