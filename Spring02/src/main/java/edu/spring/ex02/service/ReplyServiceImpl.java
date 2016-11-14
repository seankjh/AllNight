package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex02.domain.ReplyVO;
import edu.spring.ex02.persistence.BoardDAO;
import edu.spring.ex02.persistence.ReplyDAO;


@Service
public class ReplyServiceImpl implements ReplyService {

	private static final Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);

	@Autowired
	private ReplyDAO replyDAO;

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int create(ReplyVO vo) {
		logger.info("create(): vo=" + vo);
		// 기존코드: return replyDAO.insert(vo);
		// 댓글 테이블에 insert후, 게시판 테이블 update(+1)
		int result = replyDAO.insert(vo);
		if (result == 1) {
			result = boardDAO.updateReplyCount(1, vo.getBno());
		}
		return result;
	}

	@Override
	public List<ReplyVO> read(int bno) {
		logger.info("read(): bno=" + bno);

		return replyDAO.select(bno);
	}

	@Override
	public int update(ReplyVO vo) {
		logger.info("update(): vo=" + vo);
		return replyDAO.update(vo);
	}

	@Override
	public int delete(int rno) {
		logger.info("delete(): rno=" + rno);
		// return replyDAO.delete(rno);

		// 댓글 테이블에서 삭제 후, 게시판 테이블을 업데이트(-1)
		int bno = replyDAO.selectBno(rno);
		int result = replyDAO.delete(rno);
		if (result == 1) {
			result = boardDAO.updateReplyCount(-1, bno);
		}
		return result;
	}
	
	@Transactional // Spring에서 제공하는 트랜잭션 관리 기능 사용
	@Override
	public void testTransaction(int rno) {
		logger.info("testTransaction() 호출...");
		int bno = replyDAO.selectBno(rno);
		logger.info("bno..."+bno);
		
		int result = replyDAO.delete(rno);
		logger.info("댓글 삭제 결과: "+result);
		
		result = boardDAO.updateTransactionTEST(-1, bno); // 여기 board mapper 구문 오류로 실행안되고 롤백됨
		logger.info("게시판 테이블 업데이트 결과: "+result);
		
	}

} // end class ReplyServiceImpl