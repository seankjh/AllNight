package edu.spring.ex02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.MemberVO;
import edu.spring.ex02.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
)
@WebAppConfiguration
public class TestSelectByUserId {
	private static final Logger logger =
			LoggerFactory.getLogger(TestSelectByUserId.class);
	
	// DAO 클래스를 주입 받음
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testSelectByUserId() {
		MemberVO vo = dao.select("admin");
		logger.info("User ID: " + vo.getUserid());
		logger.info("User PW: " + vo.getPassword());
		logger.info("User Email: " + vo.getEmail());
	}
	
}








