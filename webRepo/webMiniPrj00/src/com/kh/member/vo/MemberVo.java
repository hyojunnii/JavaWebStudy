package com.kh.member.vo;

public class MemberVo {
	
	public MemberVo() {
	}
	
	public MemberVo(int no, String id, String pwd, String pwd2, String name, String nick, String email, String phone,
			String addr, String eDate, String status, String comment) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.name = name;
		this.nick = nick;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.eDate = eDate;
		this.status = status;
		this.comment = comment;
	}

	private int no;
	private String id;
	private String pwd;
	private String pwd2;
	private String name;
	private String nick;
	private String email;
	private String phone;
	private String addr;
	private String eDate;
	private String status;
	private String comment;
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", nick="
				+ nick + ", email=" + email + ", phone=" + phone + ", addr=" + addr + ", eDate=" + eDate + ", status="
				+ status + ", comment=" + comment + "]";
	}
	
}
