package co.yedam.variable;
/*
 * Scanner 클래스 활용 / 입력
 */

import java.util.Scanner;

public class VariableExe5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 스캐너 어떤 값을 읽어 들이기 위한 (키보드를 통해 입력 받음), file 입력장치도 잇음
		
		String numStr = "123";
		int num = Integer.parseInt(numStr); // 문자열을 정수타입으로 바꾸는 명령 (문자열 안에 숫자만 있어야함)
											// "123" -> 123
		System.out.println(num);
		
		int sum = 0;
		
		while (true) {
			System.out.printf("정수값을 입력: 종료하려면 quit >>> ");
			String result = scan.nextLine(); // 입력값을 문자열로 반환. nextLine
			System.out.printf("입력값은 %s입니다.\n", result);
			if(result.equals("quit")) { // 문자열이면 비교연산자 ==가 안 먹음 .equals로 해야함
				break; // 반복문을 종료하겠습니다.
			}
//				else if(NumberUtils.isCreatable(result) == null) {
//				continue;
//			}
			else if (Integer.parseInt(result) >= 0 && Integer.parseInt(result) <= 100) {
				sum += Integer.parseInt(result);
			}else continue; // 다음 순번으로 넘어가는 것 / 조건 만족 못하면 다시 처리
			
			// 입력값이 100보다 크거나 0보다 작으면 합계 안하고 범위 안에 값만 합하도록
		}
		System.out.println("입력값의 합계는 "+sum);
		System.out.println("end of prog."); // 와일문이 무한 반복일때 이쪽으로 넘어오지 않는다고 에러 뜨는것
	}
}
