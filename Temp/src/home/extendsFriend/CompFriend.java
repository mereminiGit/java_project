package home.extendsFriend;

// 상속
public class CompFriend extends Friend{
	// 필드
	private String comp;
	private String dept;
	
	// 부모의 생성자를 생성해줘야 오류 발생 안 함 / 기본 생성자가 없을때
	public CompFriend(String name, String phone, String comp, String dept) {
		super(name, phone);
		this.comp = comp;
		this.dept = dept;
	}

	// getter / setter
	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String showInfo() {
		return super.showInfo() + " 회사는 " + comp + " 부서는 " + dept;
	}

}
