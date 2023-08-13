package home.classes.calendar;

public class CalendarExe {
	public static void main(String[] args) {
		CalendarApp cal = new CalendarApp(2020, 2);
		
		System.out.printf("\t%s년 %3s월\n", cal.year, cal.month);
		cal.showCalendar();
	}
}
