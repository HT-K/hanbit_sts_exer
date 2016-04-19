package com.hanbit.web.record;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hanbit.web.global.Command;

@Component
@Qualifier("recordCommand") // Command를 상속받아서 원래는 @Component를 여기서 쓸 수 없는데 따로 @Qualifier을 써서 이름을 설정해주면 별개의 것으로 인식하게 한다.
public class RecordCommand extends Command{
	// 페이징에 필요한 클래스인 Command를 상속받고, 거기에 Record에서 필요한 id와 examDate 변수를 추가
	private String id;
	private String name;
	private String examDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
}
