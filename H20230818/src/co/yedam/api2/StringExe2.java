package co.yedam.api2;

public class StringExe2 {
	public static void main(String[] args) {
		// 파일명 추출
		String file = "C:/Dev/temp/flower.jpg";
		String result = StringUtils.getFileName(file);
		
		System.out.printf("파일명: %s\n",result);
		
		// 주민번호 구분
		String ssn = "950703-1234567";
		String ssnResult = StringUtils.checkGender(ssn);
		
		System.out.println("주민번호 판별: " + ssnResult);
		
		// 후보값;
		/*
		 * 
		 */
	}
}
