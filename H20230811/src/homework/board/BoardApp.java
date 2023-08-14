package homework.board;

import java.util.Scanner;

public class BoardApp {
	Scanner sc = new Scanner(System.in);
	Board[] text = new Board[20];

	static void showBoard() {
		BoardApp tmp = new BoardApp();
		Scanner sc = tmp.sc;
		boolean run = true;

		while (run) {
//			int boardNum = 1;
			System.out.println("1.등록 2.목록 3.상세보기 4.수정 5.삭제 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: // 게시판 등록 (제목, 내용, 작성자)
				tmp.addBoard();
				break;

			case 2: // 게시판 목록
				tmp.listBoard();
				break;

			case 3: // 게시판 상세보기
				tmp.detailBoard();
				break;

			case 4: // 게시판 수정
				tmp.editBoard();
				break;

			case 5: // 게시판 삭제
				tmp.deleteBoard();
				break;

			case 9: // 종료
				System.out.println("종료되었습니다.");
				run = false;
				break;

			default:
				System.out.println("잘못 입력하였습니다.");

			}// end of switch
		} // end of while
	}// end of show

	// 1. 등록
	void addBoard() {
		System.out.print("제목>> ");
		String inputTitle = sc.nextLine();

		System.out.print("내용>> ");
		String inputContent = sc.nextLine();

		System.out.print("작성자>> ");
		String inputWriter = sc.nextLine();

		Board inputTmp = new Board(inputTitle, inputContent, inputWriter);

		for (int i = 0; i < text.length; i++) {
			if (text[i] == null) {
				inputTmp.setNum(i + 1);
				text[i] = inputTmp;
//				System.out.println(text[i].toString());
				break;
			}
		}
	}// end of 등록

	// 2.목록
	void listBoard() {
		boolean runList = true;
		int temp = 0;
		
		System.out.printf("%5s, %5s, %5s\n", "글번호", "제목", "작성자");
		for (int i = 0; i < text.length; i++) {
			if (text[i] != null) {
				System.out.printf("%5d, %5s, %5s\n", text[i].getNum(), text[i].getTitle(), text[i].getWriter());
//				System.out.printf("%n\n", text[i].getNum());
			}
		}
	}
			
//		while (runList) {
//			System.out.printf("%5s, %5s, %5s\n", "글번호", "제목", "작성자");	
//			for (int i = temp; i < text.length; i++) {
//				if (text != null) {
//					System.out.printf("%5n, %5s, %5s\n", text[i].getNum(), text[i].getTitle(), text[i].getWriter());
//				}
//				if((i+1) % 5 == 0) {
//					temp = i + 1;
//					break;
//				}
//			}
//			
//			System.out.print("<< 1: 이전\t2: 다음 >>\t||종료");
//			int inputNum = Integer.parseInt(sc.nextLine());
//
//			if(inputNum == 1) {
//				temp -= 5; 
//			}else if(inputNum == 2) {
//				continue;
//			}else {
//				runList = false;
//			}
			
//			for (int i = 5; i < 10; i++) {
//				if (text != null && inputNum == 2) {
//					System.out.printf("%5n, %5s, %5s\n", text[i].getNum(), text[i].getTitle(), text[i].getWriter());
//				}
//			}
//		}// end of while

//	}// end of 목록

	// 3.상세보기
	void detailBoard() {
		System.out.print("글 번호 입력>> ");
		int inputNum = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < text.length; i++) {
			if (text[i] != null && inputNum == text[i].getNum()) {
				System.out.printf("글번호: %d\t작성자: %s\n", text[i].getNum(), text[i].getWriter());
				System.out.printf("글제목: %s\n", text[i].getTitle());
				System.out.printf("글내용: %s\n", text[i].getContent());
				break;
			}
		}
	}// end of detail

	// 4. 수정
	void editBoard() {
		System.out.print("글 번호 입력>> ");
		int inputNum = Integer.parseInt(sc.nextLine());

		System.out.print("제목>> ");
		String inputTitle = sc.nextLine();

		System.out.print("글내용>> ");
		String inputContent = sc.nextLine();

		for (int i = 0; i < text.length; i++) {
			if (text[i] != null && inputNum == text[i].getNum()) {
				text[i].setTitle(inputTitle);
				text[i].setContent(inputContent);
				System.out.println("변경되었습니다.");
				break;
			}
		}
	} // end of edit

	// 5. 삭제
	void deleteBoard() {
		System.out.print("글 번호 입력>> ");
		int inputNum = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < text.length; i++) {
			if (text[i] != null && inputNum == text[i].getNum()) {
				text[i] = null;
				System.out.println("삭제되었습니다.");
				
				for (int j = i; j < text.length - 1; j++) {
//						Board temp = new Board(null, null, null);
//						temp = text[i];
						text[j] = text[j + 1];						
						text[j+1] = null;
						
						if(text[j] != null) {
							text[j].setNum(j + 1);
						}
				}
//				for(int k = i; k < text.length - 1; k++) {
//					text[j].setNum(j + 1);
//				}
				break;
			}
		}

	} // end of delete

}
