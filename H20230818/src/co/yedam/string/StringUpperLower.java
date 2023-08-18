package co.yedam.string;

// toLowerCase() 소문자로 변경
// toUpperCase() 대문자로 변경
// equalsIgnoreCase() 대소문자 관계없이 값이 같은지 확인

public class StringUpperLower {
	public static void main(String[] args) {
		String str1 = "java programming";
		String str2 = "JAVA programming";
		
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.equalsIgnoreCase(str2));
		
	}
}
