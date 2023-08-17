package co.yedam;

import java.util.Scanner;

// 사용자의 입력을 받아 정수의 두 수를 num1, num2에 대입하여 큰 수를 출력하도록 기능 구현
public class Ex01 {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {	
		Ex01 tmp = new Ex01();
		
		int num1 = tmp.inputNumber("숫자1 입력>> ");
		int num2 = tmp.inputNumber("숫자2 입력>> ");
		
		tmp.maxNumber(num1, num2);
	}
	
	// 입력
	private int inputNumber(String str) {
		System.out.print(str);
		return Integer.parseInt(sc.nextLine());
	}
	
	// 크기 비교
	private void maxNumber(int n1, int n2) {
		if(n1 > n2)
			System.out.println("큰 수는 " + n1 + "입니다.");
		else if(n1 < n2)
			System.out.println("큰 수는 " + n2 + "입니다.");
		else
			System.out.println("두 값은 같습니다.");
	}
}
