package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.ReplyVO;

public interface ReplyDAO {
	
	public abstract int insert(ReplyVO vo);
	public abstract List<ReplyVO> select(int bno);
	public abstract int update(ReplyVO vo);
	public abstract int delete(int rno);
	
	// bno 찾는 select
	public abstract int selectBno(int rno);
	
} // end interface ReplyDAO















