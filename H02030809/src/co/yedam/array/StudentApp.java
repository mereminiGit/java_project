package co.yedam.array;

import java.util.Scanner;

//class Student{
//	String name;
//	int score;
//}

public class StudentApp {
	public static void main(String[] args) {
		// 1.등록 2.조회(학생 입력하면 성적 보여주는) 3.목록
 
		Student[] students = new Student[10];
		for(int i=0; i<students.length; i++) {
			students[i] = new Student(); // 공간 할당해줘야 null이 아님
		} // 공간 할당 안해주면 java.lang.NullPointerException 이라 오류 뜸
		
		Scanner sc = new Scanner(System.in); 
		Scanner sc1 = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
		
		while(run) {
			System.out.println("1.등록, 2.조회, 3.목록, 4.종료");
			System.out.print("선택>>> ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1: // 이름, 점수 입력
				System.out.print("이름을 입력하세요>> ");
				students[idx].name = sc1.nextLine();
				System.out.print("점수를 입력하세요>> ");
				students[idx].score = sc.nextInt(); // 이거 다음에 nextLine으로 입력 받으면 오류 발생
				
				/* nextInt()는 정수형을 입력 받는 메소드인데
				   사용자가 입력할 때 10을 치고 엔터를 누르면 엔터 앞부분까지만 입력받고
				   즉 개행문자를 제거하지 않아 그 다음 나오는 nextLine()이 개행문자를 받게 된다.
				   그래서 nextInt로 받았으면 sc.nextLine()으로 개행문자를 받고 / 다시 nextLine하면 됨
				*/
				idx++;
				continue;
				
			case 2: // 이름 넣으면 점수 출력
				String temp = "";
				int tempNum = 0;
				
				System.out.print("점수를 보고싶은 이름을 입력하세요>> ");
				temp = sc1.nextLine();
				
				for(tempNum=0; tempNum<students.length; tempNum++) {
					if(temp.equals(students[tempNum].name)) {
						System.out.printf("%s의 점수는 %d입니다.\n",temp, students[tempNum].score);
					}else continue;
				}
				
				continue;
				
			case 3: // 이름, 점수 전체
				for(int i=0; i<idx; i++) {
					System.out.printf("이름: %s, 점수: %d\n", students[i].name, students[i].score);
				}
				continue;
				
			case 4: // 종료
				run = false;
				continue;
				
			default: // 잘못 입력 
				System.out.println("입력값이 잘못되었습니다.");
				continue;
			}
		}
		
		System.out.println("end of prog");
	}
}
