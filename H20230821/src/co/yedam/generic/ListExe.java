package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Hello");
		list.add(new String("World"));
		list.add("Good");
		
		String result = list.get(0); // 클래스이기 때문에 메소드로 가져오거나 넣을수잇다
		System.out.println(result);
		
		for(int i=0; i < list.size(); i++) { // 배열의 length와 같은 기능 .size()
			System.out.println(list.get(i));
			
		}
		
		list.set(1, "result");
		System.out.println("===수정후===");
		list.remove(1); // 해당 인덱스 값 삭제
		list.clear(); // 전체 삭제
		
		
		for(String str : list) {
			System.out.println(str);
		}
	}
}
