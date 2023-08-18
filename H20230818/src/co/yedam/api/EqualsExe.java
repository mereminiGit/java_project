package co.yedam.api;

// Object 클래스 
public class EqualsExe {
	public static void main(String[] args) {
		String str1 = new String("Hong"); // str1,2에는 주소값이 들어가 있다.
		String str2 = new String("Hong");

		System.out.println(str1); // toString을 안 붙여도 주소안에 있는 값이 출력됨
		System.out.println(str1 == str2); // 주소값을 비교하겠습니다. 아무리 값이 같아도 false

		System.out.println(str1.equals(str2)); // 주소값이 달라도 안에 있는 값이 같으면 true 반환
		
		Member mem1 = new Member(101, "Hong");
		Member mem2 = new Member(101, "Hong");
		
		System.out.println(mem1.equals(mem2));
		
		// 클래스 안의 두 필드의 값이 같을때 true를 반환하고 싶다
		// Object 클래스의 equals를 재정의한다.
	}
}

class Member {
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	
	// toString
	@Override
	public String toString() {
//		return super.toString();  // 16진수 해쉬코드 형태로 보여줌
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}


	// hashCode
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
//		return super.hashCode();
		return memberId;	// 1차적으로 memberId값이 같은지 비교함
	}
	
	// equals
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		return super.equals(obj);
		
		Member target = (Member) obj;	// obj를 Member로 캐스팅
		if(this.memberId == target.memberId 
				&& this.memberName.equals(target.memberName)) {
			return true; // 논리적 동일.
		} else {
			return false;
		}
	}
}


















