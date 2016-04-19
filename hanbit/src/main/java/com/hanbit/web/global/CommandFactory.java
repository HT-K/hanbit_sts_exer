package com.hanbit.web.global;

public class CommandFactory {
	
	public static Command createCommand(String pkg,String crud,
			String pageNo,String keyField,String keyword,int count) {
		Command command = null;
		
		switch (crud) {
		case "list":
			command = new ListCommand(pkg, crud, pageNo, keyField, keyword, count);
			break;

		default:
			break;
		}		
		return command;
	}
}
