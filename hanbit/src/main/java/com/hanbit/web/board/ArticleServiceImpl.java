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
	public List<ArticleDTO> getBySearch(Command command) {
		logger.info("ArticleService - selectByName() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectBySearch(command);
	}

	@Override
	public ArticleDTO getById(int articleId) {
		logger.info("ArticleService - selectById() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectById(articleId);
	}

	@Override
	public int countAll() {
		logger.info("ArticleService - countAll() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.countAll();
	}
	
	@Override
	public int countBySearch(Command command) {
		logger.info("ArticleService - countBySearch() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.countBySearch(command);
	}

	@Override
	public int update(ArticleDTO article) {
		logger.info("ArticleService - update() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.update(article);
	}

	@Override
	public int delete(int articleId) {
		logger.info("ArticleService - delete() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.delete(articleId);
	}

	@Override
	public int replyInsert(ReplyDTO reply) {
		logger.info("ArticleService - replyInsert() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.replyInsert(reply);
	}

	@Override
	public List<ReplyDTO> getReply(int articleId) {
		logger.info("ArticleService - getReply() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.getReply(articleId);
	}	
}
