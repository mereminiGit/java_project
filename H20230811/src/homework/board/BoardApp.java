package homework.board;

import java.util.Scanner;

public class BoardApp {
	Scanner sc = new Scanner(System.in);
	Board[] text = new Board[20];
	
	static void showBoard() {
		BoardApp tmp = new BoardApp();
		Scanner sc = tmp.sc;
		boolean run = true;
				
		while(run) {
			System.out.println("1.등록 2.목록 3.상세보기 4.수정 5.삭제 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: // 게시판 등록 (제목, 내용, 작성자)
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 5:
				
			case 9:
				
				default: 
					System.out.println("잘못 입력하였습니다.");
					
			}//end of switch
		}// end of while
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
		
		for(int i=0; i<text.length; i++) {
			if(text[i] == null) {
				inputTmp.setNum(i);
				text[i] = inputTmp;				
			}
		}
	}// end of 등록
	
	// 2.목록
	void listBoard() {
		System.out.printf("%5s, %5s, %5s\n", "글번호", "제목", "작성자");
		for(int i=0; i<text.length; i++) {
			if(text != null) {
				System.out.printf("%5n, %5s, %5s\n", text[i].getNum(), text[i].getTitle(), text[i].getWriter());
			}
		}
	}// end of 목록
	
	// 3.상세보기
	
	
	
	
	
	
	
	
	
	
	
}
