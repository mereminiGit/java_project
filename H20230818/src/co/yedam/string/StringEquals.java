package co.yedam.string;

// String 클래스 equals() 메소드 - 두 문자열을 비교
// 리턴타입 boolean
// 기본타입은 == 로 비교 / 문자열은 equals()
// Object 클래스에서는 번지 비교로 사용됨 / String클래스는 재정의해서 문자열 비교

public class StringEquals {
	public static void main(String[] args) {
		String str1 = new String("신민철");
		String str2 = "신민철";
		String str3 = "신민철";
		
		if(str3 == str2) {
			System.out.println("같은 String 객체를 참조");
		}else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(str3.equals(str2)) {
			System.out.println("같은 문자열을 가짐");
		}else {
			System.out.println("다른 문자열을 가짐");
		}
	}
}
