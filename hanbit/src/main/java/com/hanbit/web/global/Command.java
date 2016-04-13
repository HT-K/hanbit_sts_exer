package com.hanbit.web.global;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

// directory와 action을 구분하는 팩토리 패턴을 지우고
// 페이징을 구하기 위해 커맨트 클래스를 커맨트 팩턴을 이용함! (팩토리 패턴 쓴건 백업되어있당)

@Component
public class Command {
	private int pageSize; // 게시판 하단에 보이는 페이징,(1 2 3 다음) 이런식
	private int articleSize; // 한 페이지당 보이게 될 게시글의 수
	private int pageNo; // 현재 페이지가 몇번째 페이지 인지
	private int startPage; // 현재 화면에 보이게 될 시작 페이지 번호
	private int endPage; // 현재 화면에 보이게 될 끝 페이지 번호
	private int startRow; // 현재 페이지 화면에 보이게 될 게시글 시작이 몇번 째인지
	private int endRow; // 현재 페이지 화면에 보이게 될 게시글 끝이 몇번 째인지
	private int totalPages; // 총 페이지 수, articleSize(페이지 당 게시글 수)를 이용해 결과적으로 총 몇 페이지로 구성될 지를 저장하는 변수
	private int totalArticle; // 총 게시글의 수
	private String pkg; // controller에 올 때 @RequestMapping("article")를 의미
	private String command; // controller의 메소드를 호출하게 하는 명령어 (@RequestMapping("/update"), 요런거!)
	private String keyField; // 검색 시 제목,이름,아이디 등 어떤 것을 이용해서 할지를 저장
	private String keyword; // 검색 할 내용
	private String view; // 뭐냐 넌
	
	public Command() {
		// TODO Auto-generated constructor stub
	}
	
	public Command(String pkg,String command, String strPageNO,
			String keyField,String keyword, int totalArticle) {
		this.pageSize = Constants.PAGESIZE;
		this.articleSize = Constants.ARTICLESIZE;
		this.pkg = pkg;
		this.command = command;
		this.pageNo = Integer.parseInt(strPageNO);
		this.keyField = keyField;
		this.keyword = keyword;
		
		//총 글(totalArticle)이 16개고 한 페이지당 5개라면 총 페이지 수는 4여야한다.
		//총 글(totalArticle)이 15개고 한 페이지당 5개라면 총 페이지 수는 3이여야 한다.
		int nmg = totalArticle%pageSize;
		if (nmg != 0) {
			this.totalPages = (totalArticle/pageSize)+1;
		} else {
			this.totalPages = totalArticle/pageSize;
		}
		
		
		// 페이지  시작 구하는 공식 같은거, ex) 총 16개글이 있고 pageSize=5이라고 가정하자.
		// pageNo가 3이면 (3-1)*5 = 10, 즉 데이버베이스의 11번째 게시글(데이터베이스 시작 글 인덱스가 0이다)이 3페이지에 맨 위에 보이게 된다는 뜻!
		this.startRow = (pageNo-1)*pageSize;

		
		//페이지 끝 구하는 공식, ex) pageNo(현재페이지 번호)가 3이고 pageSize가 5이면 3*5 = 15
		//즉, 3페이지에 맨 끝 글은 15번째 글이 된다는 뜻으로 startRow와 endRow를 합치면 11~15번째 게시글이 3페이지에 보이게 된다!
		//그러나 만약 글이 11개라면 마지막 페이지의 endRow는 11이 되어야한다. 즉 ,pageNo * pageSize 가 totalArticle(총 글 수)보다 크면 endRow를 총 글 수로 지정해줘야 마지막에 해당 수만큼 글이 해당 페이지에 들어간다!
		if (pageNo* pageSize > totalArticle) {
			this.endRow = totalArticle;
		} else {
			this.endRow = pageNo * pageSize;
		}
		
		// 현재 페이지에 보여지는 페이지 숫자 (1페이지 1이 보여진다.)
		this.startPage = pageNo - ((pageNo-1)%articleSize);
		
		// 현재 페이지에서 보여질
		int end = startPage + articleSize - 1;
		if (end > totalPages) {
			end = totalPages;
		}
		this.endPage = end;
		this.totalArticle = totalArticle; // 총 게시글이 몇개인지 저장되어있음
	} // 생성자 끝

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

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
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

	public int getArticleSize() {
		return articleSize;
	}

	
}
