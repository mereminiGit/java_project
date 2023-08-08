package co.yedam.variable;

public class VariableExe2 {
	public static void main(String[] args) {
		// 변수 유형
		int num1 = 10; // 정수 값 하나만 담을 수 있음
		
		String str = "홍길동"; // str이라는 변수에 문자열을 담음
		str = "길동";
		
		// 홍길동, 20 두개의 값을 담고 싶다 (복합적인 유형의 타입) -> 클래스로 할 수 잇음
		// 변수에 여러 타입의 값을 넣고 싶을때, 복합형태의 값을 넣고싶을 때 클래스로 선언해서 넣어줄 수 잇음
		Person hong = new Person(); // 변수 유형 Person , 클래스의 경우에는 new에서 Person이라는 클래스 
		hong.name = "홍길동";
		hong.age = 20;
		hong.weight = 67.8;
		
//		hong = "홍길동"; // hong은 person이라는 데이터 타입이고 홍길동은 string이라서 타입이 달라 오류 발생
		
		hong = new Person(); // 다시 새로운 값을 넣어주니 모든 값이 초기화가 된다
		
		System.out.println("이름은 "+hong.name+", "
				           + "나이는 "+hong.age
				           + ", 몸무게는 "+hong.weight);
		
		
		VariableExe3 exe3 = new VariableExe3();
		exe3.showInfo();
		exe3.helloMsg();
	}
}
