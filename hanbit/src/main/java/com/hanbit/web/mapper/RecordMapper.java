package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.record.RecordDTO;

@Repository
public interface RecordMapper {
	public int insert(RecordDTO record);
	public List<RecordDTO> selectList();
	public List<RecordDTO> selectByName(String name);
	public RecordDTO selectById(int id);
	public int countAll();
	public int update(RecordDTO record);
	public int delete(int id);
}
