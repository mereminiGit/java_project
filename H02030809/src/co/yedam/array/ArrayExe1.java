package co.yedam.array;

public class ArrayExe1 {
	public static void main(String[] args) {
		
		// 배열선언
		int[] intAry = null; // 주소값이 들어가기 때문에 null로 초기화 가능하다
		intAry = new int[10]; // 정수값을 넣을 수 있는 공간 10개
		intAry = new int[] {12, 25, 57, 23}; 
		
		int[] intAry2 = {55, 47, 90};
		
		System.out.println(intAry[0]);
		
		intAry[0] = 22; // 값을 넣을 수 있음
		
		intAry = intAry2;
		
		int sum = 0;
		
		for(int i=0; i<intAry.length; i++) {
			sum += intAry[i];
		}
		System.out.printf("합: %d", sum);
		
	}
}





