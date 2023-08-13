package co.yedam.classes_0811.friend;

import java.util.Calendar;

public class CalendarApp {
	int year;
	int month;
	
	public CalendarApp(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}



	void showCalendar() {
		// Sun Mon Tue Wed Thr Fri Sat
//		this.year = year;
//		this.month = month;
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1); // 년, 월 지정하기

		// 맨 위 요일 출력
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.printf("\n=============================\n");

		// 처음 요일 숫자로 반환
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		// 달의 마지막 날
		int lastDay = cal.getActualMaximum(Calendar.DATE);

		// 첫 요일에 따라 공백 발생
		for (int i = 0; i < firstDay - 1; i++) {
			System.out.printf("%4s", " ");
		}
		for (int j = 1; j <= lastDay; j++) {
			System.out.printf("%4s", j);
			if ((j + firstDay - 1) % 7 == 0) {
				System.out.println();
			}
		}

	}
}
