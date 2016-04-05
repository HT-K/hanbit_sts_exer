package com.hanbit.web.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest {
	public static void main(String[] args) {
		Connection conn = null; // 지역변수니까 null로 초기화 해준다. , 지역변수는 스택에 들어가는데 스택의 메모리 공간에 이전에 썼던 데이터 값이 남아있다면 그 데이터는 지워지지 않고 남아있다. 그래서 초기화시켜줘야한다.
		Statement stmt = null;
		ResultSet rs = null; // 인터페이스로 객체 참조하려는 것 -> Deep Copy 방식

		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ID, Constants.PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Test");
			String sample = "";

			while (rs.next()) {
				sample = rs.getString("sample");
			}
			System.out.println("샘플 : " + sample);
		} catch (Exception e) {
			System.out.println("오라클 에러 발생");
			e.printStackTrace();
		}

	}
}
