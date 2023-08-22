package co.yedam.board;

import java.util.List;
import java.util.Scanner;

// 파일, jdbc 통합 컨트롤
public class BoardApp {
	Scanner sc = new Scanner(System.in);
//	BoardService service = new BoardServiceImpl();
	BoardService service = new BoardServiceJdbc();
	UserService userService = new UserServiceImpl();
	String tmpWriter = null;

	public void start() {

		boolean run = true;

//		while(run) {
//			System.out.println("-------------------------------------------------");
//			String id = printString("아이디 입력");
//			String pw = printString("비밀번호 입력");
//			User user = new User();
//			user.setId(id);
//			user.setPw(pw);
//			
//			if(userService.checkLogin(user)) {
//				tmpWriter = user.getId();
////				System.out.println(user.getName());
//				break;
//			}
//			
//			System.out.println("로그인 실패");
//
//		}

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
		}
	}

	// 목록 메소드
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
		String content = printString("내용입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
//		brd.setUpdateDate(new Date());
		if (service.modify(brd)) {
			System.out.println("수정성공");
		}
	}

	// 삭제
	private void remove() {
		String brdNo = printString("번호입력");
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제성공");
		}
	}

	// 상세조회
	private void search() {
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));

		if (result == null) {
			System.out.println("해당 글번호가 없습니다.");
		} else {
			if (result.getUpdateDate() == null) {
					System.out.println(result.showInfo());
			} else {
				System.out.println(result.showModifyInfo());
			}
		}

	}
}
