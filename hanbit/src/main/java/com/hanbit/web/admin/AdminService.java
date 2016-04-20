package com.hanbit.web.admin;

import java.util.List;

public interface AdminService {
	// R 관리자 리스트 출력
	public List<AdminDTO> getAdminList();
	// R 교수 조회(이름)
	public List<AdminDTO> getAdminByName(String name);
	// R 관리자 로그인
	public AdminDTO adminLogin(AdminDTO admin);
	// R 교수 조회(아이디)
	public AdminDTO getAdminById(String id);
	// R Admin 테이블 데이터 수 조회
	public int getAdminCount();
	// U 성적표 수정
	public int update(AdminDTO admin);
	// D 성적표 삭제
	public int delete(String id);
}
