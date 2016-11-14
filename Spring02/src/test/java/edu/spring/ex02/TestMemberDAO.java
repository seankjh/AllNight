package edu.spring.ex02;

import java.util.List;

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
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class TestMemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(TestMemberDAO.class);
	
	@Autowired // 주입을 하려면 root-context에 bean을 만들어야한다.
	private MemberDAO dao;
	
	@Test
	public void insertTest() {
		MemberVO vo = new MemberVO(0, "Dean", "0218", "dean@spring.io");
		int result = dao.insert(vo);
		logger.info("INSERT 결과: " + result);
	}
	
	@Test
	public void selectTest() {
		List<MemberVO> list = dao.select();
		logger.info("회원 수: " + list.size());
		for (MemberVO member : list) {
			logger.info(member.getUserid());
		}
	}
	

	
	
} // end class testMemberDAO
