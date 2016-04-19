package com.hanbit.web.record;

import java.util.List;

import com.hanbit.web.global.Command;
import com.hanbit.web.grade.GradeDTO;

public interface RecordService {
	public int insert(GradeDTO grade);
	public List<RecordDTO> getList(RecordCommand command);
	public List<RecordDTO> getByName(RecordCommand command);
	public List<RecordDTO> getById(RecordCommand command); // id 에 해당하는 모든 시험목록
	public List<RecordDTO> getByIdWithExamDate(RecordCommand command); // id와 시험 날짜로 찾는 시험
	public int countAll();
	public int update(RecordDTO record);
	public int delete(String id);
}
