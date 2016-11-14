package edu.spring.ex02.domain;

import java.util.Date;

// tbl_reply 테이블 구조
public class ReplyVO {
	private int rno; // 댓글 번호
	private int bno; // 게시글 번호(몇 번 게시글의 댓글인 지에 대한 정보)
	private String rtext; // 댓글 내용
	private String replier; // 댓글 작성자 아이디
	private Date regdate; // 댓글 작성/수정 시간
	
	public ReplyVO() {}

	public ReplyVO(int rno, int bno, String rtext, String replier, Date regdate) {
		this.rno = rno;
		this.bno = bno;
		this.rtext = rtext;
		this.replier = replier;
		this.regdate = regdate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
	}

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}















