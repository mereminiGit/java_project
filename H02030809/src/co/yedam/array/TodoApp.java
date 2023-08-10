package co.yedam.array;

public class TodoApp {
	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료
		// 등록: 1 할일 0812 / done false
		// 완료: 1 2 4 엔터 완료햇다고 하면 1 2 4 상태를 바꿔줌
		// 조회: 날짜를 입력하면 0812로 등록되어있는 일들을 보여줌  
		// 미완료: false로 되어있는것들 출력  // 1,2,4,3,6,5 이런 순으로 넣엇을때 순번기준으로 출력되게
		
		
		
		
		
		
	}

	public static void sortSample() {
		int[] intAry = { 45, 23, 90, 77, 12 };
		int len = intAry.length - 1;

		for (int j = 0; j < len; j++) {
			for (int i = 0; i < len; i++) {

				if (intAry[i] > intAry[i + 1]) {
					int temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}
	}
}
