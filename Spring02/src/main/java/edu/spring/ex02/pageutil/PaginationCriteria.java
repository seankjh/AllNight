package edu.spring.ex02.pageutil;



public class PaginationCriteria {
	// field
	private int page; // 현재 화면에 보이는 페이지 번호
	private int perPage; // 한 페이지에 보여질 게시글 개수
	
	// Constructor
	public PaginationCriteria() {
		page = 1; // 디폴트로 1페이지를 보여줌
		perPage = 10; // 디폴트로 한페이지 10개씩 보여줌
	}

	public PaginationCriteria(int page, int perPage) {
		this.page = page;
		this.perPage = perPage;
	}

	// Getter/Setter
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	// board-mapper.xml에서 #{start}, #{end}의 값으로 세팅하기 위해서
	// 한 페이지에 5개씩 보여진다고 가정:
	// 1페이지: 1 ~ 5
	// 2페이지: 6 ~ 10
	// ...
	public int getStart() {
		int start = (page - 1) * perPage + 1;
		return start;
	}
	
	public int getEnd() {
		int end = page * perPage;
		return end;
	}
	

} // end class PaginationCriteria





























