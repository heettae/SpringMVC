package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberVO {
	// DTO(Data Transfer Object) : 순수하게 데이터를 저장해서 계층간 이동하기위한 객체
	//    멤버변수, 메서드(set/get), toString()
	
	// VO(Value Object) : 특정한 비지니스 데이터를 담는 클래스(비지니스 로직 포함가능)
	//   멤버변수, 메서드(get), +메서드
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	

}
