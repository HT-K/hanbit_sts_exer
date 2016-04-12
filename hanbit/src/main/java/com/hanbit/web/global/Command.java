package com.hanbit.web.global;

import org.springframework.stereotype.Component;

// directory와 action을 구분하는 팩토리 패턴을 지우고
// 페이징을 구하기 위해 커맨트 클래스를 커맨트 팩턴을 이용함! (팩토리 패턴 쓴건 백업되어있당)

@Component
public class Command {
	private int pageSize;
	private int groupSize;
	private int pageNo;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private int totalPages;
	private int count;
	private String pkg;
	private String command;
	private String keyField;
	private String keyword;
	private String view;
	
	public Command() {
		// TODO Auto-generated constructor stub
	}
	
	public Command(String pkg,String command, String strPageNO,
			String keyField,String keyword, int count) {
		this.pageSize = Constants.PAGESIZE;
		this.groupSize = Constants.GROUPSIZE;
		this.pkg = pkg;
		this.command = command;
		this.pageNo = Integer.parseInt(strPageNO);
		this.keyField = keyField;
		this.keyword = keyword;
		
		//총 글(count)이 16개고 한 페이지당 5개라면 총 페이지 수는 4여야한다.
		//총 글(count)이 15개고 한 페이지당 5개라면 총 페이지 수는 3이여야 한다.
		int nmg = count%pageSize;
		if (nmg  != 0) {
			totalPages = (count/pageSize)+1;
		} else {
			totalPages = count/pageSize;
		}
		
		// 페이지  시작 구하는 공식 같은거, ex) 총 16개글이 있고 pageSize=5이라고 가정하자.
		// pageNo가 3이면 (3-1)*5+1 = 11, 즉 11번째 게시글이 3페이지에 맨 위에 보이게 된다는 뜻!
		this.startRow = (pageNo - 1)*pageSize;
		
		//페이지 끝 구하는 공식, ex) pageNo가 3이고 pageSize가 5이면 3*5 = 15
		//즉, 3페이지에 맨 끝 글은 15번째 글이 된다는 뜻으로 startRow와 endRow를 합치면 11~15번째 게시글이 3페이지에 보이게 된다!
		this.endRow = pageNo * pageSize;
		
		this.startPage = pageNo - ((pageNo-1)%groupSize);
		int end = startPage + groupSize - 1;
		if (endPage > totalPages) {
			end = totalPages;
		}
		this.endPage = end;
		this.count = count;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getKeyField() {
		return keyField;
	}

	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getGroupSize() {
		return groupSize;
	}

	
}
