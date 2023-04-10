package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.cj.xdevapi.PreparableStatement;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MybatisTest {
	

	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	// 1) 디비연결
	@Inject
	private DataSource ds;
	
	// 2) 디비연결, Mybatis 사용
	@Autowired
	private SqlSessionFactory factory;
	
	//@Test
	public void test_factory() {
		System.out.println(" 1. DataSource 객체 : "+ds);
		System.out.println(" 2. SqlSessionFactory 객체 : "+factory);
	}
	
	//@Test
	public void test_conntection1() {
		// DS 디비 연결
		try {
			Connection con = ds.getConnection();
			System.out.println(" 디비연결 성공! ");
			System.out.println(con);
			//PreparableStatement pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test_conntection2() {
		// factory 디비연결
		SqlSession session = factory.openSession();
		System.out.println(" 디비연결 성공! ");
		System.out.println(session);
		//session.selectOne(statement);
		logger.debug("출력~~~~~~~~~~~!");
		// ld 명령어 출력문 호출
		logger.debug("히히");
	}
}
