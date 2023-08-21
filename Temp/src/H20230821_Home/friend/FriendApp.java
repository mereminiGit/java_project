package H20230821_Home.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {
	
	Map<String, String> userList = new HashMap<>();
	
	List<Friend> friends = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	
	public void start() {
		boolean run = true;
		
		while(run) {
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
	
	private void list() {
		// TODO Auto-generated method stub
		
	}

	private void add() {
		System.out.print("이름 입력>> ");
		String name = sc.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = sc.nextLine();

		System.out.print("생년월일 입력(yyyy-mm-dd)>> ");
		String birth = sc.nextLine();
		
		Date tmpbirth = null;
		try {
			tmpbirth = sdf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		friends.add(new Friend(name, phone, tmpbirth));
	}
	
	private void edit() {
		System.out.print("수정할 친구 이름 입력>> ");
		String name = sc.nextLine();
		
		for(int i=0; i<friends.size(); i++) {
			if(friends.get(i).getName().equals(name)) {
				System.out.print("전화번호 입력>> ");
				String phone = sc.nextLine();
				
				friends.get(i).setPhone(phone);
			}
		}
	}
	
	private void delete() {
		System.out.print("삭제할 친구 이름 입력>> ");
		String name = sc.nextLine();
		
		for(int i=0; i<friends.size(); i++) {
			
		}
	}
}




















