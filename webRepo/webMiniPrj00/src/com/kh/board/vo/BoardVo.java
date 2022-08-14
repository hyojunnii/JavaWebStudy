package com.kh.board.vo;

public class BoardVo {
	
	public BoardVo() {
	}
	
	public BoardVo(int no, String category, String title, String content, String writer, String cnt, String eDate,
			String status) {
		this.no = no;
		this.category = category;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.cnt = cnt;
		this.eDate = eDate;
		this.status = status;
	}

	private int no;
	private String category;
	private String title;
	private String content;
	private String writer;
	private String cnt;
	private String eDate;
	private String status;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
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

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", cnt=" + cnt + ", eDate=" + eDate + ", status=" + status + "]";
	}

}
