package co.yedam.operator;

public class OperatorExe {
	public static void main(String[] args) {
		
		int x, y;
		y = x = 2; // =(대입)연산자는 오른쪽에서부터 대입됨
		
		int result = x++ + 10;
		System.out.println("증감연산자 뒤에 사용할 경우 - "+result);
		
		result = ++y + 10;
		System.out.println("증감연산자 앞에 사용할 경우 - "+result);
		
		
		String str = "";
		// 삼항 연산자 -> if else 문 간단하게 
		if(x > 10) {
			str = "x는 10 이상입니다.";
		}else {
			str = "x는 10 미만입니다.";
		}
		
		str = (x >= 10) ? "x는 10 이상" : "x는 10 미만";
		System.out.println(str);
	}
}
