package com.hanbit.web.global;

import com.hanbit.web.record.RecordCommand;

public class CommandFactory {
	
	public static Command createCommand(String pkg,String crud,
			String pageNo,String keyField,String keyword,int count) {
		Command command = null;
		switch (crud) {
		case "article_list":
			command = new ListCommand(pkg, crud, pageNo, keyField, keyword, count);
			break;
		case "record_list":
			command = new Command(pkg, crud, pageNo, keyField, keyword, count);
			break;
		default:
			break;
		}		
		return command;
	}
}
