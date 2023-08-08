package co.yedam.operator;

import java.util.Scanner;

/*
 * 은행 app.
 */
public class OperatorExe2 {
	public static void main(String[] args) {
		// import 단축키 ctrl shift o
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 잔액, 10만원이상 불가, -금액도 불가
		boolean run = true;
		
		while(run) {
			System.out.println("1.예금 / 2.출근 / 3.잔고 / 4.종료");
			System.out.print("선택>>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 1) {
				System.out.print("입금액을 입력>>> ");
//				if(balance > 100000 || balance < 0)
//					continue;
				int input = Integer.parseInt(scn.nextLine());
				if(input > 100000 || input < 0) {
					System.out.println("예금불가");
					continue;
				}else {
					balance += input;
					if(balance > 100000 || balance < 0) {
						balance -= input;
						System.out.println("예금불가");
						continue;
					}else {
//						balance += input;
						System.out.println("입금액은 "+input+"입니다.");
						System.out.println("잔액은 "+balance+"입니다.");						
					}
				}
			}else if(menu == 2) {
				System.out.print("출금액을 입력>>> ");
				int input = Integer.parseInt(scn.nextLine());
				
				if(input > 100000 || input < 0) {
					System.out.println("출금불가");
					continue;
				}else {
					balance -= input;
					if(balance > 100000 || balance < 0) {
						balance += input;
						System.out.println("출금불가");
						continue;
					}else {
						System.out.println("출금액은 "+input+"입니다.");
						System.out.println("잔액은 "+balance+"입니다.");						
					}
				}
			}else if(menu == 3) {
				System.out.println("잔액은 "+balance+"입니다,");
			}else if(menu == 4) break;
			else {
				System.out.println("입력값은 1, 2, 3, 4입니다.");
				continue;
			}
		}
		System.out.println("end of prog");
	}
}
