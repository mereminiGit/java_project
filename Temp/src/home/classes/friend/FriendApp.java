package home.classes.friend;

import java.util.Scanner;

public class FriendApp {
	Scanner sc = new Scanner(System.in);
	Friend[] friends = new Friend[10];

	// 매소드
	// 출력하는 매소드
	static void showFriends() {
		FriendApp tmp = new FriendApp();
		Scanner sc = tmp.sc;
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case Menu.ADD: // 등록
				tmp.addFriend();
				break;
				
			case Menu.LIST: // 목록
				tmp.list();
				break;
				
			case Menu.FIND: // 조회(이름 입력시 - 연락처, 생일)
				tmp.findFreinds();
				break;
				
			case Menu.EDIT: // 전화번호 수정(이름 입력시 - 전화번호 변경)
				tmp.editFriend();
				break;
				
			case Menu.DELETE: // 친구 삭제 (이름 입력시 삭제)
				tmp.delFriend();
				break;
				
			case Menu.EXIT: // 종료
				System.out.println("종료합니다.");
				run = false;
				break;

			default:
				System.out.println("잘못 입력하였습니다.");
			}// end of switch
		} // end of while
	}// end of show 매소드

	void addFriend() {
		System.out.println("이름\t연락처\t생년월일");
		String data[] = sc.nextLine().split(" ");

		Friend friend = new Friend(data[0], data[1], data[2]);

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// end of addFriend

	void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());		
			}
		}
	}// end of list
	
	void findFreinds() {
		System.out.print("조회할 이름 입력>> ");
		String name = sc.nextLine();
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && name.equals(friends[i].getName())) {
				System.out.println(friends[i].toString());
			}
		}
	}// end of find
	
	void editFriend() {
		System.out.print("연락처 수정할 이름 입력>> ");
		String name = sc.nextLine();
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && name.equals(friends[i].getName())) {
				System.out.print("변경할 연락처 입력>> ");
				String newPhone = sc.nextLine();
				friends[i].setPhone(newPhone);
				System.out.println("연락처가 변경되었습니다.");
			}
		}
	}//end of edit
	
	void delFriend() {
		System.out.print("삭제할 이름 입력>> ");
		String name = sc.nextLine();
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && name.equals(friends[i].getName())) {
				friends[i] = null;
				System.out.println("친구가 삭제되었습니다.");
			}
		}
	}//end of del
	
}
