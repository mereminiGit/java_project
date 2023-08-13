package co.yedam.classes_0811.friend;

import java.util.Date;

// 접근지시자(access modifier)
// public 다른곳(패키지가 달라도)에서 불러서 사용 가능
// default 기본지시자 (패키지 다르면 안됨, 해당 패키지에서 사용가능)
// private 해당 영역 안에서만 (해당 클래서 안에서만 사용가능)

public class Friend extends Object { // 모든 클래스는 object를 상속해서 만들어짐 생략되기에
	// 필드
	
	
	private String name;
	private String phone;
//	private Date birth; // import 필요
	private String birth;
	
	// 생성자 -> 이클립스가 생성자 생성 만들어줌 / 우클릭 - 소스 - 밑에서 3번째
	public Friend(String name, String phone, String birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}


	// 메소드 get, set / 우클릭 - 소스 - 밑에서 7번째
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}


	// 소스 - 제럴레이트 부모 클래스가 가지고 있는 toSting() 재정의
	@Override
	public String toString() { // 주소값을 리턴하는것 -> 재정의해서 쓰면됨
		return "이름: " + name + ", 연락처: " + phone + ", 생일: " + birth;
	}

	
	

}
