package edu.spring.ex02.domain;

public class PostVO {
	String postcode;
	String roadaddress;
	String jibunaddress;
	String detailaddress;
	
	public PostVO(){}
	
	public PostVO(String postcode, String roadaddress, String jibunaddress, String detailaddress){
		this.postcode = postcode;
		this.roadaddress=roadaddress;
		this.jibunaddress=jibunaddress;
		this.detailaddress=detailaddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getRoadaddress() {
		return roadaddress;
	}

	public void setRoadaddress(String roadaddress) {
		this.roadaddress = roadaddress;
	}

	public String getJibunaddress() {
		return jibunaddress;
	}

	public void setJibunaddress(String jibunaddress) {
		this.jibunaddress = jibunaddress;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	

}
