package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class GradeServiceImpl implements GradeService{
	// 멤버 필드 (속성을 모아놓은 부분) 
	GradeDTO grade;
	ArrayList<MemberGradeDTO>  gradeList; // 메소드들이 공유를 해야해서 멤버 필드 영역에 선언해야 한다. (인스턴스 변수라 한다) , 인스턴스 변수 멤버 필드 영역에서 초기화를 하지 않는다. 따라서 아래 생성자와 같이 메소드에서 초기화해주는게 좋다!
	
	private static GradeService instance = new GradeServiceImpl(); // 싱글톤 패턴을 사용하여 하나의 객체로 사용할 수 있도록 만듦
	
	
	/*GradeDAO dao = new GradeDAOImpl(); // 싱글톤 패턴 적용 전에는 이런방식으로 사용하였음*/	
	
	public static GradeService getInstance() { // 이 GradeServiceImpl 클래스가 필요한 곳에서 이 static메소드를 호출하면 이미 생성된 하나의 서비스임플객체를가지고 모든 곳에서 쓸 수 있다.
		return instance;
	}

	public GradeServiceImpl() {
		gradeList = new ArrayList<MemberGradeDTO>(); // 초기화
	}
	
	// 멤버 메소드 에어리어
	@Override
	public void input(GradeDTO gradeBean) { // gradeBean -> 지역변수의 일종으로 매개변수 혹은 파라미터라고 부름
		// C 성적표 등록
		return;
		//gradeList.add(gradeBean);
	}

	@Override
	public List<GradeDTO> getList() { // 서비스에서 syso를 하는게 아니라 Controller로 gradeList를 던져주면 된다!
		// R 성적표 리스트 출력
		return null;
	}

	@Override
	public MemberGradeDTO getGradeByHak(int hak) {
		// R 성적표 조회(학번)
		return null;
	}

	@Override
	public ArrayList<MemberGradeDTO> getGradesByName(String name) {
		// R 성적표 조회(아이디)

		return null;

	}
	
	@Override
	public GradeDTO getGradesById(String id) {
		return null;
	}

	@Override
	public int getCount() {
		// R 카운트 조회
		return 0;
	}

	@Override
	public String update(GradeDTO grade) {
		// U 성적표 수정
		return "수정실패";
	}

	@Override
	public String delete(int hak) {
		// D 성적표 삭제
		return "삭제실패";
	}
}