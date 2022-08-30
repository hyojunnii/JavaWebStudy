package com.kh.member.vo;

public class MemberVo {
	public MemberVo() {
	}
	
	public MemberVo(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	private String userId;
	private String userPwd;
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "MemberVo [userId=" + userId + ", userPwd=" + userPwd + "]";
	}
	
	
}
