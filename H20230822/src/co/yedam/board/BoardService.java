package co.yedam.board;

import java.util.List;

// 규칙을 정하기 위해서 인터페이스 생성
// 하나는 파일에 저장, 하나는 jdbc로 할꺼기 때문에 규칙을 정해서 

// 파일저장 - 프로그램 종료될 때 1번, 값을 불러오는것도 처음에 생성자 호출시 1번
// 오라클 jdbc로 기능 구현

public interface BoardService {
	// 등록(추가)
	public boolean add(Board board); // 메게값으로 보드 클래스
	
	// 목록
	public List<Board> list(int page); // 1을 넣으면 1페이지의 5개의 항목만 보여주겠다.
	
	// 전체 페이지 수
	public int getTotal();
	
	// 수정 : 글내용 수정
	public boolean modify(Board board);
	
	// 삭제
	public boolean remove(int brdNo);
	
	// 수정, 삭제시 (글번호 입력하면 작성자가 나오도록)
	public String getResponseUser(int brdNo);
	
	// 상세조회
	public Board search(int brdNo);
	
	// 종료
	public void save();
}
