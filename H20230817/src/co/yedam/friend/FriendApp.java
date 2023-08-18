package co.yedam.friend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendApp {
	// 배열 정보 저장 > 컬랙션에 저장 > 파일에 저장 > 오라클 DB에 저장
	Friend[] friends = new Friend[10];
	Scanner sc = new Scanner(System.in);

	// 컨트롤 - 사용자 입력에 따라
	public void start() {
		boolean run = true; // start()의 지역변수
		int menu = -1;

		while (run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택>> ");

			// ----------------------- try catch ------------------------------
			try { // 값을 잘못 입력했을때
				menu = sc.nextInt(); // 3번 입력하고 Enter 치면 3만 가지고 와서 int로 처리
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 다시 선택하세요");
//				sc.nextLine(); // nextInt라서 엔터를 소진해줘야함
				continue; // 반복문에서 continue를 만나면 밑으로 코드가 실행되지 않고 반목문 처음 부분으로 이동함
			} finally {
				sc.nextLine(); // -> Enter키까지 소진
								// 예외를 하더라고 예외일 때, 아닐 때 모두 엔터를 소진해야해서 finally에 넣어 항상 처리 될 수 있게 한다.
			}

			switch (menu) {
			case 1:
				addFriend();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;

			default:
				System.out.println("잘못된 입력입니다.");
			}

		}
	}

	// 공통된 이름, 연락처 입력하는 매소드
	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return sc.nextLine();
	}

	// 친구 등록
	private void addFriend() {
		int subMenu = -1;

		while (true) {
			System.out.println("1.학교 2.회사 3.기타");
			System.out.print("선택>> ");
			try {
				subMenu = sc.nextInt();
				if(subMenu != 1 && subMenu != 2 && subMenu != 3) {
					System.out.println("1, 2, 3 중에 선택 가능합니다.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력해주세요.");
				continue;
			} finally {
				sc.nextLine();
			}
		}

		Friend friend = null;
		String name = printString("이름입력");
		String phone = printString("연락처입력");

		if (subMenu == 1) {
			String univ = printString("학교입력");
			String major = printString("전공입력");

			friend = new UnivFriend(name, phone, univ, major);

		} else if (subMenu == 2) {
			String comp = printString("회사입력");
			String dept = printString("부서입력");

			friend = new CompFriend(name, phone, comp, dept);

		} else{
			friend = new Friend(name, phone);
		}

		// 배열에 값 넣기
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend; // Friend, CompFriend, UnivFriend를 다 담을 수 있다.
				break;
			}
		}
	}

	// 친구 조회 (이름 입력 -> 해당되는 것만 조회 / 엔터치면 전체 조회)
	private void search() {
		String inputName = printString("이름입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(inputName)) {
				System.out.println(friends[i].showInfo());
			} else if (friends[i] != null && inputName.equals("")) { // "" = Enter
				System.out.println(friends[i].showInfo());
			}
		}
	}

	// 친구 수정 (이름 입력받고 연락처 수정)
	private void modify() {
		String inputName = printString("이름입력");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && inputName.equals(friends[i].getName())) {
				String editPhone = printString("변경할 연락처 입력");
				friends[i].setPhone(editPhone);
				System.out.println("연락처가 변경되었습니다.");
			}
		}
	}

	// 친구 삭제 (이름 입력 친구 삭제)
	private void remove() {
		String inputName = printString("이름입력");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && inputName.equals(friends[i].getName())) {
				friends[i] = null;
				System.out.println("삭제되었습니다.");

				for (int j = i; j < friends.length - 1; j++) {
					friends[j] = friends[j + 1];
					friends[j + 1] = null;
				}
			}
		}
	}

}
