package com.hanbit.web.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.global.Command;
import com.hanbit.web.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	@Autowired SqlSession sqlSession; 
	
	@Override
	public int insert(ArticleDTO article) {
		logger.info("ArticleService - insert() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.insert(article);
	}

	@Override
	public List<ArticleDTO> getList(Command command) {
		logger.info("ArticleService - selectList() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectList(command);
	}

	@Override
	public List<ArticleDTO> getByName(String name) {
		logger.info("ArticleService - selectByName() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectByName(name);
	}

	@Override
	public ArticleDTO getById(String id) {
		logger.info("ArticleService - selectById() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectById(id);
	}

	@Override
	public int count() {
		logger.info("ArticleService - count() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.count();
	}

	@Override
	public int update(ArticleDTO article) {
		logger.info("ArticleService - update() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.update(article);
	}

	@Override
	public int delete(ArticleDTO article) {
		logger.info("ArticleService - delete() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.delete(article);
	}

	
}
