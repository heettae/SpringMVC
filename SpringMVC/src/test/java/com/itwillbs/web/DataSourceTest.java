package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 디비연결 테스트 클래스 (DataSource객체)
//@RunWith(SpringJUnit4ClassRunner.class)
// -> 해당 클래스는 SpringJUnit4 사용하겠다.
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
// -> 필요한 프로젝트 설정파일
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {

	// 디비연결정보 => 객체( bean ) 생성
	// DataSource ds = new DriverManagerDataSource();
	// => 직접 생성(강한결합)
	
	// 디비 연결 정보객체가 필요하다. <-> 디비 연결 정보객체와 의존 관계이다.
	// => 의존 주입 가능
	
	// @Inject / @Autowired 둘 다 사용 가능
	@Autowired
	@Qualifier("ds1")
	private DataSource ds;
	
	//@Test // 어노테이션 없을 경우 실행 불가. 한번에 하나의 동작만 실행할 수 있도록 함
	public void 객체주입_테스트() {
		System.out.println("1. 객체정보 : "+ds);
		// 출력화면 - 객체정보 : org.springframework.jdbc.datasource.DriverManagerDataSource@533b266e
		// @Inject 지울경우 객체정보 : null로 출력됨
	}
	
	@Test
	public void testConnection() {
		try {
			Connection con = ds.getConnection();
			System.out.println("2. 디비 연결정보 : "+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
