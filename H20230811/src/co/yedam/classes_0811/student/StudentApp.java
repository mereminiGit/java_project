package co.yedam.classes_0811.student;

public class StudentApp {

	public static void main(String[] args) {

		Student[] students = new Student[10];

		Student s1 = new Student();

		s1.setStdNo(100);
		s1.setStdName("홍길동");
		s1.setScore(100);
		students[0] = s1;

		students[1] = new Student(101, "김길동", 80);
		students[2] = new Student(101, "김길동", 80);
		students[3] = new Student(101, "김길동", 80);

		String searchName = "김길동";

		for (int i = 0; i < 10; i++) {
			if (students[i] != null && students[i].getStdName().equals(searchName)) {
				System.out.println(students[i].getStdNo());
			}
		}
	}
}