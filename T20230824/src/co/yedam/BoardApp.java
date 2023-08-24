package co.yedam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardApp {
	// 필드
	Scanner sc = new Scanner(System.in);
	List<Board> boardList = new ArrayList<>();

	// 생성자
	public BoardApp() {
		init();
	}

	// 작동 메소드
	public void start() {
		boolean run = true;

		while (run) {
			int menu = 0;
			System.out.println("=============================================");
			System.out.println("1.추가 | 2.수정 | 3.조회 | 4.삭제 | 5.목록 | 9.종료");
			System.out.print("선택>> ");

			menu = sc.nextInt();
			sc.nextLine();
			System.out.println("---------------------------------------------");

			switch (menu) {
			case 1: // 1.추가
				register();
				System.out.println("---------------------------------------------");
				System.out.println("등록되었습니다.");
				break;
			case 2: // 2. 수정
				modify();
				break;
			case 3: // 3. 조회
				search();
				break;
			case 4: // 4. 삭제
				remove();
				break;
			case 5: // 5. 목록
				list();
				break;
			case 9: // 9. 종료
				System.out.println("게시판을 종료하겠습니다.");
				save();
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("end of prog");

	} // end of start

	// 1. 추가
	private void register() {
		String title = printString("게시판 제목");
		String content = printString("게시판 내용");
		String writer = printString("게시판 작성자");

		Board board = new Board();

		board.setNumber(createNum());
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setWriteDate(new Date());

		boardList.add(board);
	} // end of register

	// 2. 수정
	private void modify() {
		String number = printString("게시판 번호");

		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getNumber() == Integer.parseInt(number)) {
				String title = printString("(수정)게시판 제목");
				String content = printString("(수정)게시판 내용");
				boardList.get(i).setTitle(title);
				boardList.get(i).setContent(content);
				System.out.println("---------------------------------------------");
				System.out.println("수정되었습니다.");
				return;
			}
		}
		System.out.println("해당 번호는 없습니다.");
	}// end of modify

	// 3. 조회
	private void search() {
		boolean check = false;
		String number = printString("게시판 번호");

		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getNumber() == Integer.parseInt(number)) {
				System.out.println(boardList.get(i).showDetail());
				check = true;
				break;
			}

		}
		if (!check) {
			System.out.println("해당 번호는 없습니다.");
		}
	} // end of search

	// 4. 삭제
	private void remove() {
		String number = printString("게시판 번호");

		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getNumber() == Integer.parseInt(number)) {
				boardList.remove(i);
				System.out.println("삭제되었습니다.");
				return;
			}

		}
		System.out.println("해당 번호는 없습니다.");
	} // end of remove

	// 5. 목록
	private void list() {
		int page = 1;

		if (totalList() == 0) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5;
			int lastPage = (int) Math.ceil(totalList() / 5.0);

			for (int i = 0; i < boardList.size(); i++) {
				if (i >= start && i < end) {
					System.out.println(boardList.get(i).showList());
				}
			}

			System.out.println("---------------------------------------------");
			System.out.print("<페이지>  ");

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

			System.out.print("[조회 페이지 입력(종료: 9)]>> ");
			page = sc.nextInt(); sc.nextLine();
			System.out.println();
			
			if (page == 9)
				break;
			else if (page > lastPage) {
				System.out.println("해당 페이지는 없습니다.");
				continue;
			} else
				continue;
		}
	} // end of list

	// ----- 공용 메소드 ------
	// 입력 받는 메소드
	private String printString(String msg) {
		System.out.print(msg + "입력>> ");
		return sc.nextLine();
	}

	// 글번호 생성 메소드
	private int createNum() {
		int boardNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getNumber() > boardNo)
				boardNo = boardList.get(i).getNumber();
		}
		return boardNo + 1;
	}

	// 리스트 전체 갯수 메소드
	private int totalList() {
		return boardList.size();
	}

	// ----- 파일 Read/Write ------
	// 어플리케이션 시작 시 파일 읽기
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			boardList = (List<Board>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
			// 최초 프로젝트 발생 시 오류 안 보여줘도 됨
//			e.printStackTrace();
		}

	}

	// 어플리케이션 종료 시 파일 저장
	private void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(boardList);

			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

} // end of class
