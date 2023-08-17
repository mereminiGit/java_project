package co.yedam.friend;

public class CompFriend extends Friend{
	// 필드
	private String comp;
	private String dept;
	
	// 생성자 - 부모클래스도 같이
	public CompFriend(String name, String phone, String comp, String dept) {
		super(name, phone);
		this.comp = comp;
		this.dept = dept;
	}
	
	// getter/setter
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
	
	// 오버라이딩
	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return super.showInfo() + " 회사는 " + comp + " , 부서는 " + dept;
	}
}
