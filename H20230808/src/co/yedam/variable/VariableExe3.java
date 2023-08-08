package co.yedam.variable;

public class VariableExe3 {
	
	int num = 100;
	
	// 매소드, 함수
	public void showInfo() {
		// TODO Auto-generated method stub
		int num = 100 + this.num; // class에 소속되어 있는 변수를 가져올 때는 this.을 붙이고 사용한다
		System.out.println("num: "+num); // sysout ctrl+space
		int num1 = 200; // 로컬변수는 선언된 실행 블럭안에서만 유효값을 가짐.
	}
	
	public void printNum() {
//		System.out.println("num: "+num1); // num1은 showInfo안에서만 사용할 수 있는 변수라서 에러
	}
	
	public void helloMsg() {
		// TODO Auto-generated method stub
		int num = 200 + this.num;
		System.out.println("num: "+num);
	}
}
