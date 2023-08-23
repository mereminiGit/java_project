package H20230822_File.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardServiceImpl implements BoardService{

	List<Board> BoardList = new ArrayList<Board>();
	
	// 글번호 생성 메소드
	private int getMaxNo() {
		int brdNo = 0;
		for(int i = 0; i < BoardList.size(); i++) {
			if(BoardList.get(i).getBrdNo() > brdNo)
				brdNo = BoardList.get(i).getBrdNo();
		}
		return brdNo + 1;
	}
	// 등록
	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo()); 
		board.setWriteDate(new Date());
		
		return BoardList.add(board);
	}

	// 목록
	@Override
	public List<Board> list() {
		
		
		return BoardList;
	}

	// 전체 페이지 수
	@Override
	public int getTotal() {
		return 0;
	}

	// 글번호 조회 메소드
	public boolean currentBrdNo(int brdNo) {
		for (int i = 0; i < BoardList.size(); i++) {
			if (brdNo == BoardList.get(i).getBrdNo())
				return true;
		}
		return false;
	}
	
	// 수정
	@Override
	public boolean modify(Board board) {
		for (int i = 0; i < BoardList.size(); i++) {
			if(board.getBrdNo() == BoardList.get(i).getBrdNo()) {
				BoardList.get(i).setBrdContent(board.getBrdContent());
				BoardList.get(i).setUpdateDate(new Date());
				return true;
			}
		}
		return false;
	}

	// 삭제
	@Override
	public boolean remove(int brdNo) {
		return false;
	}

	// 상세조회
	@Override
	public Board search(int brdNo) {
		return null;
	}

	// 저장
	@Override
	public void save() {
		
	}

}
