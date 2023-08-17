package co.yedam.abstracts;

// 추상클래스 - 인터페이스랑 비슷한 부분이 잇음
public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	// 추상메소드 - 구현부분이 없는 메소드
	public abstract void sound(); // sound라는 메소드는 추상메소드 / 자식클래스에서 sound라는 매소드를 꼭 재정의 해야함 abstract로 만들어서
}
