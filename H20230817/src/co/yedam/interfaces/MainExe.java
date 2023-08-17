package co.yedam.interfaces;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		// Dao dao = new MysqlDao(); // Dao 인터페이스를 구현하는 MysqlDao 클래스
		// 할당해주는 부분만 oracle로 변경하면 해당 기능을 바로 사용할 수 있다
		
		String str;
		Dao dao = new OracleDao();
		
		Scanner sc = new Scanner(System.in);
		boolean run = true; // start()의 지역변수
		int menu = 1;
		
		while (run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택>> ");
			menu = sc.nextInt(); // 3번 입력하고 Enter 치면 3만 가지고 와서 int로 처리
			sc.nextLine(); // -> Enter키까지 소진

			switch (menu) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.select();
				break;
			case 3:
				dao.update();
				break;
			case 4:
				dao.delete();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;

			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
	} // end of main
} // end of class
