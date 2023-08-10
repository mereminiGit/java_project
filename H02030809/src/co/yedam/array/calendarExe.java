package co.yedam.array;

import java.util.Iterator;

public class calendarExe {
	// 달력. 31까지

	public static void main(String[] args) {
		int space = 2;
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();

		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i); // 일정한 3자리의 공간을 가지고 i를 출력하겠습니다.
			// 7일마다 줄 바꿈
			if ((i + space) % 7 == 0) {
				System.out.println();
			}
		}

		System.out.println();

		int month = 7;
		space = getFirstDay(month);
		days = new String[] { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();

		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		for (int i = 1; i <= getLastDate(month); i++) {
			System.out.printf("%4d", i); // 일정한 3자리의 공간을 가지고 i를 출력하겠습니다.
			// 7일마다 줄 바꿈
			if ((i + space) % 7 == 0) {
				System.out.println();
			}
		}
	}

	public static int getFirstDay(int month) {
		int day = 0; // 1월 1일 - 일요일
		int totalDays = 0;
		for (int i = 1; i <= month-1; i++) {
			totalDays += getLastDate(i);
		}

		day = (day + totalDays) % 7;

//		switch (month) {
//		case 1:
//		case 10:
//			day = 0;
//			break;
//
//		case 5:
//			day = 1;
//			break;
//
//		case 8:
//			day = 2;
//			break;
//
//		case 7:
//			day = 6;
//			break;
//
//		}
		return day;

	}

	public static int getLastDate(int month) {
		// 1-31, 2-28, 3-31, 4-30,
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		else if (month == 2)
			return 28;
		else
			return 30;

		/*
		 * lastDate = 31; switch (month){ case 4: case 6: case 9: case 11: lastDate =
		 * 30; case 2: lastDate = 28; } return lastDate;
		 */
	}
}
