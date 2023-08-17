package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
		// Animal animal = new Animal(""); 
		// - 추상클래스는 new로 인스턴스를 만들지 못함
		
		Animal animal = new Dog("멍멍이");
		animal.sound();
		
		animal = new Cat("야옹이");
		animal.sound(); // - 다형성이라고 함
	}
}
