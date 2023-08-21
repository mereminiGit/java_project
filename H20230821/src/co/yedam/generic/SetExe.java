package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Hong");
		set.add("Kim");
		set.add("Park");
		set.add("Hong"); // 동일한 값은 안 가져온다.
		
//		set.remove("Hong");
		
		Iterator<String> iter = set.iterator(); // 반복자라고 한다.
		
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println(val);
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(11); // 인덱스 값으로 저장되므로 중복된 값 가져옴
		
		Set<Integer> iset = new HashSet<Integer>();
		
		for(Integer nom : list) {
			iset.add(nom);
		}
		
		for(Integer nom : iset) {
			System.out.println(nom);
		}
	}
}












