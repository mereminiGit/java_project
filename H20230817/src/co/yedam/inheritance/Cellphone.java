package co.yedam.inheritance;

public class Cellphone {
	// 필드
	private String model;
	private String color;
	
	// 기본 생성자
	Cellphone(){
		
	}
	
	// 메소드
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	
	// get, set 메소드 - 필드를 private로 설정해서	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override // 따로 정의하지 않더라도 모든 클래스는 가장 상위에 있는 Object를 상속 받는다.
	public String toString() {
		// TODO Auto-generated method stub
//		return super.toString();
		return color + ", " + model;
	}
}
