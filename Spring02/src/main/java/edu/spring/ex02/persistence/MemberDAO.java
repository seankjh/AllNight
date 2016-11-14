package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.MemberVO;

public interface MemberDAO {
	
	public abstract int insert(MemberVO vo);
	public abstract List<MemberVO> select();
	
	public abstract MemberVO select(String userid);
	public abstract int update(MemberVO vo);
	public abstract int delete(String userid);
	public abstract int update(String id, String mail);
} // end interface MamberDAO
