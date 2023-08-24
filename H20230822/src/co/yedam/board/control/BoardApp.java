package co.yedam.board.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.ReplyService;
import co.yedam.board.service.UserService;
import co.yedam.board.serviceClass.BoardServiceImpl;
import co.yedam.board.serviceClass.BoardServiceJdbc;
import co.yedam.board.serviceClass.ReplyServiceImpl;
import co.yedam.board.serviceClass.UserServiceImpl;
import co.yedam.board.serviceClass.UserServicejdbc;
import co.yedam.board.vo.Board;
import co.yedam.board.vo.Reply;
import co.yedam.board.vo.User;

// 파일, jdbc 통합 컨트롤
public class BoardApp {
	Scanner sc = new Scanner(System.in);
//	BoardService service = new BoardServiceImpl();
	BoardService service = new BoardServiceJdbc();
//	UserService userService = new UserServiceImpl();
	UserService userService = new UserServicejdbc();
//	ReplyService replyService = new ReplyServiceJdbc();
	String tmpWriter = null;

	public void start() {

		boolean run = true;

		while(run) {
			System.out.println("-------------------------------------------------");
			String id = printString("아이디 입력");
			String pw = printString("비밀번호 입력");
			User user = new User();
			user.setId(id);
			user.setPw(pw);
			
			user = userService.checkLogin(user);
			if(user != null) {
				System.out.println(user.getName() + "_Welcome");
				tmpWriter = user.getId();
//				System.out.println(user.getName());
				break;
			}
			
			System.out.println("로그인 실패");

		}

		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.글등록 | 2.목록 | 3.수정 | 4.삭제 | 5.상세조회 | 9.종료");
			System.out.print("선택>> ");

			int menu = sc.nextInt();
			sc.nextLine();
			System.out.println("-------------------------------------------------");

			switch (menu) {
			case 1: // 등록 / 제목. 내용. 작성자 입력
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
				System.out.println("End of BoardApp.");
				service.save();
				run = false;
			}

		}
		System.out.println("end of prog.");
	} // end of start

	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return sc.nextLine();
	} // end of printString

	// 추가 메소드
	private void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
//		String writer = printString("작성자");
		String writer = tmpWriter;

		// 인터페이스의 메소드로
		Board board = new Board(title, content, writer);
		if (service.add(board)) {
			System.out.println("등록성공");
		} else
			System.out.println("등록실패");
	}

	// 목록 메소드 --------------------------------------
	private void boardList() {
		int page = 1;

		while (true) {
			List<Board> list = service.list(page);
			for (Board brd : list) {
				System.out.println(brd.listInfo());
			}
			System.out.println();
			// 4건이면 1페이지, 9건이면 2페이지 / 올림을 해줘야함
			int total = service.getTotal();
			int lastPage = (int) Math.ceil(total / 5.0); // 소수점까지 나와야 올림 가능

			for (int i = 1; i <= lastPage; i++) {
				if (i == page) {
					System.out.printf("[%d]", i);
					System.out.print("   ");
				} else {
					System.out.printf(" %d ", i);
					System.out.print("   ");
				}
			}
			System.out.println();
			System.out.print("조회 페이지 입력(종료: 9)>> ");
			page = sc.nextInt(); // sc.nextLine();
			if (page == 9)
				break;
			System.out.println("-------------------------------------------------");
		}
	}

	// 수정
	private void modify() {
		String brdNo = printString("글 번호입력");
		if (service.getResponseUser(Integer.parseInt(brdNo)).equals(tmpWriter)) {
			String content = printString("내용입력");
			Board brd = new Board();
			brd.setBrdNo(Integer.parseInt(brdNo));
			brd.setBrdContent(content);
//		brd.setUpdateDate(new Date());
			if (service.modify(brd)) {
				System.out.println("수정성공");
			}
		}else {
			System.out.println("권한이 없습니다.");
		}
	}

	// 삭제
	private void remove() {
		String brdNo = printString("번호입력");
		if ( service.getResponseUser(Integer.parseInt(brdNo)) != null && 
				!service.getResponseUser(Integer.parseInt(brdNo)).equals(tmpWriter)){
			System.out.println("권한이 없습니다.");
			return;
		}
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제성공");
		}
		
	}

	// 상세조회
	private void search() {
		boolean run = true;
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));

		if (result == null) { // 글이 없을때
			System.out.println("해당 글번호가 없습니다.");
		} else { // 글이 존재
			if (result.getUpdateDate() == null) {
				System.out.println(result.showInfo());
			} else {
				System.out.println(result.showModifyInfo());
			}
			// 중첩 클래스 실행
			ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
			rapp.start();
		}

	} // end of search

	class ReplyApp { // 중첩 클래스
		// 필드.
//		private ReplyService replyService = new ReplyServiceJdbc();
		private ReplyService replyService = new ReplyServiceImpl();
		private int brdNo;
		
		// 생성자.
		ReplyApp(int brdNo) {
			this.brdNo = brdNo;
		}
		
		// 실행.
		public void start() {
			boolean run = true;
			
			while (run) {
				List<Reply> showReply = replyService.replyList(brdNo);
//				if (showReply == null ) { //|| showReply.isEmpty()
//					System.out.println("댓글이 없습니다.");
//				} else {
				System.out.println("댓글  --------------------------------------------");
				for (Reply list : showReply) {
					System.out.println(list.listInfo());
				}
				if (showReply.isEmpty()) {
					System.out.println("댓글이 없습니다.");
				}
				System.out.println("-------------------------------------------------");

				// 댓글 출력
				System.out.println("< 1.댓글등록 | 2.댓글삭제 | 9.조회종료 >");
				System.out.print("선택>> ");

				int menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				case 1:
					replyRegister(brdNo);
					break;
				case 2:
					replyRemove();
					break;
				case 9:
					System.out.println("조회를 종료합니다.");
					replyService.save();
					run = false;
					break;
				}

			} // end of while (댓글 기능 종료)
		} // end of start
		
		
		// 댓글 추가 메소드
		private void replyRegister(int num) {
			String replyContent = printString("댓글 내용");
//			String replyWriter = printString("댓글 작성자");
			String replywriter = tmpWriter;
			int brdNo = num;
			
			Reply addReply = new Reply(num, replyContent, replywriter);
			
			if (replyService.replyadd(addReply)) {
				System.out.println("댓글 등록 성공");
			} else
				System.out.println("댓글 등록 실패");
		}
		

		// 댓글 삭제 메소드
		private void replyRemove() {
			int replyNo = Integer.parseInt(printString("댓글 삭제 번호"));
			if(replyService.replyDelete(replyNo)) {
				System.out.println("댓글 삭제 성공");
			}
		}
		
	} // end of class 중첩 클래스
	
	
}


//if (result.getUpdateDate() == null) {
//	System.out.println(result.showInfo());
//} else {
//	System.out.println(result.showModifyInfo());
//}
