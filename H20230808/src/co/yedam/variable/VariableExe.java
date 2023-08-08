package co.yedam.variable;

public class VariableExe {
	public static void main(String[] args) {
		// 변수 선언
		// 정수형 변수의 유형 : byte(1byte), short(2byte), int(4byte), long(byte)
		// byte: -128 ~ 127
		// short: -32768 ~ 32767
		// int: -2147483648 ~ 2147483647
		// long: int보다 큰 값
		
		int num1 = 2;
		int num2 = 2147483647;
		
		// 초기화
//		num1 = 10;
//		num2 = 20;
		
		int result = num1 + num2;
		// 값의 범위가 넘어서면 다른 값이 나온다 -최솟값
		System.out.println("result: "+result);
		
		byte b1 = 10;
		byte b2 = 20;
		
		int b3 = b1 + b2; // 양쪽 항의 변수 타입은 서로 같아야한다. 
		//Type mismatch(변수의 유형): cannot convert from int to byte
		// byte를 더하기 하면 int타입으로 바뀜
		
		int i1 = 100;
		byte b4 = 10;
		
		b3 = i1 + (int)b4; // (int)가 없어도 작은 데이터 타입을 큰 데이터 타입으로 바꿔줌 - 케스팅
						   // 자동변환해서 연산
		
		
		// 실수타입.
		// float(4byte), double(8byte)
		
		double dbl1 = 10.23234;
		double dbl2 = 20;
		double dbl3 = dbl1 + dbl2;
		
		float f1 = 10.1F; // 실수는 따로 지정하지 않으면 double타입으로 인식함
		float f2 = 10.001f; // float타입의 실수라는걸 적어줘야함 뒤에 F, f를 적으면 됨
		
		float f3 = f1 + f2; // 정확한 값을 연산 못하고 근사치 값을 가져옴 4btye라는 범위
 		System.out.println("f3: "+f3);
		
	}
}













