package co.yedam.mailing;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MainExe {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 음원실행 쓰레드 생성.
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				waveplayer();
			}

		}); // 프로그램 끝날때까지 스레드 실행됨
		thread.start();

		boolean run = true;

		while (run) {
			System.out.println("1.추가 2.목록 3.메일 4.종료");
			System.out.print("선택>> ");

			switch (sc.nextInt()) {
			case 1:
				System.out.println("추가합니다.");
				break;
			case 2:
				System.out.println("목록입니다.");
				break;
			case 3:
				sc.nextLine();
				mailsend();
				break;
			case 4:
				System.out.println("프로세스를 종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog");

//		sc.close();
	}

	static void waveplayer() {
		while (true) { // 메인이라는 쓰레드가 끝나더라도 생성된 메소드가 실행중이면 프로그램이 안 끝남
			try {
				File file = new File("C:/temp/sample.wav");
				AudioInputStream ais = AudioSystem.getAudioInputStream(file);

				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();

				Thread.sleep(clip.getMicrosecondLength() / 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void mailsend() {
		System.out.print("수신자 이메일: ");
		String to = sc.nextLine();

		System.out.print("제목: ");
		String title = sc.nextLine();

		System.out.print("내용: ");
		StringBuilder sb = new StringBuilder();
		sb.append("<p> 비밀번호 초기화 메일입니다.</p>"); // 태크도 넣어줄 수 있다
		sb.append("<p>12345</p>");
		String content = sc.nextLine();
		sb.append("<p>"+content+"</p>");
		sb.append("<b>Bye</b>");
		
		content = sb.toString();

		SendMail sendMail = new SendMail();
		sendMail.sendMail(to, title, content);

	}
}
