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
public class TestUpdate {
	private static final Logger logger =
			LoggerFactory.getLogger(TestUpdate.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testUpdate() {
		MemberVO vo = 
				new MemberVO(0, "aaa", "6666", "jake123@test.com");
		int result = dao.update(vo);
		logger.info("Update 결과: " + result);
	}
	
/*	@Test
	public void testUpdateEmail() {
		int result  = dao.update("aaa", "aaa@aaa.com");
		logger.info("Update 결과: " + result);
	}*/
	
}









