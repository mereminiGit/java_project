package co.yedam.api;

// String 클래스
public class StringExe {
	public static void main(String[] args) {
		
		byte[] bytes = {104, 101, 108, 108, 111}; 
		String str = new String(bytes); // byte로 문자열 할 수 잇고
		String str2 = new String(bytes, 0, 3); // 범위를 지정해 가져올 수 잇음
		
		System.out.println(str2);
		
		
		
	}
}
