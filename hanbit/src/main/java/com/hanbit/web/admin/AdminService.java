package com.hanbit.web.admin;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.member.MemberDTO;

public interface AdminService {
	public AdminDTO getAdmin(AdminDTO admin);
	public int addScore(GradeDTO gradeBean); 
	public MemberDTO getMemUseId(String id);
	public MemberDTO getMemUseName(String name);
}
