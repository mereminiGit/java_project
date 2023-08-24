package co.yedam;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable{
	// 필드
	private int number;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd (HH:mm)");

	// 기본 생성자
	public Board() {
		
	}
	
	// 입력받을 생성자
	public Board(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	// get / set
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Board [number=" + number + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + sdf.format(writeDate) + "]";
	}

	// 5. 목록시 출력 형태 메소드
	public String showList() {
		return "[" + number + "]" + " | 제목: " + title + " | 작성자: " + writer;
	}
	
	// 3. 조회시 출력 형태 메소드
	public String showDetail() {
		return "번호: " + number + " | 제목: " + title + " | 작성자: " + writer + "\n" + 
			   "작성날짜: " + sdf.format(writeDate) + "\n" + "\n" +
			   "[내용] " + content; 
	}
	
}
