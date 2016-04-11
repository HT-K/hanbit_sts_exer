package com.hanbit.web.global;

public class CommandFactory {
	
	public static Command createCommand(String pkg, String crud, 
			String pageNo, String keyField, String keyword) {
		Command command = new Command();
		if (crud.equals("list")) {
			//command = new PagingCommand(pkg, crud, pageNo, keyField, keyword);
			command = new Command(pkg, crud, pageNo, keyField, keyword);
		}
		return command;
	}
}
