package com.hanbit.web.record;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.admin.AdminController;

@Controller
@RequestMapping("/record")
public class RecordController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping("/insert")
	public String insert(){
		
		return "";
	}
	
	@RequestMapping("/getList")
	public String getList(){
		
		return "";
	}
	
	@RequestMapping("/getByName")
	public String getByName(){
		
		return "";
	}
	
	@RequestMapping("/getById")
	public String getById(){
		
		return "";
	}
	
	@RequestMapping("/count")
	public String count(){
		
		return "";
	}
	
	@RequestMapping("/update")
	public String update(){
		
		return "";
	}
	
	@RequestMapping("/delete")
	public String delete(){
		
		return "";
	}
}
