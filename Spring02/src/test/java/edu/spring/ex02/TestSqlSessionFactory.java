package edu.spring.ex02;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

// root-context.xml에 선언된 SqlSessionFactory 빈이 정상적으로 생성되는 지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class TestSqlSessionFactory {
	private static final Logger logger = LoggerFactory.getLogger(TestSqlSessionFactory.class);
	
	// sqlSessionFactory 빈을 주입받음
	// -> SqlSessionFactoryBean 객체가 주입됨
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() {
		logger.info("SqlSessionFactory: " + sessionFactory );
		// SqlSessionFactory를 이용해서
		// SqlSession 객체가 생성되는지 테스트
		SqlSession session = sessionFactory.openSession();
		logger.info("SqlSession: " + session );
	}
	
} // end class TestSqlSessionFactory
