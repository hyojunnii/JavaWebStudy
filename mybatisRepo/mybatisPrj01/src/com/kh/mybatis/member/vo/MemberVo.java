package com.kh.mybatis.member.vo;

public class MemberVo {
	public MemberVo() {
	}
	
	public MemberVo(String id, String pwd, String nick, String enrollDate, String quitYn) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.enrollDate = enrollDate;
		this.quitYn = quitYn;
	}

	private String id;
	private String pwd;
	private String nick;
	private String enrollDate;
	private String quitYn;
	
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", enrollDate=" + enrollDate + ", quitYn="
				+ quitYn + "]";
	}

}
