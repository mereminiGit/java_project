package home.extendsFriend;

// 상속
public class UnivFriend extends Friend{

	// 필드
	private String univ;
	private String major;
	
	// 생성자
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

	// gettet / setter
	
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


	// 부모 메소드 오버라이딩
	@Override
	public String showInfo() {
		return super.showInfo() + " 학교는 " + univ + " 전공은 " + major;
	}
	
}
