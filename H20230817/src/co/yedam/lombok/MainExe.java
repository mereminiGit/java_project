package co.yedam.lombok;

public class MainExe {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student(100, "홍");
		s1.setName("홍길동");
		
		System.out.println(s1.toString());
	}
}
