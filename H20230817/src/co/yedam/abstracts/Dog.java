package co.yedam.abstracts;

public class Dog extends Animal{
	
	public Dog(String name) {
		super(name);
		
	}

	// sound라고 하는 매소드를 꼭 정의되어야 오류가 안 남
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}
