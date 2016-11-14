package edu.spring.ex02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PaginationCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class TestPaging {
	private static final String NAMESPACE = "edu.spring.ex02.BoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(TestPaging.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void doTest() {
		//insertBulkData();
		//testTotalCount();
		//testPaging1();
		testPaging2();
	}
	
	private void insertBulkData() {
		for (int i = 1; i <= 100; i++) {
			String title = "테스트 제목 " +  i;
			String content = "테스트 본문 " + i;
			String userid = "test";
			BoardVO vo = new BoardVO(0, title, content, userid, null);
					
			int result = sqlSession.insert(NAMESPACE + ".insert", vo);		
			logger.info("insert 결과: " + result);
		}
	} // end insertBulkDate()
	
	private void testTotalCount() {
		int result = sqlSession.selectOne(NAMESPACE + ".totalCount");
		logger.info("전체 레코드 개수: " + result);
		
	}

	private void testPaging1() {
		Map<String, Integer> args = new HashMap<>();
		args.put("start", 11);
		args.put("end", 5);
		List<BoardVO> list = sqlSession.selectList(NAMESPACE+ ".listPage", args);
		
		for (BoardVO vo : list) { // 인핸스트 포문
			logger.info(vo.getBno() + " | " + vo.getTitle());
			
		}
	}
	
	private void testPaging2() {
		PaginationCriteria c = new PaginationCriteria();
		c.setPage(3);
		
		List<BoardVO> list = sqlSession.selectList(NAMESPACE + ".listPage",c);
		for (BoardVO vo : list) {
			logger.info(vo.getBno() + " | " + vo.getTitle());
		}
	}
} // end class TestPaging




































