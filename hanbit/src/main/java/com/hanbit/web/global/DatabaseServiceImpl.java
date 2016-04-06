package com.hanbit.web.global;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;

public class DatabaseServiceImpl implements DatabaseService {
	private String driver, url, id, password;
	private Connection conn;
	
	public DatabaseServiceImpl(String driver, String url, String id, String password) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.password = password;
	}
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
		return conn;
	}

}
