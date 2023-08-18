package co.yedam.friend;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		// name, phone,
		// 배열선언[5]. 인스턴스 3명
		// name 변수 3명중에 한명 찾는 기능

		Friend[] friendArr = new Friend[5];
		Scanner sc = new Scanner(System.in);

		friendArr[0] = new Friend("홍길동", "010-1111-2222");
		friendArr[1] = new Friend("김길동", "010-3333-2222");
		friendArr[2] = new Friend("박길동", "010-5555-2222");

		System.out.printf("찾을 이름 입력>> ");
		String name = sc.nextLine();

		for (int i = 0; i < friendArr.length; i++) {
			if (friendArr[i] != null && name.equals(friendArr[i].getName())) {
				System.out.println(friendArr[i].showInfo());
			}

		}
	}
}
