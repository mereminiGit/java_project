package co.yedam.string;

// String 클래스 charAt() 매소드 - 특정 위치의 문자를 리턴
// 문자 추출 () 매개값으로 주어진 인덱스의 문자를 리턴함
// 리턴 타입 char

public class StringCharAt {
	public static void main(String[] args) {
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
			
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
	}
}
