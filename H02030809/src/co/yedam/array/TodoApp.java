package co.yedam.array;

import java.util.Scanner;

//public class Todo {
//	int no;
//	String todo;
//	String dueDate; // 0823 완료기간
//	boolean done; // true면 완료 false면 미완료
//}

public class TodoApp {
	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료
		// 등록: 1 할일 0812 / done false
		// 완료: 1 2 4 엔터 완료햇다고 하면 1 2 4 상태를 바꿔줌
		// 조회: 날짜를 입력하면 0812로 등록되어있는 일들을 보여줌
		// 미완료: false로 되어있는것들 출력 // 1,2,4,3,6,5 이런 순으로 넣엇을때 순번기준으로 출력되게

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Todo[] todoList = new Todo[10];
		for (int i = 0; i < todoList.length; i++) {
			todoList[i] = new Todo();
		}

		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.등록 | 2.완료 | 3.조회(날짜) | 4.미완료 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(sc.nextLine());

			switch (selectNo) {
			case 1:
				int idx = 0;
				System.out.print("우선순위 Todo 완료날짜>> ");
				String[] data = sc.nextLine().split(" ");
				todoList[idx].no = Integer.parseInt(data[0]);
				todoList[idx].todo = data[1];
				todoList[idx].dueDate = data[2];
				todoList[idx].done = false;

				idx++;
				break;

			case 2:

			case 3:
				System.out.print("조회 날짜>> ");
				String date = sc.nextLine();
				for (int i = 0; i < todoList.length; i++) {
					if (todoList[i] != null && date.equals(todoList[i].dueDate)) {
						System.out.printf("%d, %s", todoList[i].no, todoList[i].todo);
					} else
						continue;
				}
				break;
			case 4:

			case 5:
				run = false;
				break;

			default:
				System.out.println("입력값이 잘못되었습니다.");
			}
		}

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
