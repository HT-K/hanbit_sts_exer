package com.hanbit.web.record;

import java.util.List;

import com.hanbit.web.global.Command;
import com.hanbit.web.grade.GradeDTO;

public interface RecordService {
	//public int insert(GradeDTO grade);
	public List<RecordDTO> getListAll(Command command);
	public List<RecordDTO> getByName(Command command);
	public List<RecordDTO> getById(Command command); // id 에 해당하는 모든 시험목록
	public List<RecordDTO> getByIdWithExamDate(Command command); // id와 시험 날짜로 찾는 시험
	public int count();
	public int update(RecordDTO record);
	//public int delete(GradeDTO grade);
}
