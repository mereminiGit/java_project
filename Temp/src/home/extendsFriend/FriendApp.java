package home.extendsFriend;

import java.util.Scanner;

public class FriendApp {
	Friend[] friends = new Friend[10];
	Scanner sc = new Scanner(System.in);

	public void prog() {
		boolean run = true;
		int menu = 0;

		while (run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택>> ");

			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1: // 추가
				break;
				
			case 2: // 조회
				break;
				
			case 3: // 수정
				break;
				
			case 4: // 삭제
				break;
				
			case 5: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력");
			}
		} // end of while
	} // end of prog method
	
	// 입력하는 메소드
	private String inputdata(String msg) {
		System.out.println(msg + ">> ");
		return sc.nextLine();
	}
	
	// 1. 추가
	private void addFriend() {
		System.out.println("1.학교 2.회사 3.기타");
		System.out.println("선택>> ");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
