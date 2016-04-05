package com.hanbit.web.global;

public class DatabaseFactory { // new , 객체를 생성하는 new 키워드를 은닉화 하기 위한 팩토리 패턴 기법이다.
	public static DatabaseService getDatabase(Vendor vendor, String id, String password) { // 팩토리 패턴에서 객체를 생성하는 메소드는 static으로 해줘야 한다(어디서든지 접근이 가능하게 하기 위함)
		String driver = null, url = null;
		
		switch (vendor) {
		case ORACLE:
				driver = Constants.ORACLE_DRIVER;
				url = Constants.ORACLE_URL;
			break;
		case MYSQL:	
			break;
		case MSSQL:
			break;

		default:
			break;
		}
		return new DatabaseServiceImpl(driver, url, id, password);
	}
}
