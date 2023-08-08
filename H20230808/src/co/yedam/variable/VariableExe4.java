package co.yedam.variable;

import java.io.IOException;

public class VariableExe4 {
	public static void main(String[] args) {
		// 이름은 홍길동, 나이는 20살 입니다.
		String name = "홍길동";
		int age = 20;
		double weight = 67.8;
		
		System.out.println("이름은 " +name+ ", 나이는 "+age+"살 입니다.");
		System.out.printf("이름은 %s, \t나이는 %d살 \t몸무게는 %.1f 입니다.\n", name, age, weight);
		// %.1f 소수점 1자리, %.2f 소수점 2자리
		// %s 문자열, %d 정수
		// \t 탭, \n 줄 바꿈
		
		
		// 입력
		System.out.print("값을 입력 >>> ");
		try {
			while (true) {
				int result = System.in.read();
				// enter 누르면 13, 10이 출력된다
				if (result == 113) {
					break;
				}else if(result == 10 || result == 13){
					// ENTER(cr:13, lf:10)
				} else {
					System.out.println("키코드: "+result);
					System.out.print("값을 입력 >>> ");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		System.out.println("end of prog.");
		
		
	} //end of main
} // end of class
