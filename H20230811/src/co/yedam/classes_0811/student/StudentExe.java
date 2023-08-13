package co.yedam.classes_0811.student;

// 실행을 위한 클래스
public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(); // Student()-기본 생성자 int 0으로 초기화 되어있는거 가져오고 String null로 초기화 되어있는거 가져옴
		s1.stdInfo(); // 초기화 된 값을 볼 수 있음
		
//		s1.stdNo = 100;
		s1.setStdNo(100); // 매게값을 통해 값을 넣는다
//		s1.stdName = "Hong";
		s1.setStdName("Hong");
//		s1.score = 80;
		s1.setScore(80);
		s1.stdInfo(); 
		
		// 학생 이름만 출력하고 싶다
		System.out.println(s1.getStdName());
		
		Student s2 = new Student(101); // ctrl 누르고 생성자 클릭하면 생성자 선언되어 있는 곳으로 이동
		s2.stdInfo();
		
		Student s3 = new Student(101, "Hong");
		s3.stdInfo();

		Student s4 = new Student(101, "Hong", 80);
		s4.stdInfo();
		
		
	}
}
