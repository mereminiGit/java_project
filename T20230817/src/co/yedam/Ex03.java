package co.yedam;

// 1에서 10 사이의 임의의 값을 5번 생성하여 정수형 배열에 저장하고 저장된 값중에서 최소, 최대값 출력하는 기능
public class Ex03 {
	public static void main(String[] args) {
		int[] numArr = new int[5];

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int) ((Math.random() * 10) + 1);
//			System.out.println(numArr[i]);
		}

		for (int i = 0; i < numArr.length - 1; i++) {
			for (int j = 0; j < numArr.length - 1; j++) {
				if (numArr[j] > numArr[j + 1]) {
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
				}
			}
		}
		
		System.out.printf("최소값: %d, 최대값: %d", numArr[0], numArr[4]);
	}
}
