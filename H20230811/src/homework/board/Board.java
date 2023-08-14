package homework.board;

public class Board {
	// 필드 생성 / 제목, 내용, 작성자, 글번호
	private String title;
	private String content;
	private String writer;
	private int num;
	
	// 생성자
	public Board(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
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


	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", writer=" + writer + ", num=" + num + "]";
	}
	
	// 출력 매소드
	
	
	
}
