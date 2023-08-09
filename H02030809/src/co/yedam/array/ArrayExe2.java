package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		// 1 ~ 100 사이의 임의의 값
		// 5개의 합, 평균
		
//		numArr[0] = (int)(Math.random()*100+1);
		
		int num1 = 56, num2 = 72, num3 = 67;
		
		// 큰값:
		int[] sortArr = {num1, num2, num3};
//		sortArr[0] = num1;
//		sortArr[1] = num2;
//		sortArr[2] = num3;
		
		for(int i=1; i<sortArr.length; i++) {
			int temp;
			if(sortArr[i] > sortArr[i-1]) {
				temp = sortArr[i-1];
				sortArr[i-1] = sortArr[i];
				sortArr[i] = temp;
			}
		}
		for(int i=0; i<sortArr.length; i++) {
			System.out.printf("%d\t",sortArr[i]);
		}
		
		
		System.out.println("");
		
		int[] numArr = new int[5];
		int sum = 0;
		
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = (int)(Math.random()*100+1);
			System.out.printf("%d의 값 %d\n", i+1, numArr[i]);
			sum += numArr[i];
		}
		System.out.printf("배열의 합: %d\n", sum);
		System.out.printf("배열의 평균: %f", (double)sum/numArr.length);
	}
}
