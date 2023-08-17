package temp;

public class Example01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5]; // intAry[0] - 정수값 // 초기값 0

		int number = 1;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[i][j] = number;
				number++;
				System.out.printf("%5d", intAry[i][j]);
				System.out.printf("%5s", "[" + i + "," + j + "]");
			}
			System.out.println();
		}

		System.out.println("-----------------------------------------------------");
		
		number = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[j][i] = number;
				number++;
				System.out.printf("%5d", intAry[i][j]);
				System.out.printf("%5s", "[" + j + "," + i + "]");
			}
			System.out.println();
		}
		
//		System.out.println(intAry[2][2]);
		System.out.println("-----------------------------------------------------");
		// -----------------------------------------

		number = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[i][j] = number;
				number++;
				System.out.printf("%5d", intAry[j][i]);
				System.out.printf("%5s", "[" + j + "," + i + "]");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------");
		
		number = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[i][j] = number;
				number++;
			}
		}
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", intAry[j][i]);
				System.out.printf("%5s", "[" + j + "," + i + "]");
			}
			System.out.println();
		}
		
	}
}
