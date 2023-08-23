package H20230822_File.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {

	BoardService service = new BoardServiceImpl();
	BoardServiceImpl serviceTmp = new BoardServiceImpl();
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		boolean run = true;
		
		while(run) {
			System.out.println("1.글등록 | 2.목록 | 3.수정 | 4.삭제 | 5.상세조회 | 9.종료");
			System.out.print("선택>> ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: // 등록
				register();
				break;
			case 2: // 목록
				boardList();
				break;
			case 3: // 수정
				modify();
				break;
			case 4: // 삭제
				remove();
				break;
			case 5: // 상세조회
				search();
				break;
			case 9: // 종료
				System.out.println("end of board");
				service.save();
				run = false;
				break;
			}
			
		} // end of while
	} // end of start
	
	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return sc.nextLine();
	}
	
	// 등록 (제목, 내용, 작성자)
	private void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
		String writer = printString("작성자입력");
		
		Board boardAdd = new Board(title, content, writer);
		
		if(service.add(boardAdd)) {
			System.out.println("등록성공");
		} else 
			System.out.println("등록실패");
	}
	
	// 목록 (글번호, 글제목, 작성자)
	private void boardList() {
		List<Board> list = service.list();
		for(Board board : list) {
			System.out.println(board.listInfo());
		}
	}
	
	// 수정
	private void modify() {
		String brdNo = printString("글번호입력");
		if(serviceTmp.currentBrdNo(Integer.parseInt(brdNo))) {
			String content = printString("내용입력");
			Board board = new Board();
			board.setBrdContent(content);
			board.setBrdNo(Integer.parseInt(brdNo));
			
			if(service.modify(board)) {
				System.out.println("수정성공");
			}
		} else
			System.out.println("해당 글이 없습니다.");
	}
	
	// 삭제
	private void remove() {
		
	}
	
	// 상세조회
	private void search() {
		
	}
}


















