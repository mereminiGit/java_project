package co.yedam.api2;

public class StringUtils {
	static String checkGender(String ssn) {
		// 주민번호 구분해서 남자, 여자, 오류인지 판별.
		String finalSsn = null;

		// 어떤 형태든 13값의 형태로 변환
		if (ssn.indexOf(" ") != -1) {
			int num = ssn.indexOf(" ");
			finalSsn = ssn.substring(0, num) + ssn.substring(num + 1);
//			System.out.println(finalSsn);
		} else if (ssn.indexOf("-") != -1) {
			int num = ssn.indexOf("-");
			finalSsn = ssn.substring(0, num) + ssn.substring(num + 1);
//			System.out.println(finalSsn);
		} else if (ssn.length() == 13) {
			finalSsn = ssn;
		} else {
			System.out.println("입력이 잘못되었습니다.");
		}
		
		int year = Integer.parseInt(finalSsn.substring(0, 2));
//		System.out.println(finalSsn);
		char gen = finalSsn.charAt(6);
		
//		System.out.println(gen);
		
		if (year > 23) {	

			switch (Integer.parseInt(gen)) {
			case 1:
				return "남자";
			case 2:
				return "여자";
			default:
				return "오류";
			}
		} else {
			switch (gen) {
			case 3:
				return "남자";
			case 4:
				return "여자";
			default:
				return "오류";
			}
		}

	}

	static String getFileName(String filePath) {
		// 전체경로에서 파일명만 추출.
		int startNum = filePath.lastIndexOf("/"); // 문자열 뒤에서부터 찾는 문자가 몇번째인지 리턴

		String fileName = filePath.substring(startNum + 1);

		return fileName;
	}
}
