package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PaginationCriteria;

// CRUD: Create, Read, Update, Delete
public interface BoardService {

	// 새 글 작성 기능
	public abstract int create(BoardVO vo);
	
	// 게시글 전체 리스트
	public abstract List<BoardVO> read();
	
	// 글번호 검색
	public abstract BoardVO read(int bno);
	
	// 게시글 수정
	public abstract int update(BoardVO vo);
	
	// 게시글 삭제
	public abstract int delete(int bno);
		
	// 페이징 처리를 위한 메소
	public abstract int getNumOfRecords();
	public abstract List<BoardVO> read(PaginationCriteria c);
	
/*	
	jsp > controller > mapper > DAO > DAOImpl > TestBoardDAO > BoardService
	
	*/

	
}
