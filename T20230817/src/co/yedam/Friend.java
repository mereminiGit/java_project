package co.yedam;

// 친구의 정보를 저장하고 출력하는 기능 구현 / 저장할 정보는 친구이름, 전화번호, 생년월일, 키
public class Friend {
	// 필드
	private String name; 
	private String phone;
	private String birth;
	private double height;
	
	// getter/setter 메소드
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
}
