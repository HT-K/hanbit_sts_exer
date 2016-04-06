package com.hanbit.web.mapper;

import org.springframework.stereotype.Repository;

import com.hanbit.web.admin.AdminDTO;
import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.member.MemberDTO;

@Repository
public interface AdminMapper {
	public AdminDTO selectAdmin(AdminDTO admin); // 관리자 정보를 가져온다.
	public int insertScore(GradeDTO gradeBean); 
	public MemberDTO selectMemID(String id); // ID를 이용해서 학생 검색
	public MemberDTO selectMemName(String name); //이름을 이용해서 학생 검색
}
