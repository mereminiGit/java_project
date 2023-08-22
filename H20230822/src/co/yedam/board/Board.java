package co.yedam.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable{
	
	// 필드 생성 (오라클 테이블 이름과 같이 생성)
	// 오라클 두 단어 _로 구분(brd_no), 자바는 대소문자로 구분
	private int brdNo; 				// 글 번호
	private String brdTitle;		// 제목
	private String brdContent;		// 내용
	private String brdWriter;		// 작성자
	private Date writeDate;			// 작성일자
	private Date updateDate;		// 수정일자
	
	// 생성자(입력해야할 값이 3개 정도)
	public Board() {
		
	}
	
	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}

	
	// get / set
	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public String getBrdWriter() {
		return brdWriter;
	}

	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	// toString
	@Override
	public String toString() {
		return "Board [brdNo=" + brdNo + ", brdTitle=" + brdTitle + ", brdContent=" + brdContent + ", brdWriter="
				+ brdWriter + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}
	
	// 목록보기 메소드
	public String listInfo() {
		String list = "글번호: " + brdNo + " | 제목: " + brdTitle + " | 작성자: " + brdWriter;
		return list;
		
	}
	

	// 상세보기 메소드
	public String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		String show = "글번호: " + brdNo + " | 제목: " + brdTitle + " | 작성자: " + brdWriter
						+ "\n작성일자: " + sdf.format(writeDate) //+ " | 수정일자: " + sdf.format(updateDate)
						+ "\n내용: " + brdContent;
		return show;	
	}
	
	// 상세보기 메소드(수정되었으면)
	public String showModifyInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		String show = "글번호: " + brdNo + " | 제목: " + brdTitle + " | 작성자: " + brdWriter
						+ "\n작성일자: " + sdf.format(writeDate) + " | 수정일자: " + sdf.format(updateDate)
						+ "\n내용: " + brdContent;
		return show;	
	}
}
