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

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class TestBoardDAO {
	
	private static Logger logger = LoggerFactory.getLogger(TestBoardDAO.class);
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void doTest() {
		//testInsert();
		//testSelectAll();
		//testSelect();
		testUpdate();
	}
	
	public void testInsert() {
		BoardVO vo = new BoardVO(0, "테스트", "JUnit", "admin", null);
		int result = dao.insert(vo);
		logger.info("INSERT 결과: " + result);
	}
	
	public void testSelectAll() {
		List<BoardVO> list = dao.select();
		for (BoardVO vo : list) {
			logger.info(vo.getTitle() + " | " + vo.getRegdate());
		}
	}
	
	 public void testSelect() {
		      BoardVO vo = dao.select(1);
		      logger.info("글번호: "+vo.getBno());
		      logger.info("제목: "+vo.getTitle());
		      logger.info("본문: "+vo.getContent());
		      logger.info("작성자: "+vo.getUserid());
		      logger.info("작성 시간: "+vo.getRegdate());
	}
	 
	private void testUpdate() {
		BoardVO vo = new BoardVO(9, "수정 테스트", "수정테스트", null, null);
		int result = dao.update(vo);
		logger.info("update 결과: " + result);
	}
	 
} // end class TestBoardDAO

























