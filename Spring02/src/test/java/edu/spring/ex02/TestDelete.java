package edu.spring.ex02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
)
@WebAppConfiguration
public class TestDelete {
	private static final Logger logger =
			LoggerFactory.getLogger(TestDelete.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testDelete() {
		int result = dao.delete("jake");
		logger.info("Delete 결과: " + result);
	}
	
}















