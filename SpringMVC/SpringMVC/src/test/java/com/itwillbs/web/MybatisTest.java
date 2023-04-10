package com.itwillbs.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
		)
public class MybatisTest {
	
	// 1) 디비연결
	@Inject
	private DataSource ds;
	
	// 2) 디비연결,Mybatis 사용
	@Autowired
	private SqlSessionFactory factory;
	
	//@Test
	public void test_factory() {
		System.out.println("1. DataSource 객체 : "+ds);
		System.out.println("2. SqlSessionFactory 객체 : "+factory);	
	}
	
	//@Test
	public void test_conntection1() {
		try {
			// DS 디비연결
			Connection con = ds.getConnection();
			System.out.println(" 디비연결 성공! ");
			System.out.println(con);
			//PreparedStatement pstmt = con.prepareStatement(sql);
			
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
	}
	
	
	
	
	
	
	
	
	

	
	
	
}
