package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PaginationCriteria;

public interface BoardDAO {
	// 매개변수 , 리턴타입 고민 
	// 인서트할 대상이 객체로 보낼 것인가 아님 하나하나 보낼 것인가 ? 개발자 몫
	// 인서트가 몇개가 성공했다라고 int를 준다.
	public abstract int insert(BoardVO vo);
	public abstract List<BoardVO> select();
	public abstract BoardVO select(int bno);
	
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	
	// 페이징 처리를 위한 메소드
	public abstract int getNumberOfRecords();
	public abstract List<BoardVO> select(PaginationCriteria c);
	
	public abstract int updateReplyCount(int amount, int bno);
	public abstract int updateTransactionTEST(int amount, int bno);
	
	
	
	
	
} // end interface BoardDAO
