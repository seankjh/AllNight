package edu.spring.ex02.domain;

// DB에 있는 tbl_member 테이블 구조
public class MemberVO {
	
	private int mid;
	private String userid;
	private String password;
	private String email;
	
	public MemberVO() {
		super();
	}

	public MemberVO(int mid, String userid, String password, String email) {
		super();
		this.mid = mid;
		this.userid = userid;
		this.password = password;
		this.email = email;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	

	
} // end class MemberVO
