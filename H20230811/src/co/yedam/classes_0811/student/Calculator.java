package co.yedam.classes_0811.student;

public class Calculator {
	// 필드
	double pi = 3.14; // 인스턴스를 생성해야 존재하는 것을 인스턴스 멤버
	
	// 생성자 생략시 기본 생성자 만들어짐
	
	// 메소드 -> 인스턴스를 생성해야 존재하는 것을 '인스턴스 멤버'
	public double sum(double n1, double n2) {
		return n1 + n2;
	}
	
	public double minus(double n1, double n2) {
		return n1 - n2;
	}
	
	
	//-----------------------------------------
	
	public static double multi(double n1, double n2) {
		return n1 * n2;
	}
	
	// class가 메모리에 로딩될 때 static으로 하면 바로 사용할 준비가 되어있어 실행됨
}
