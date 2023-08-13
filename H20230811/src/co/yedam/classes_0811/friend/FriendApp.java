package co.yedam.classes_0811.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FriendApp {
	// 필드
	Scanner sc = new Scanner(System.in);
	Friend[] friends = new Friend[10];

	// 생성자
	FriendApp() {

	}

	// 메소드

	// 친구 등록 메소드
	void addFriend() {
		System.out.println("이름 연락처 생년월일");
		String[] data = sc.nextLine().split(" ");
		// 950304
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birth = null; // String -> Date
//		try {
//			birth = sdf.parse(data[2]);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // 문자열 -> Date
//		
//		new Friend(data[0], data[1], birth);

		Friend friend = new Friend(data[0], data[1], data[2]);

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// addFriend

	// 친구 리스트 조회 메소드
	void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
	}

	// 친구 조회 메소드(이름 입력시 - 연락처, 생일)
	void findFriend() {
		System.out.print("조회할 이름을 입력>> ");
		String name = sc.nextLine();

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				System.out.printf("이름: %s, 연락처: %s, 생일: %s\n", friends[i].getName(), friends[i].getPhone(),
						friends[i].getBirth());
			}
		}
	}

	// 전화번호 수정 메소드(이름 입력시 - 전화번호 변경)
	void editFriend() {
		System.out.print("전화번호 수정할 이름을 입력>> ");
		String name = sc.nextLine();

		for (int i = 0; i < friends.length; i++) {
			if(friends[i] != null && name.equals(friends[i].getName())) {
				System.out.print("변경할 전화번호 입력>> ");
				String num = sc.nextLine();
				friends[i].setPhone(num);
				System.out.println("전화번호가 변경되었습니다.");
			}
//			else 
//				System.out.println("해당 이름은 없습니다");
//				break;
		}
//		System.out.printf("이름: %s, 연락처: %s, 생일: %s\n",friends[i].getName(), friends[i].getPhone(), friends[i].getBirth());
	}

	// 친구 삭제 메소드
	void delFriend() {
		System.out.print("삭제할 이름을 입력>> ");
		String name = sc.nextLine();

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				friends[i] = null;
				System.out.println("친구가 삭제되었습니다.");
			}
		}
	}
	
	
	static void start() { // 따로 선언 안해도 바로 사용할 수 있게 static

		FriendApp app = new FriendApp();
		Scanner sc = app.sc;
		boolean run = true;
		
		final int num = 0; // 값을 변경할 수 없는 변수
		
		while (run) {

			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.print("선택>> "); // findFriend/ editFriend(전화번호 변경)/ delFriend(이름 기준 삭제)

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case Menu.ADD: // 친구 등록 - 상수로 만든 값을 가져와서 사용
				app.addFriend();
				break;

			case Menu.LIST: // 친구 목록
				app.list();
				break;

			case Menu.SEARCH: // 친구 조회(이름 입력시 - 연락처, 생일)
				app.findFriend();
				break;

			case Menu.EDIT: // 전화번호 수정(이름 입력시 - 전화번호 변경)
				app.editFriend();
				break;
				
			case Menu.DEL: // 친구 삭제(이름 입력시 삭제)
				app.delFriend();
				break;
				
			case Menu.EXIT: // 이렇게 하면 코드를 볼때 가독성이 더 뛰어남 (상수로 만들어서)
				System.out.println("종료합니다.");
				run = false;
			} // end of switch
		} // end of while
	} // end of start 메소드

} // end of class
