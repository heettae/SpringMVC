package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySqlConnectTest {
	
	// mysql 디비 연결테스트 (톰캣 Stopped된 상태에서 테스트(
	
	// 디비 연결정보
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/jspdb?serverTimezone=Asia/Seoul"; // Timezone 에러시 작성하기
	private static final String DBID="root";
	private static final String DBPW="1234";
	
	
//	@Test
//	public void testConn() {
//		try {
//			// 1. 드라이버 로드 (메서드 내에서 가능)
//			Class.forName(DRIVER);
//			System.out.println(" 드라이버 로드 성공! ");
//			// 2. 디비 연결
//			Connection con = DriverManager.getConnection(DBURL,DBID,DBPW); // f2 눌러서 catch 선택하면 두번째 catch문이 생김
//			System.out.println(" 디비연결 성공 ");
//			System.out.println(con);
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	

	@Test
	public void testConn() throws Exception {
		
		// 1. 드라이버 로드 (메서드 내에서 가능)
		Class.forName(DRIVER); // f2 눌러서 add throws 
		System.out.println(" 드라이버 로드 성공! ");
		
		// try-with 구문 : 자동으로 자원해제 수행하는 구문
		//					AutoCloseable인터페이스를 구현한 객체들만 사용가능
		// 1.7이후 사용가능
		try(Connection con = DriverManager.getConnection(DBURL,DBID,DBPW)) {
			// 2. 디비 연결
			System.out.println(" 디비연결 성공 ");
			System.out.println(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
}
