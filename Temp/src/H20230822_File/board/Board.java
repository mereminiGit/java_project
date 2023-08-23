package H20230822_File.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable{
	private int brdNo;
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date writeDate;
	private Date updateDate;

	public Board() {

	}

	public Board(String brdTitle, String brdContent, String brdWriter) {
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}

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

	// 목록보기 메소드
	public String listInfo() {
		String list = "글번호: " + brdNo + " | 제목: " + brdTitle + " | 작성자: " + brdWriter;
		return list;

	}

	// 상세보기 메소드
	public String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		String show = "글번호: " + brdNo + " | 제목: " + brdTitle + " | 작성자: " + brdWriter + "\n작성일자: "
				+ sdf.format(writeDate) // + " | 수정일자: " + sdf.format(updateDate)
				+ "\n내용: " + brdContent;
		return show;
	}

	// 상세보기 메소드(수정되었으면)
	public String showModifyInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		String show = "글번호: " + brdNo + " | 제목: " + brdTitle + " | 작성자: " + brdWriter + "\n작성일자: "
				+ sdf.format(writeDate) + " | 수정일자: " + sdf.format(updateDate) + "\n내용: " + brdContent;
		return show;
	}

}
