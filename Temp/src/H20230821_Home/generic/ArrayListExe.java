package H20230821_Home.generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Hello");
		list.add(new String("World"));
		
		String result = list.get(0);
		System.out.println(result);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(String tmp : list) {
			System.out.println(tmp);
		}
		
		list.remove(0);
		list.clear();
	}
}









