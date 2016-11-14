package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	private static final String NAMESPACE =
			"edu.spring.ex02.ReplyMapper";
	
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		logger.info("insert() 호출");
		logger.info("bno: " + vo.getBno());
		logger.info("rtext: " + vo.getRtext());
		logger.info("replier: " + vo.getReplier());
		
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	@Override
	public List<ReplyVO> select(int bno) {
		logger.info("select() 호출: bno=" + bno);
		
		return sqlSession.selectList(NAMESPACE + ".select", bno);
	}
	
	@Override
	public int update(ReplyVO vo) {
		logger.info("rno: " + vo.getRno());
		logger.info("rtext: " + vo.getRtext());
		
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int rno) {
		logger.info("delete() 호출: rno=" + rno);
		
		return sqlSession.delete(NAMESPACE + ".delete", rno);
	}
	
	@Override
	public int selectBno(int rno) {
		return sqlSession.selectOne(NAMESPACE+".getBno", rno);
	}

} // end class ReplyDAOImpl















