package com.nutgee.www.board.vo;

public class BoardVO {

	private Long boardSeq;
	private String id;
	private String title;
	private String content;
	private String indate;
	private String updateDate;

	public BoardVO(Long boardSeq, String id, String title, String content, String indate, String updateDate) {
		super();
		this.boardSeq = boardSeq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.updateDate = updateDate;
	}

	public BoardVO() {
		super();
	}

	public Long getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(Long boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BoardVO [boardSeq=" + boardSeq + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", indate=" + indate + ", updateDate=" + updateDate + "]";
	}

}
