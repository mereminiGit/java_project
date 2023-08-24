package co.yedam.board;

import java.util.Scanner;

import co.yedam.board.control.BoardApp;
import co.yedam.mailing.SendMail;

public class MainExe {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		BoardApp app = new BoardApp();
		app.start();
	}
	
	public static void mailsend() {
		BoardApp app = new BoardApp();
		
		System.out.print("초기 비밀번호를 받을 이메일: ");
		String to = sc.nextLine();

		String title = "비밀번호 초기화";

//		System.out.print("내용: ");
		StringBuilder sb = new StringBuilder();
		sb.append("<h3> 비밀번호 초기화 메일입니다.</h3>"); // 태크도 넣어줄 수 있다
		sb.append("<p>12345</p>");
		String content = "비밀번호 초기화되었습니다.";
		sb.append("<p>"+content+"</p>");
		sb.append("<b>Bye</b>");
		
		content = sb.toString();

		SendMail sendMail = new SendMail();
		sendMail.sendMail(to, title, content);

	}
}
