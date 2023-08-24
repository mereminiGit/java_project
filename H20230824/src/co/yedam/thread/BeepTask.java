package co.yedam.thread;

import java.awt.Toolkit;

public class BeepTask implements Runnable{

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep(); // 소리 나게 함
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 0.5초 동안 기다리다가 소리나게
		}
	}

}
