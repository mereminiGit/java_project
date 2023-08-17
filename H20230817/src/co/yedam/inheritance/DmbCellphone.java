package co.yedam.inheritance;

public class DmbCellphone extends Cellphone{ // extends로 상속받기
	// 자식에서만 있는 기능들을 설정
	
	// 필드
	private int channel; 
	
	public void changeChannel(int channel) {
		this.channel = channel;
	}
	
	public void turnOnDmb() {
		System.out.println("DMB를 켭니다.");
	}
	
	// 오버라이딩 - 부모 클래서 메소드 재정의(Overriding)
	
	@Override
		public void turnOn() {
			// TODO Auto-generated method stub
//			super.turnOn();  // super 부모를 가르킴 
			System.out.println(getModel() + "의 전원을 켭니다.");
		}
	
}
