package co.yedam.array;

public class Friend {  // 친구의 정보를 저장하기 위한 클래스
	String name;  
	String phone;
	Gender gender;
	// 위는 속성들
	
	// 기능도 가질 수 있다.
	// 메소드 - 기능(함수)
	// 반환하려고 하는 타입을 앞에 적어줘야함, int 정수반환, String 문자열 반환, void 반환하지 않겠음
	
	void showInfo(){
		System.out.printf("이름:%s, 연락처:%s, 성별:%s\n", name, phone,
							gender == Gender.MEN ? "남" : "여");
	} // 반복되는 출력 기능을 메소드로 만들어서 사용하면 된다.
	
	void briefInfo() {
		System.out.printf("이름:%s, 연락처:%s", name, phone);
	}
}
