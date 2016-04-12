package com.hanbit.web.global;

public class CommandFactory {
	
	public static Command createCommand(String pkg,String crud,
			String pageNo,String keyField,String keyword,int count) {
		Command command = null;
		if (crud.equals("list")) {
			//command = new PagingCommand(pkg, crud, pageNo, keyField, keyword);
			command = new Command(pkg, crud, pageNo, keyField, keyword, count);
		}
		
		
		return command;
	}
}
