package com.hanbit.web.global;

/**
 * @Constants.java
 * @author KimHeeTae
 * 2016. 3. 17.
 * @story : 무슨 데이터베이스를 쓸지 모른다. 데이터베이스가 무엇인지 모르므로 아래와 같이 써두는 것이 좋다.
 */
public class Constants {
	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/rainbow";

	public static final String MSSQL_DRIVER = "";
	public static final String MSSQL_URL = "";
	
	public static final String ID = "rainbow";
	public static final String PASSWORD = "rainbow";
	
	public static final String VIEWS = "/WEB-INF/views/";
	public static final String EXT = ".jsp";
}
