package com.hanbit.web.subject;

import java.util.List;

public interface SubjectService {
		public int insert(SubjectDTO subject);
		public List<SubjectDTO> getList();
		public List<SubjectDTO> getByName(String name);
		public SubjectDTO getById(String id);
		public int getCount();
		public int update(SubjectDTO subject);
		public int delete(SubjectDTO subject);
}
