package com.hanbit.web.global;

public class Command {
	private String directory, action, view;
	
	public Command(String directory, String action) {
		this.directory = directory;
		this.action = action;
		this.view = Constants.VIEWS + "/" + directory + "/" + action + ".jsp";
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getView() {
		return view;
	}

	public void setView(String directory, String action) { // 이동 할 페이지 내용을 지정하는 함수다.
		this.view = Constants.VIEWS + "/" + directory + "/" + action + ".jsp";
	}
}
/**
 * URL : http://localhost:9000/school/member/login_form.do
 * 컨텍스트 패스 : http://localhost:9000/school/
 * WebContent : / (/school 다음의 /(슬래쉬)이거 하나가 WebContent를 뜻한다.)
 * URI(get방식) : member/login_form.do?id=hong&password=1
 * URI(post방식) : member/login_form.do
 * 쿼리스트링 구분자 : ?
 * 파라미터 구분자 : &
 * 쿼리스트링 : id=hong&password=1
 * 
 * URI는 프로젝트 내부에서 유일한 값(ID) (URI의 I는 ID 즉 유일한 값을 뜻한다.)
 * 이 URI를 분해해서 서블릿에게 명령을 내리는 구조로 이뤄진다.
 * 
 * URI 쪼개기 (member/login_form.do?id=hong&password=1) , 구분자 즉 / . ? & 기호들을 기준으로 나눌 수 있다.
 * member => folder => directory
 * login_form => action
 * do
 * id=hong => param
 */