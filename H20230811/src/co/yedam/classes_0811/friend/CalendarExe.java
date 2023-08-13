package co.yedam.classes_0811.friend;

import java.util.Calendar; // ctrl shift o 하면 관련된 import 생성해줌

public class CalendarExe {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 현재 날짜를 가져다줌
		
		//특별한 날짜를 지정해서 보고싶다
		cal.set(2023, 0, 1); // 2023. 1. 1 MM은 보고싶은 날의 -1 해야함
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));  // 요일 정보(1-일요일, 2-월요일 ...
		System.out.println(cal.getActualMaximum(Calendar.DATE)); // 마지막 날짜
		
		
		/*
		System.out.println(cal.get(Calendar.YEAR)); // 값을 보고싶으면 get으로 들고오면 된다
		System.out.println(cal.get(Calendar.DATE)); 
		System.out.println(Calendar.YEAR); 
		*/
		
		
		
		CalendarApp calen = new CalendarApp(2023, 8);

		System.out.printf("\n%d년 %d월\n", calen.year, calen.month);
		calen.showCalendar();
	}
}
