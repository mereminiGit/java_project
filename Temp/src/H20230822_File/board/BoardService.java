package H20230822_File.board;

import java.util.List;

public interface BoardService {
	// 등록
	public boolean add(Board board);
	
	// 목록
	public List<Board> list();
	
	// 전체 페이지 수
	public int getTotal();
	
	// 수정
	public boolean modify(Board board);
	
	// 삭제
	public boolean remove(int brdNo);
	
	// 상세조회
	public Board search(int brdNo);
	
	// 저장
	public void save();
}
