package com.itwillbs.persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// @Repository : 스프링이 DAO 객체를 찾을때 해당 객체로 지정

@Repository
public class MemberDAOImpl implements MemberDAO{

	//디비 연결 + Mybatis 주입
	@Autowired
	private SqlSessionFactory factory;
	
	// 디비연결 + mybatis + 자원해제
	@Autowired
	private SqlSession sqlSession;
			
	
	// mapper-namespace를 상수로 설정
	private static final String NAMESPACE
	            ="com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getDbTime() {
		//SqlSession session = factory.openSession();
		//selet
		// session.selectOne(NAMESPACE + ".id");
		//String sdate = session.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		//String sdate = session.selectOne(NAMESPACE + ".getTime");
		
		String sdate 
		    = sqlSession.selectOne(NAMESPACE + ".getTime");
		
		System.out.println(" sdate : "+sdate);
		
		return sdate;
	}
	

}
