package home.classes.calendar;

import java.util.Calendar;

public class CalendarApp {
	// 필드 생성
	int year;
	int month;

	// 생성자 생성 / 년,월 입력받아 해당 달력 출력 위해
	public CalendarApp(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}

	// 달력 보여주는 매소드
	void showCalendar() {

		// 현재 날짜를 알려주는 클래스
		Calendar cal = Calendar.getInstance();

		// 특별한 날짜를 지정해서 볼 때
		cal.set(year, month - 1, 1);

		// 달력 맨 위 요일 출력
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.printf("\n==============================\n");

		// 처음 요일
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		// 마지막 요일
		int lastDay = cal.getActualMaximum(Calendar.DATE);

		// 처음 요일까지 공백 출력
		for (int i = 0; i < firstDay-1; i++) {
			System.out.printf("%4s", " ");
		}
		// 마지막 날짜까지 요일별 숫자 출력
		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%4s", i);
			if ((firstDay - 1 + i) % 7 == 0) {
				System.out.println();
			}
		}

	}

}
