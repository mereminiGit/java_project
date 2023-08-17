package co.yedam.friend;

public class UnivFriend extends Friend{ // 생성자를 생성하지 않으면 오류가 뜸,  없는 기본 생성자를 만드려고 한다. -> 에러
	// 필드
	private String univ;
	private String major;
	
	// 생성자
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); // -> 부모 클래스의 기본 생성자를 의미 -> Friend에 기본 생성자가 없어서 오류 -> 부모 클래스 생성자에 맞게 설정해줘야함
		this.univ = univ;
		this.major = major;
	}
	
	// getter/setter
	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	// 오버라이딩
	@Override
		public String showInfo() {
			// TODO Auto-generated method stub
			return super.showInfo() + " 학교 " + univ + ", 전공 " + major;
		}
	
}
