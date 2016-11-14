package edu.spring.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PaginationCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@Service // 스프링 프레임워크에 Service 계층 콤포넌트 bean 객체로 등록
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public int create(BoardVO vo) {
		return boardDao.insert(vo);
	}
	
	@Override
	public List<BoardVO> read() {
		return boardDao.select();
	}
	
	@Override
	public BoardVO read(int bno) {
		return boardDao.select(bno);
	}
	
	@Override
	public int update(BoardVO vo) {
		return boardDao.update(vo);
	}
	
	@Override
	public int delete(int bno) {
		return boardDao.delete(bno);
	}

	@Override
	public int getNumOfRecords() {
		return boardDao.getNumberOfRecords();
	}
	@Override
	public List<BoardVO> read(PaginationCriteria c) {
		return boardDao.select(c);
	}
}
