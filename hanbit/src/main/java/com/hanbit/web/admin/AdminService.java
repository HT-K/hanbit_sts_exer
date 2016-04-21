package com.hanbit.web.admin;

import java.util.List;

public interface AdminService {
	// R 관리자 리스트 출력
	public List<AdminDTO> getListAll();
	// R 관리자 조회(이름)
	public List<AdminDTO> getByName(String name);
	// R 관리자 로그인
	public AdminDTO login(AdminDTO admin);
	// R 관리자 조회(아이디)
	public AdminDTO getById(String id);
	// R Admin 테이블 데이터 수 조회
	public int count();
	// U 해당 관리자 정보 수정
	public int update(AdminDTO admin);
	// D 해당 관리자 정보 삭제
	public int delete(String id);
}
