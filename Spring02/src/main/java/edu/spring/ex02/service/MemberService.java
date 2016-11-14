package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.MemberVO;

// 비즈니스 로직을 구현하는 인터페이스
// CRUD: Create, Read, Update, Delete
public interface MemberService {
	
	// Create: 새로운 회원 가입
	public abstract int create(MemberVO vo);
	
	// Read 1: 회원 전체 검색
	public abstract List<MemberVO> read();
	
	// Read 2: 특정 회원(userid) 검색
	public abstract MemberVO read(String userid);
	
	// Update: 특정 회원(userid)의 비번(pwd)과 이메일(email) 수정
	public abstract int update(MemberVO vo);
	
	// Delete: 특정 회원(userid)의 정보 삭제
	public abstract int delete(String userid);
}













