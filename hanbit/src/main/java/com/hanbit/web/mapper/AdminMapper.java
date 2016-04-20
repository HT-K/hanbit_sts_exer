package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.admin.AdminDTO;
import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.member.MemberDTO;

@Repository
public interface AdminMapper {
		// R 관리자 리스트 출력
		public List<AdminDTO> selectAdminList();
		// R 교수 조회(이름)
		public List<AdminDTO> selectAdminByName(String name);
		// R 관리자 로그인
		public AdminDTO adminLogin(AdminDTO admin);
		// R 교수 조회(아이디)
		public AdminDTO selectAdminById(String id);
		// R Admin 테이블 데이터 수 조회
		public int selectAdminCount();
		// U 성적표 수정
		public int update(AdminDTO admin);
		// D 성적표 삭제
		public int delete(String id);
}
