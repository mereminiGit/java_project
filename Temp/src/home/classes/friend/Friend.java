package home.classes.friend;

public class Friend extends Object{
	// 필드
	private String name; // 이름
	private String phone; // 연락처
	private String birth; // 생일
	
	// 생성자
	public Friend(String name, String phone, String birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

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

	@Override
	public String toString() {
		return "이름: " + name + ", 연락처: " + phone + ", 생일: " + birth;
	}
	
	
	
	
}
