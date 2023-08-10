package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	static Friend[] friends = new Friend[10]; // 저장하기 위한 배열 선언, 공간은 10개로
	// 두 메소드에서 전부 접근하기 위해서
	static Scanner scn = new Scanner(System.in);
	static String phone;
	static String name;
	static Gender gender;
	
	// boolean checkFriend(String name) 메소드, 이름을 받아서 이름이 해당 배열에 있는지 없는지 반환
	public static boolean checkFriend(String name) { // 메인 메소드가 있는 곳에서 메소드 정의할때 public static
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].name.equals(name)) {
				return true;
			}
		}

		return false; // checkFriend를 통해 return 값이 전달
	}

	// ------------------------------------ 초기값 넣어주는 역할
	public static void init() {
		for (int i = 0; i < friends.length; i++) {
			Friend f = new Friend();
			f.name = "test" + i;
			f.phone = "010-1234-123" + i;
			f.gender = i % 2 == 0 ? Gender.MEN : Gender.WOMEN;

			friends[i] = f;
		}
	}

	// -------------------------------------
	public static void printMenu() {
		System.out.println("1.추가, 2.수정, 3.삭제, 4.조회, 5.목록, 6.종료");
		System.out.print("선택>>> ");
	}

	// -------------------------------------

	public static void add() {
		System.out.print("이름>> ");
		name = scn.nextLine();
		System.out.print("연락처>> ");
		phone = scn.nextLine();
		System.out.print("성별(1:남자, 2:여자)>> ");
//		Gender gender;
		int choice = Integer.parseInt(scn.nextLine());

		if (choice == 1) {
			gender = Gender.MEN;
		} else {
			gender = Gender.WOMEN;
		}

		Friend fnd = new Friend();
		fnd.name = name;
		fnd.phone = phone;
		fnd.gender = gender;

		boolean nullExist = false;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = fnd;
				nullExist = true;
				break;
			}
		}
		if (nullExist)
			System.out.println("저장성공");
		else
			System.out.println("저장실패");

//		System.out.println("저장되었습니다.");
	}

	// ------------------------------------
	public static void edit() {
		System.out.print("이름>> ");
		name = scn.nextLine();
		if (!checkFriend(name)) {
			System.out.println("이름이 없습니다.");
			//break; // case2번을 종료하겠습니다.
			return; // 메소드의 실행을 중지하겠습니다.
		}

		System.out.print("연락처>> ");
		phone = scn.nextLine();

		boolean nullExist2 = false;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				if (friends[i].name.equals(name)) {
					friends[i].phone = phone;
					nullExist2 = true;
					break; // for 반복문에 대한 break
				}

			}
		}
		if (!nullExist2)
			System.out.println("이름이 없습니다.");
	}
	
	// ------------------------------------
	public static void del() {
		System.out.print("이름>> ");
		name = scn.nextLine();

		if (!checkFriend(name)) {
			System.out.println("이름이 없습니다.");
//			break; // case2번을 종료하겠습니다.
			return;
		}

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].name.equals(name)) {
				friends[i] = null; // 삭제
				break;
			}
		}
	}
	
	// ------------------------------------
	public static void search() {
		System.out.print("이름>> ");
		name = scn.nextLine();

		if (!checkFriend(name)) {
			System.out.println("이름이 없습니다.");
//			break; // case2번을 종료하겠습니다.
			return;
		}

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null && friends[i].name.equals(name)) {
//				System.out.printf("이름: %s, 연락처: $s, 성별:%s", friends[i].name, friends[i].phone, 
//								   friends[i].gender == Gender.MEN ? "남" : "여");
				friends[i].showInfo(); // 메소드를 호출해서 출력기능을 하면 코드가 간단해짐
			}
		}
	}
	
	// ------------------------------------ 메인
	public static void main(String[] args) {
		// 추가, 수정, 삭제, 조회, 목록
		init();
		
		boolean run = true;

		// 초기값.
//		for(int i=0; i<friends.length; i++) {
//			Friend f = new Friend();
//			f.name = "test" + i;
//			f.phone = "010-1234-123" + i;
//			f.gender = i % 2 == 0 ? Gender.MEN : Gender.WOMEN;
//			
//			friends[i] = f;
//		}

		while (run) {
//			System.out.println("1.추가, 2.수정, 3.삭제, 4.조회, 5.목록, 6.종료");
//			System.out.print("선택>>> ");
			printMenu();

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				add();
				break;
				
			case 2: // 찾는 이름 잇는지 없는지
				edit();
				break; // switch 에 대한 break

			case 3: // 삭제
				del();
				break; // switch 에 대한 break

			case 4: // 이름 넣으면 연락처와 성별 조회 / 이름, 연락처, 성별
				search();
				break;

			case 5: // 목록 / 이름, 연락처
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] != null) {
//						System.out.printf("이름: %s, 연락처: %s\n", friends[i].name, friends[i].phone);
						friends[i].briefInfo();
					}
//					break;
				}

				break;

			case 6: // 종료
				run = false;

			default:
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
	}
}
