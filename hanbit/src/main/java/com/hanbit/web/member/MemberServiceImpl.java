package com.hanbit.web.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.MemberMapper;

// @Service 어노테이션의 역할 : 이 클래스가 service 기능을 하는 클래스라고 인식을 하고 MemberService를 구현한 클래스라는 정보를 알게 된다. 자동으로 MemberService service = new MemberServiceImpl(); 이 root-context.xml에 저장된다.
@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	// mybatis-context.xml에서 bean 객체로 만들어 놓은 SqlSession 클래스의 객체를 가져온다. (싱글톤 패턴), 이미 bean으로 만든 sqlSessionFactory를 이용해 sqlSession 객체를 가져온다.
	// SqlSession session = sqlSessionFactory.openSession(); 이 자동으로 생성되어 있는데 이것을 @Autowired 를 이용해 가져오는 것이다.
	@Autowired SqlSession sqlSession; 
	@Autowired MemberDTO member; // 이렇게 싱글톤 패턴으로 써도 되고 지역 변수로 선언해서 사용해도 된다. 둘다 메모리 점유율을 낮추는 방법이기 때문이다.
	
	@Override
	public List<MemberDTO> getMemList() {
		// 모든 회원 리스트
		List<MemberDTO> list = new ArrayList<MemberDTO>(); // 리턴 값을 받은 것이 있으면 해당 변수는 지역 변수로 만들어서 사용한다.
		return null;
	}
	
	@Override
	public MemberDTO login(MemberDTO member) {
		// 로그인
		logger.info("memberService-login() 진입 후 id = {}", member.getId());
		// MemberMapper.class -> MemberMapper 인터페이스를 class화 시켜라 (~~~.zip은 ~~~를 압축파일로 만들어라 라는 뜻이랑 비슷한 것으로 생각하자.)
		// MemberMapper 인터페이스는 MemberMapper.xml를 매핑했다.
		// MemberMapper.xml 은 MemberMapper 인터페이스를 매핑해서 해당 메소드들에 맞는 쿼리문을 실행해서 결과 값을 얻게 했다. MemberMapper 인터페이스를 매핑한 MemberMapper.xml의 정보를 session에 담게된다.
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); // MemberMapper mapper = new MemberMapperImpl(); 이라고 생각하면 쉽다.
		
		member = mapper.login(member); // MemberMapper.xml 의 주소 값이 mapper에 들어있고 그 중 login이라는 id를 가진 곳의 요소 값을 가져와서 member에 담는 것~
		if (member != null) {
			logger.info("memberService :login() 성공 후 id = {}", member.getId());
			return member;
		} else {
			logger.info("memberService :login() 실패 ", "널 반환");
			return null; // 해당 id와 password를 가진 사용자의 모든 정보를 담은 MemberDTO를 리턴한다.
		}
	}
	
	@Override
	public MemberDTO detail(MemberDTO member) {
		// 내 정보보기
		return null; // MemberDAOImpl 클래스에 구현한 selectMember 메소드를 호출하여 데이터베이스에서 MemberBean 객체에 내용을 넣어서 받아온다.
	}
	
	@Override
	public boolean isMember(MemberDTO member) {
		// 회원인지 아닌지 검사
		return false;
	}
		
	@Override
	public int join(MemberDTO member) {
		// 회원가입
		return 0; // 입력받은 회원양식의 값들을 MemberBean 객체인 member에 set 한 후 이곳으로 가져와서 다시 dao에 넘긴다.
	}
	

	@Override
	public int update(MemberDTO member) {
		// 수정
		logger.info("MemberServie - update() 진입 후 ");
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		int res = mapper.update(member);
		
		if (res != 1) {
			logger.info("MemberServie - update() 실패");
		} else {
			logger.info("MemberServie - update() 성공");
		}
		return res;
	}

	@Override
	public int remove(MemberDTO member) {
		// 삭제
		return 0;
	}

}
