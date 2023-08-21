package H20230821_Home.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("Lee", 80);
		map.put("Park", 80);
		
		Integer val = map.get("Lee");
		System.out.println(val);
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("user2", "1111");
		userMap.put("user3", "2222");
		
		if(userMap.containsKey("user2")) {
			System.out.println(userMap.get("user2"));
		}
		
		Set<String> keyset = userMap.keySet();
		Iterator<String> keyIterator = keyset.iterator();
		
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			String value = userMap.get(key);
			System.out.println(value);
		}
	}
}










