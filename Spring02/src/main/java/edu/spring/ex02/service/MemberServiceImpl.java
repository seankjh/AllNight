package edu.spring.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.MemberVO;
import edu.spring.ex02.persistence.MemberDAO;

//@Component // 스프링 프레임워크가 bean으로 관리하는 클래스
@Service // 스프링 프레임워크가 Service bean으로 관리하는 클래스
public class MemberServiceImpl implements MemberService {

	@Autowired // 스프링 프레임워크에서 관리하는 DAO 빈 객체를 주입
	private MemberDAO dao;
	
	@Override
	public int create(MemberVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<MemberVO> read() {
		return dao.select();
	}

	@Override
	public MemberVO read(String userid) {
		return dao.select(userid);
	}

	@Override
	public int update(MemberVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(String userid) {
		return dao.delete(userid);
	}

} // end class MemberServiceImpl






