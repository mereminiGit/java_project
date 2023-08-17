package co.yedam;

import java.util.Scanner;

// 사용자의 입력을 받아 두 정수의 값을 num1, num2에 대입 / 두 수 사이의 값중 2의 배수, 2의 배수 합을 각각 sum2, sum3에 저장하고 출력
public class Ex02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Ex02 tmp = new Ex02();

		int num1 = tmp.inputNumber("숫자1 입력>> ");
		int num2 = tmp.inputNumber("숫자2 입력>> ");

		int sum2 = tmp.numSum(num1, num2, 2);
		int sum3 = tmp.numSum(num1, num2, 3);
		
		System.out.printf("%d와 %d 사이의 값 중 %d의 배수의 합은 %d입니다.\n", num1, num2, 2, sum2);
		System.out.printf("%d와 %d 사이의 값 중 %d의 배수의 합은 %d입니다.", num1, num2, 3, sum3);
	}

	// 입력
	private int inputNumber(String str) {
		System.out.print(str);
		return Integer.parseInt(sc.nextLine());
	}
	
	// 합 구하는 메소드
	private int numSum(int num1, int num2, int mul) {
		if(num1 > num2) {
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		
		int sum = 0;
		for(int i = num1; i < num2; i++) {
			if(i % mul == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
