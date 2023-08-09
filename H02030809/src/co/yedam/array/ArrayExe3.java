package co.yedam.array;


class Student{ // 이름과 점수를 담을 수 있는 공간
	String name;
	int score;
}

public class ArrayExe3 {
	public static void main(String[] args) {
		
		Student[] students = new Student[3];
		
		Student s1 = new Student(); // 공간을 할당하기
		s1.name = "홍길동";
		s1.score = 85;
		
		Student s2 = new Student(); // 공간을 할당하기
		s2.name = "김길동";
		s2.score = 80;
		
		Student s3 = new Student(); // 공간을 할당하기
		s3.name = "박길동";
		s3.score = 90;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
//		System.out.println(students[0].name+students[0].score);
		
		for(int i=0; i<students.length; i++) {
			System.out.println(students[i].name+", "+students[i].score);
		}
		
		int maxSt = 0;
		String nameSt = "";
		
		for(int i=0; i<students.length; i++) {
			if(students[i].score > maxSt) {
				maxSt = students[i].score;
				nameSt = students[i].name;
			}else continue;
		}
		
		System.out.println(maxSt+", "+nameSt);
		
		
		
		String[] names = {"홍길동", "김길동", "이길동", "박길동"};		
		int[] scores = {85, 88, 92, 75};
		
		// 젤 큰 점수의 학생 이름
		// name String
		
		int idx = 0, max = 0;
		// String name = "";
		
		for(int i=0; i<scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
				//name = names[i];
			}else continue;
		}
		
		for(int i=0; i<scores.length; i++) {
			if(scores[i] == max) {
				idx = i;
			}else continue;
		}
		System.out.printf("가장 높은 점수: %d, 학생: %s", scores[idx], names[idx]);
		
		
		
		
	}
}
