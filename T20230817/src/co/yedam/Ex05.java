package co.yedam;

import java.util.Scanner;

public class Ex05 {
	static Scanner sc = new Scanner(System.in);
	static Friend[] friends = new Friend[10];

	// 메인
	public static void main(String[] args) {

		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.전화번호 수정 4.삭제 5.종료");
			int menu = Integer.parseInt(inputData("선택"));

			switch (menu) {
			case 1: // 등록
				register();
				break;

			case 2: // 목록
				list();
				break;

			case 3: // 전화번호
				modify();
				break;

			case 4: // 삭제
				remove();
				break;

			case 5: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;

			default:
				System.out.println("입력이 잘못되었습니다.");
			}
		} // end of while
	} // end of main

	// 입력 메소드
	static String inputData(String str) {
		System.out.print(str + ">> ");
		return sc.nextLine();
	}

	// 1. 등록
	static void register() {
		Friend inputFriend = new Friend();

		inputFriend.setName(inputData("친구이름"));
		inputFriend.setPhone(inputData("전화번호"));
		inputFriend.setBirth(inputData("생년월일(YYMMDD)"));
		inputFriend.setHeight(Double.parseDouble(inputData("키")));

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = inputFriend;
				break;
			}
		}
	}

	// 2. 목록
	static void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.printf("이름: %s | 전화번호: %s | 생년월일: %s | 키: %.1f\n", friends[i].getName(),
						friends[i].getPhone(), friends[i].getBirth(), friends[i].getHeight());
			}
		}
	}

	// 3. 전화번호수정
	static void modify() {
		String name = inputData("전화번호 수정할 친구이름 입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				String editPhone = inputData("수정 전화번호");
				friends[i].setPhone(editPhone);
				break;
			}
		}
	}

	// 4. 삭제
	static void remove() {
		String name = inputData("삭제할 친구이름 입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				friends[i] = null;
				System.out.println("삭제되었습니다.");

				// 삭제시 배열값 앞으로 보내기
				for (int j = i; j < friends.length - 1; j++) {
					if (friends[j + 1] != null) {
						friends[j] = friends[j + 1];
						friends[j + 1] = null;
					}
				}
			}
		}
	}

}
