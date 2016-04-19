package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.record.RecordCommand;
import com.hanbit.web.record.RecordDTO;

@Repository
public interface RecordMapper {
	public int insert(RecordDTO record);
	public List<RecordDTO> selectList(RecordCommand command);
	public List<RecordDTO> selectByName(RecordCommand command);
	public List<RecordDTO> selectById(RecordCommand command);
	public List<RecordDTO> selectByIdWithExamDate(RecordCommand command); // id와 시험 날짜로 찾는 시험
	public int countAll();
	public int update(RecordDTO record);
	public int delete(String id);
}
