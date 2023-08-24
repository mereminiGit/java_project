package co.yedam.thread;

import java.awt.Toolkit;

public class BeepPrintExe {
	public static void main(String[] args) { // main 하나의 스레드
		
		// 쓰레드 생성.
		// 1. Runnable 인터페이스를 구현하는 객체를 Thread 클래스 생성자의 (매개값)
//		Thread beep = new Thread(new BeepTask()); // runnable 구현하는 클래스
		// 2. Thread를 상속하는 클래스를 작성 
//		Thread beep = new WorkThread();
		// 1-1. Runnable 인터페이스를 구현하는 익명객체를 생성
//		Thread beep = new Thread(new Runnable() { // Runnable이라는 익명구현 객체를 run 안에 넣겟슴니다.
//			
//			@Override
//			public void run() { // Runnable은 인터페이스인데 구현해야하는 메소드는 run이라는 메소드 하나뿐
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				
//				for (int i = 0; i < 5; i++) {
//					toolkit.beep(); // 소리 나게 함
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					} // 0.5초 동안 기다리다가 소리나게
//				}		
//			}
//		});
		
		// Functional Interface (구현할 메소드 한개만 존재) 
		Thread beep = new Thread(() -> { // 메소드가 하나일 때 run 메소드 매개값만 남기고 -> 로 표현가능
			Toolkit toolkit = Toolkit.getDefaultToolkit();	
				for (int i = 0; i < 5; i++) {
					toolkit.beep(); // 소리 나게 함
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // 0.5초 동안 기다리다가 소리나게
				}		
			});
		
		beep.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 0.5초 동안 기다리다가 나타나게
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
