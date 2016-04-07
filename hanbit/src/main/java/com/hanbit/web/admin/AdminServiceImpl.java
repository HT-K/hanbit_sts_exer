package com.hanbit.web.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.member.MemberDTO;
@Service
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	private static AdminService service = new AdminServiceImpl();
	
	public static AdminService getService() {
		return service;
	}

	@Override
	public AdminDTO getAdmin(AdminDTO admin) { // 관리자 정보 가져오기
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int addScore(GradeDTO gradeBean) { // 학생 성적 입력하기
		return 0;
	}

	@Override
	public MemberDTO getMemUseId(String id) { // 아이디로 학생검색
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO getMemUseName(String name) { // 이름으로 학생 검색
		// TODO Auto-generated method stub
		return null;
	}
}
