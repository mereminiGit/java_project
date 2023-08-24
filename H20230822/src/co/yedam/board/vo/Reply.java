package co.yedam.board.vo;

import java.io.Serializable;

// 댓글 클래스
public class Reply implements Serializable {
	// 필드
	private int replyNo;
	private int brdNo;
	private String replyContent;
	private String replyWriter;

	// 기본 생성자
	public Reply() {

	}

	// 입력 받을 생성자
	public Reply(int boardNo, String replyContent, String replyWriter) {
		super();
		this.brdNo = boardNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
	}

	// get / set.
	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	// 목록보기 메소드
	public String listInfo() {
		String list = "[" + replyNo + "]" + " | 내용: " + replyContent + " | 작성자: " + replyWriter;
		return list;
	}
}
