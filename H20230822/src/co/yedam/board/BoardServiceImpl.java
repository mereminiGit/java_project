package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 저장하고 불러오고 하는 기능
public class BoardServiceImpl implements BoardService { // 임플리메이션 // implemetion

	List<Board> boardList = new ArrayList<Board>(); // 추가를 하면 boardList에 저장

	// 생성자에 파일 저장된거 불러오는거 넣기
	public BoardServiceImpl() {
		init();
	}

	// 파일에 있는것을 실행시 읽기
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/board.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

//			ois.readObject(); // 바이트로 되어있는걸 객체로 읽어오겠습니다. 역직열화

			boardList = (List<Board>) ois.readObject(); // 타입변환 해야함 ois는 오브젝트 타입이라서

			// 사용종료
			ois.close();
			fis.close();

		} catch (Exception e) { // 처음 시작할 때는 파일이 없어서 오류가 생기는데 굳이 오류 표시 안 해줘도 된다.
//			e.printStackTrace();
		}
	}

	private int getMaxNo() { // 글번호 생성해주는 메소드
		int brdNo = 0;

		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}

	// 추가
	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo());
		board.setWriteDate(new Date());
//		board.setUpdateDate(new Date());
		return boardList.add(board);
	}

	// 목록
	@Override
	public List<Board> list(int page) {
		int start = (page - 1) * 5; // page = 1 -> 1 / page = 2 -> 6
		int end = page * 5;
		List<Board> pageList = new ArrayList<Board>();

		for (int i = 0; i < boardList.size(); i++) {
			if (i >= start && i < end)
				pageList.add(boardList.get(i)); // 전체 리스트 중에서 해당하는 5개의 값만 새로운 pageList에 넣어서 반환한다
		}
		return pageList;
	}

	@Override
	public int getTotal() {
		return boardList.size();
	}
	
	// 수정
	@Override
	public boolean modify(Board board) {
		// 글번호가 같은게 있는지 테스트
		for (int i = 0; i < boardList.size(); i++) {
			if (board.getBrdNo() == boardList.get(i).getBrdNo()) {
				boardList.get(i).setBrdContent(board.getBrdContent());
				boardList.get(i).setUpdateDate(new Date());
				return true;
			}
		}
		return false;
	}

	// 삭제
	@Override
	public boolean remove(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i);
				return true; // 정상적으로 삭제되었다
			}
		}
		return false; // 글 번호가 없어서 삭제가 안 되었다
	}

	// 조회
	@Override
	public Board search(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i);
			}
		}
		return null;
	}

	// 종료시 파일 저장
	@Override
	public void save() {

		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/board.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos); // 보조스트림

			// Serializable를 인터페이스를 구현하는 클래스이어야 함, arrayList는 이미 되어있고 Board에도 해줘야함
			oos.writeObject(boardList); // 객체를 바로 바이트 타입으로 직열화

			// 사용 다 하면 종료해줘야함
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 글번호 입력하면 작성자가 나오도록
	@Override
	public String getResponseUser(int brdNo) {
		for(int i = 0; i < boardList.size(); i++) {
			if(brdNo == boardList.get(i).getBrdNo()) {
				return boardList.get(i).getBrdWriter();
			}
		}
		return null;
	}

}
