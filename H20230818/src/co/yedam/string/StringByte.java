package co.yedam.string;

// getByte() 매소드
// getByte(Charset charset) 매소드 - 주어진 문자셋으로 인코딩한 byte[]로 리턴


public class StringByte {
	public static void main(String[] args) {
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);
	}
}
