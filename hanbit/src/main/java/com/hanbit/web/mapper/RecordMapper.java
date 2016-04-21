package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.global.Command;
import com.hanbit.web.record.RecordDTO;

@Repository
public interface RecordMapper {
	//public int insert(GradeDTO grade);
	public List<RecordDTO> selectListAll(Command command);
	public List<RecordDTO> selectByName(Command command);
	public List<RecordDTO> selectById(Command command);
	public List<RecordDTO> selectByIdWithExamDate(Command command); // id와 시험 날짜로 찾는 시험
	public int count();
	public int update(RecordDTO record);
	//public int delete(GradeDTO grade);
}
