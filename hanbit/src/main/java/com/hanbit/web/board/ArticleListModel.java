package com.hanbit.web.board;

import java.util.Collections;
import java.util.List;
/**
 *@file : ArticleListModel.java
 *@author KimHeeTae
 *@date 2016. 4. 11.
 *@story : 게시글 목록(페이징 처리 기능)
 */
public class ArticleListModel {
	/**
	 * articleList - 화면에 보여줄 게시글 목록
	 * requestPage - 사용자가 요청한 페이지 번호
	 * totalPageCount - 전체 페이지 개수
	 * startRow - 현재 게시글 목록의 시작 행(전체 게시글 기준)
	 * endRow - 현재 게시글 목록의 끝 행(전체 게시글 기준)
	 * */
	private List<ArticleDTO> articleList;
	private int requestPage;
	private int totalPageCount;
	private int startRow;
	private int endRow;
	
	public ArticleListModel() {
		this(Collections.<ArticleDTO>emptyList(),0,0,0,0);
	}

	public ArticleListModel(List<ArticleDTO> articleList, int requestPage, int totalPageCount,
							int startRow, int endRow) {
		this.articleList = articleList;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public List<ArticleDTO> getArticleList() {
		return articleList;
	}
	
	public boolean isHasArticle() {
		return ! articleList.isEmpty();
	}

	public int getRequestPage() {
		return requestPage;
	}

	
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}
}
