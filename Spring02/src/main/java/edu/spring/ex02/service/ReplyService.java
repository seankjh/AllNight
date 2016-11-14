package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.ReplyVO;

public interface ReplyService {
	
	public abstract int create(ReplyVO vo);
	public abstract List<ReplyVO> read(int bno);
	public abstract int update(ReplyVO vo);
	public abstract int delete(int rno);
	
	// 트랜젝션(transaction) 테스트를 위한 메소드
	public abstract void testTransaction(int rno);
	
}









