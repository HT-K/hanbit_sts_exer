package com.hanbit.web.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.mapper.AdminMapper;
import com.hanbit.web.mapper.GradeMapper;
import com.hanbit.web.member.MemberDTO;
@Service
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	@Autowired SqlSession session;
	
	@Override
	public List<AdminDTO> getListAll() {
		logger.info("AdminService - getListAll() 진입");
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		return mapper.selectListAll();
	}
	
	@Override
	public List<AdminDTO> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AdminDTO login(AdminDTO admin) {
		logger.info("AdminService - adminLogin() 진입");
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		return mapper.login(admin);
	}
	
	@Override
	public AdminDTO getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int update(AdminDTO admin) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
