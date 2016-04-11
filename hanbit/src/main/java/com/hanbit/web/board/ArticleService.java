package com.hanbit.web.board;

import java.util.List;

import com.hanbit.web.global.Command;

public interface ArticleService {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> getList(Command command);
	public List<ArticleDTO> getByName(String name);
	public ArticleDTO getById(String id);
	public int count();
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
	
}
