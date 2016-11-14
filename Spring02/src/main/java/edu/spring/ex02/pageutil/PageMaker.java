package edu.spring.ex02.pageutil;


// 페이지 번호에 대한 링크를 만들기 위한 클래스
public class PageMaker {
	// 현재 페이지 번호, 한 페이지에 보여줄 게시글 개수
		// Pagination : 페이지 번호
		// Criteria : 기준
	private PaginationCriteria criteria;	
	
	// 전체 게시글 개수
	private int totalCount;
	
	// 화면에서 보여지는 시작페이지 링크의 번호
	private int startPageNum;
	
	// 화면에서 보여지는 끝 페이지 링크의 번호
	private int endPageNum;
	
	// 화면에서 보여질 페이지 링크의 개수
	private int numOfPageLink;
	
	// 이전, 다음 페이지 링크가 있는 지
	private boolean hasPrev;
	private boolean hasNext;

	
	public PageMaker() {
		numOfPageLink = 5;
	} // 페이지 링크의 개수를 디폴트로 5개 세팅
	//////////////////////////////////////////////////////
	// getter
	public PaginationCriteria getCriteria() {
		return criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public int getNumOfPageLink() {
		return numOfPageLink;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public boolean isHasNext() {
		return hasNext;
	}
	//////////////////////////////////////////////////////
	// setter
	public void setCriteria(PaginationCriteria criteria) {
		this.criteria = criteria;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setPageData() {
///////////////////////////////////////////////////////////////////////////////////////////
/*		// TODO[FIXME]: endPageNum 다시 계산 필요
		endPageNum = (int) (Math.ceil(criteria.getPage() / (double) numOfPageLink) * numOfPageLink);
		
		startPageNum = endPageNum - numOfPageLink + 1 ;
		
		if ( startPageNum == 1) {		
			hasPrev=false;
		} else {
			hasPrev=true;
		}
		
		if (endPageNum * criteria.getPerPage() < totalCount) {
			hasNext = true;
		} else {
			hasNext = false;
		}
*/
////////////////////////////////////////////////////////////////////////////////////////////
		
		int maxPageLink = (int)
				Math.ceil((double)totalCount / criteria.getPerPage());
		int temp = (int)
				(Math.ceil(criteria.getPage() / (double) numOfPageLink) 
						* numOfPageLink);
		if (temp < maxPageLink) {
			endPageNum = temp;
		} else {
			endPageNum = maxPageLink;
		}
		//START 번호는 링크개수와 관련이 되어 있음.. 
		startPageNum = 
				((endPageNum - 1) / numOfPageLink) * numOfPageLink + 1;
		
		if (startPageNum == 1) {
	         //링크 시작 번호가 1번이라면, numofPageLink 는 5개가 있을것이고
	         //이전이라는 링크는 없어야 함. 
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		if (endPageNum * criteria.getPerPage() < totalCount) {
			hasNext= true;
		} else {
			hasNext= false;
		}
	}
	
} // end class PageMaker


































