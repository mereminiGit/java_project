package co.yedam.api;

// System 클래스
public class SystemExe {
	public static void main(String[] args) {

		long start = System.currentTimeMillis(); // 어떤 기능 실행 전 시각
		start = System.nanoTime(); // 더 작은 단위 / 더 세분화하려면
		
		for (int i = 0; i < 1000000; i++) {
			System.out.println(i);
		}
		
		long end = System.currentTimeMillis(); // 어떤 기능 실행 후 시각
		end = System.nanoTime();
		
//		System.out.println((end - start) + " ms");
		System.out.println((end - start) + " ns");
		
	}
}
