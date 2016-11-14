package edu.spring.ex02;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

// root-context.xml에 선언된 SqlSession 빈 객체가 제대로 생성되는지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestSqlSession {
	private static final Logger logger = LoggerFactory.getLogger(TestSqlSession.class);
	
	@Autowired
	private SqlSession session;
	
	@Test
	public void testSqlSession() {
		logger.info("SqlSession: " + session);
		
	}
	
} // end class TestSqlSession
