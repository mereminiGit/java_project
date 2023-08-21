package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FriendApp {
	// 추가, 수정, 삭제, 목록:

	Map<String, String> userList = new HashMap<>();

	// 저장하는 공간이 배열이 아니고 컬렉션
	List<Friend> friends = new ArrayList<Friend>();
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// 생성자
	public FriendApp() {
		userList.put("user1", "1111");
		userList.put("user2", "2222");
		userList.put("user3", "3333");
	}

	//
	private boolean userCheck() {
		System.out.print("id입력>> ");
		String id = sc.nextLine();
		if (userList.containsKey(id)) {
			System.out.print("pw입력>> ");
			String pw = sc.nextLine();
			
			if (userList.get(id).equals(pw)) {
				return true;
			} else {
				System.out.println("pw가 맞지 않습니다.");
				return false;
			}
		} else {
			System.out.println("id가 없습니다.");
			return false;
		}
	}

	//
	public void start() {
		boolean run = true;

		
		while(run) {
			if(userCheck()) {
				break;
			}
			System.out.println("로그인 실패");
		}
		
		while (run) {
			System.out.println("=====================================");
			System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.목록 | 5.종료");
			System.out.print("선택>> ");

			int menu = -1;

			try {
				menu = Integer.parseInt(sc.nextLine());
				System.out.println("=====================================");
			} catch (NumberFormatException e) {
				System.out.println("문자가 입력되었습니다.");
				continue;
			}

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4:
				list();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1 ~ 5까지 입력하세요");
			}

		}
	}

	private void add() {
		System.out.print("이름 입력>> ");
		String name = sc.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = sc.nextLine();

		System.out.print("생년월일 입력(yyyy-mm-dd)>> ");
		String birth = sc.nextLine();

		// 생년월일 Date타입으로
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;

		try {
			birthDate = sdf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 컬렉션 추가
		friends.add(new Friend(name, phone, birthDate));
	}

	private void edit() {
		System.out.print("수정할 친구 이름 입력>> ");
		String name = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getName().equals(name)) {
				System.out.print("전화번호 입력>> ");
				String phone = sc.nextLine();

				System.out.print("생년월일 입력>> ");
				String birth = sc.nextLine();

				Date birthDate = null;
				try {
					birthDate = sdf.parse(birth);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				friends.get(i).setBirth(birthDate);
				friends.get(i).setPhone(phone);

				System.out.println("전화번호와 생년월일이 변경되었습니다.");
				check = true;
			}
		}

		if (!check) {
			System.out.println("없는 친구입니다.");
		}

	}

	private void delete() {
		System.out.print("삭제할 친구 이름 입력>> ");
		String name = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getName().equals(name)) {
				friends.remove(i);
				System.out.println("삭제되었습니다.");
				check = true;
			}
		}

		if (!check) {
			System.out.println("없는 친구입니다.");
		}
	}

	private void list() {
		for (int i = 0; i < friends.size(); i++) {
			System.out.printf("이름: %s, 전화번호: %s, 생년월일: %s\n", friends.get(i).getName(), friends.get(i).getPhone(),
					sdf.format(friends.get(i).getBirth()));
		}
	}
}
