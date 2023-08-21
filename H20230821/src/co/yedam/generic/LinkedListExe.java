package co.yedam.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();	// 같은 List의 인터페이스
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			list.add(0, "" + i); // 0번째에 값을 추가 하겠습니다.
			// 기존의 값을 계속 뒤로 밀어서 값을 추가함
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end - start) + "ms");
		
		list = new LinkedList<>();
		start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			list.add(0, "" + i); //	링크 연결관계만 수정하기에 ArrayList보다 빠름
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end - start) + "ms");
	}
}
