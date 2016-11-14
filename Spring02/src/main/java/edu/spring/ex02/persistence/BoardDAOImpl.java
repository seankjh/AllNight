package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PaginationCriteria;

// 스프링이 빈을 관리 해준다.

@Repository // 스프링에서 Persistence Layer(DAO) 컴포넌트 빈 객체로 관리
public class BoardDAOImpl implements BoardDAO {
	
	private static final String NAMESPACE = "edu.spring.ex02.BoardMapper";
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// MyBatis 프레임워크를 사용하기 위해서 SqlSession 객체를 주입 받음
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardVO vo) {
		logger.info("insert() title = " + vo.getTitle());
		
		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
		
		return result;
	}// end insert()
	
	@Override
	public List<BoardVO> select() {
		List<BoardVO> list = sqlSession.selectList(NAMESPACE + ".selectAll");
		logger.info("select() 호출: size = " + list.size());
		
		return list;
	}
	
	@Override
	public BoardVO select(int bno) {
		logger.info("select() 호출: bno = " + bno);
		BoardVO vo = sqlSession.selectOne(NAMESPACE + ".selectByBno", bno);
		return vo;
	}

	@Override
	public int update(BoardVO vo) {
		logger.info("update() 호출: bno = " + vo.getBno());
		
//		int result = sqlSession.update(NAMESPACE + ".update", vo);
//		return result;
		return  sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	@Override
	public int delete(int bno) {
		logger.info("delete() 호출: bno = " + bno);
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}
	
	@Override
	public int getNumberOfRecords() {
		return sqlSession.selectOne(NAMESPACE + ".totalCount");
	}
	
	@Override
	public List<BoardVO> select(PaginationCriteria c) {
		return sqlSession.selectList(NAMESPACE + ".listPage", c);
	}
	
	@Override
	public int updateReplyCount(int amount, int bno) {
		Map<String, Integer> args = new HashMap<>();
		// 키값은 boardMapper에서 #{amount}, #{bno}
		args.put("amount", amount);
		args.put("bno", bno);
		
		return sqlSession.update(NAMESPACE+".updateReplyCnt", args);
	}
	@Override
	public int updateTransactionTEST(int amount, int bno) {
		Map<String, Integer> args = new HashMap<>();
		// 키값은 boardMapper에서 #{amount}, #{bno}
		args.put("amount", amount);
		args.put("bno", bno);
		return sqlSession.update(NAMESPACE+".transactionTest", args);
	}
	
} // end class BoardDAOImpl

























