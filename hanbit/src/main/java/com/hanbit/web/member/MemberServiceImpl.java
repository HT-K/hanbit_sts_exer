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
	public int insert(MemberDTO member) {
		// C 회원 가입(등록)
		logger.info("MemberServie - insert() 진입 후 ");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.insert(member);
	}
	
	@Override
	public MemberDTO login(MemberDTO member) {
		// R 회원 로그인
		logger.info("memberService-login() 진입 후 id = {}", member.getId());
		// MemberMapper.class -> MemberMapper 인터페이스를 class화 시켜라 (~~~.zip은 ~~~를 압축파일로 만들어라 라는 뜻이랑 비슷한 것으로 생각하자.)
		// MemberMapper.xml 은 MemberMapper 인터페이스를 매핑해서 해당 메소드들에 맞는 쿼리문을 실행해서 결과 값을 얻게 했다. MemberMapper 인터페이스를 매핑한 MemberMapper.xml의 정보를 sqlSession에 담게된다.
		// 이렇게 되면 MemberMapper 인터페이스를 매핑하여 구현한 객체를 리턴 받은 mapper은 해당 메소드를 호출하여 xml의 쿼리문 실행 결과 값을 받아올 수 있게된다.
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); // MemberMapper mapper = new MemberMapperImpl(); 이라고 생각하면 쉽다.
		MemberDTO temp = mapper.login(member);
		if (temp.getId().equals(member.getId())) { // 디비에서 가져온 회원 정보를 담은 temp의 id와 컨트롤러에서 가져온 member의 id를 비교해서 같을 경우 로그인 성공
			logger.info("memberService :login() 성공 후 id = {}", member.getId());
		} else {
			logger.info("memberService :login() 실패 ");
		}
		return temp; // 디비에서 가지고 온 temp를 컨트롤러에 보내준다.
	}
	
	@Override
	public List<MemberDTO> getListAll() {
		// R 모든 회원 리스트 검색
		// xml은 인터페이스를 매핑하고 있다. 서로 연결이 되어있는 상황, 연결한 인터페이스는 xml에서 구현한 것이라고 보면된다 (DAOImpl이라고 생각하면 쉽당)
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); // MemberMapper mapper = new MemberMapperImpl(); 이라고 생각하면 쉽다.
		return mapper.selectListAll();
	}
	
	@Override
	public MemberDTO getById(String id) {
		// R 아이디로 회원 정보 검색
		logger.info("memberService - getMemById() 진입");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); // MemberMapper mapper = new MemberMapperImpl(); 이라고 생각하면 쉽다.
		return mapper.selectById(id);
	}

	@Override
	public List<MemberDTO> getByName(MemberDTO member) {
		// R 이름으로 회원 정보 검색
		logger.info("memberService - getByName() 진입 ");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); // MemberMapper mapper = new MemberMapperImpl(); 이라고 생각하면 쉽다.
		return mapper.selectByName(member);
	}
	
	@Override
	public boolean isMember(String id) {
		// R 회원인지 아닌지 검사
		logger.info("MemberServie - isMember() 진입");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); // MemberMapper mapper = new MemberMapperImpl(); 이라고 생각하면 쉽다.
		MemberDTO member = mapper.selectById(id); // MemberMapper.xml 의 주소 값이 mapper에 들어있고 그 중 login이라는 id를 가진 곳의 요소 값을 가져와서 member에 담는 것~
		if (member.getId().equals(id)) { // 디비에서 가져온 member 객체의 id와 컨트롤러에서 받아온 id 값이 같으면 회원~
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int count() {
		// R 회원 수 조회
		logger.info("MemberServie - count() 진입");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}
	
	@Override
	public int update(MemberDTO member) {
		// U 회원 정보 업데이트
		logger.info("MemberServie - update() 진입");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.update(member);
	}

	@Override
	public int delete(MemberDTO member) {
		// D 회원 정보 삭제
		logger.info("MemberServie - remove() 진입");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.delete(member);
	}
}
