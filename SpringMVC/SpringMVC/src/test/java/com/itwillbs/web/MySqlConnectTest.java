package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySqlConnectTest {

	// mysql 디비 연결테스트
	
	// 디비 연결정보
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String DBURL 
	    ="jdbc:mysql://localhost:3306/jspdb?serverTimezone=Asia/Seoul";
	private static final String DBID ="root";
	private static final String DBPW ="1234";
	
//	@Test
//	public void testConn() {
//		try {
//			// 1. 드라이버 로드
//			Class.forName(DRIVER);
//			System.out.println(" 드라이버 로드 성공! ");
//			// 2. 디비 연결
//			Connection con 
//			   = DriverManager.getConnection(DBURL, DBID, DBPW);
//			System.out.println(" 디비연결 성공! ");
//			System.out.println(con);
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	@Test
	public void testConn() throws Exception  {
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println(" 드라이버 로드 성공! ");
		
		// try-with구문 : 자동으로 자원해제 수행하는 구문
		//                AutoClosable인터페이스를 구현한 객체들만 사용가능
		//  1.7이후 사용가능
		try (Connection con = DriverManager.getConnection(DBURL, DBID, DBPW)) {
			// 2. 디비 연결
			System.out.println(" 디비연결 성공! ");
			System.out.println(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
//		finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}
	
	
	
}
