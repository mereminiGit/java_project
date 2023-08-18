package co.yedam.exceptions;

// 2023.08.18 - 예외 클래스
// 예외: 프로그램이 정상적으로 종료시점까지 진행되도록 하는게 큰 목적 (ex. 잘못된 값이 들어와도)
// 타입에 맞는 예외처리를 해줘야함

public class NullPointExe {
	public static void main(String[] args) {
		String msg = null; // String 클래스 msg 변수에 참고하는 값이 없다(null)
		msg = "hello"; // 값이 있으면 예외가 발생하지 않아서 try 블럭안에 있는 값을 처리하고 프로그램 종료

		try { // 예외가 발생할 수 있는 블럭을 감싸면 된다
			System.out.println(msg.toString());

			int val = Integer.parseInt(msg);
			System.out.println("결과는 " + val);
		} catch (NullPointerException e) { // NullPoint 와 같은 에러가 발생하면 실행할 코드를 블럭에 입력
			System.out.println("msg값이 null 참조합니다.");
			System.out.println("예외가 발생했습니다.");
		} // 예외가 발생하면 catch문의 값들을 실행시키고 프로그램을 종료됨
		catch (NumberFormatException e1) {	// NumberFormat와 같은 에러 발생하면 해당 블록내용 실행
			System.out.println("msg 값을 숫자로 변환할 수 없습니다.");
		}	// catch 여러개 사용가능, 프로그램을 실행하고 발생하는 에러들을 보고 해당 에러에 맞게 예외처리 해주면 됨
		finally {
			System.out.println("예외의 발생과는 상관없이 실행할 코드");
		}
		
		System.out.println("end of prog.");
	}
}
