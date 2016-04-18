package com.hanbit.web.record;

import java.util.List;

public interface RecordService {
	public int insert(RecordDTO record);
	public List<RecordDTO> getList();
	public List<RecordDTO> getByName(String name);
	public RecordDTO getById(int id);
	public int countAll();
	public int update(RecordDTO record);
	public int delete(int id);
}
