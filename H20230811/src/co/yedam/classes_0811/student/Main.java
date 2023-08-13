package co.yedam.classes_0811.student;

public class Main {
	public static void main(String[] args) { // 가장 먼저 실행되는 메소드 main
		Calculator cal = new Calculator(); // Cal클래스 사용하기 위해
						// -> 메모리 상에 만들어주는 과정
						// cal - 인스턴스
		
		double result = cal.sum(20, 40);
		System.out.println(result);
		
		
		// ------------------------------------
		
		// static 정적 메소드는 메모리에서 부르면 바로 사용할 수 있음
		double resultStatic = Calculator.multi(10, 20);
		System.out.println(resultStatic);
	}
}
