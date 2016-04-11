package com.hanbit.web.global;

// directory와 action을 구분하는 팩토리 패턴을 지우고
// 페이징을 구하기 위해 커맨트 클래스를 커맨트 팩턴을 이용함! (팩토리 패턴 쓴건 백업되어있당)
public class Command implements Orderable{
	private int pageSize;
	private int pageNo;
	private int start;
	private int end;
	private String keyword;
	private String keyField;
	private String command;
	private String view;
	
	public Command(String command, String pageNo, String keyField, String keyword) {
		this.pageSize = Constants.PAGESIZE;
		this.command = command;
		this.pageNo = Integer.parseInt(pageNo);
		this.keyField = keyField;
		this.keyword = keyword;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getKeyField() {
		return keyField;
	}

	public String getCommand() {
		return command;
	}

	public String getView() {
		return view;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setStart(int pageNo, int pageSize) {
		// 페이지  시작 구하는 공식 같은거, ex) 총 16개글이 있고 pageSize=5이라고 가정하자.
		// pageNo가 3이면 (3-1)*5+1 = 11, 즉 11번째 게시글이 3페이지에 맨 위에 보이게 된다는 뜻!
		this.start = (pageNo-1)*pageSize+1; 
	}

	public void setEnd(int pageNo) {
		//페이지 끝 구하는 공식, ex) pageNo가 3이고 pageSize가 5이면 3*5 = 15
		//즉, 3페이지에 맨 끝 글은 15번째 글이 된다는 뜻으로 start와 end를 합치면 11~15번째 게시글이 3페이지에 보이게 된다!
		this.end = pageNo*pageSize;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
