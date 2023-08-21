package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		// 날짜 처리해주는 클래스 Date
		
		Date today = new Date();
		
		// 원하는 형태로 출력하고 싶을 떄
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 생성자 메게변수로 원하는 포멧 넣어주면 됨
		
		System.out.println(today.toString()); // 출력은 우리가 원하는 값으로 나오진 않는다.
		System.out.println(sdf.format(today)); // 지정한 포멧으로 보여주세요 // Date -> String
		
		String strTime = "2023-09-01 13:22:33"; // 문자열 strTime 이걸 가지고 날짜 계산 못함
		
		try {
			Date newdate = sdf.parse(strTime);  // String -> Date  (parse라는 메소드 이용)
			System.out.println(newdate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
