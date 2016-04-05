package com.hanbit.web.board;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.member.MemberDTO;

public interface BoardService {
	public BoardDTO getAdmin(BoardDTO admin);
	public int addScore(GradeDTO gradeBean); 
	public MemberDTO getMemUseId(String id);
	public MemberDTO getMemUseName(String name);
}
