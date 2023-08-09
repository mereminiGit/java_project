package co.yedam.condition;

public class ConditionExe {
	public static void main(String[] args) {
		// 임의의 수 random 1,2,3
		
		int num = (int)(Math.random() * 3) + 1;
		String str = "";
		
		switch (num) {
		case 1:
			str = "가위";
			break;
		case 2:
			str = "바위";
			break;
		default:
			str = "보";
		}
		System.out.printf("임의의 수: %d, 결과는 %s입니다.", num, str);
		
		char cha = 97; // 2byte짜리 정수 데이터 타입, 각각의 숫자에 문자가 맵핑되어져 있는 타입
		
		
		System.out.println("어떤 혜택을 원하세요?");
		char grade = (char)((Math.random() * 4) + 65); // 65,66,67,68
		// 큰 값에서 작은 값으로 바꿀때는 케스팅(강제 형 변환) 해야함 / 반대의 경우는 생략해도 됨
		// Math.random -> double 타입
		
		//147p, 4
		switch(grade) {
		case 'A':
			System.out.println("VVIP");
		}
		
		// "abc".equals("abc") // 문자열일때
		// char는 비교연산자로 비교 '' - char 타입은 '' 
		
	}
}
