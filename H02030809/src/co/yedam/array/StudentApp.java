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
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
		
		while(run) {
			System.out.println("1.등록, 2.조회, 3.목록, 4.종료");
			System.out.print("선택>>> ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1: // 이름, 점수 입력
				System.out.print("이름을 입력하세요>> ");
				students[idx].name = sc.nextLine();
				System.out.print("점수를 입력하세요>> ");
				students[idx].score = sc.nextInt();
				
				idx++;
				continue;
				
			case 2: // 이름 넣으면 점수 출력
				String temp = "";
				int tempNum = 0;
				
				System.out.print("점수를 보고싶은 이름을 입력하세요>> ");
				temp = sc.nextLine();
				
				for(tempNum=0; tempNum<students.length; tempNum++) {
					if(temp == students[tempNum].name) {
						System.out.printf("%s의 점수는 %d입니다.",temp, students[tempNum].score);
					}else continue;
				}
				
				continue;
			case 3: // 이름, 점수 전체
				for(int i=0; i<=idx; i++) {
					System.out.printf("이름: %s, 점수: %d\n", students[i].name, students[i].score);
				}
				
				continue;
			case 4:
				run = false;
				continue;
			default: 
				System.out.println("입력값이 잘못되었습니다.");
				continue;
			}
		}
		
		System.out.println("end of prog");
	}
}
