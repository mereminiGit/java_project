package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// Map이 없으면
class User{
	private String id;
	private String pw;
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	
	// 논리적으로 동등한 객체입니다를 만들어줌
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		User target = (User) obj;
		
		return this.id.equals(target.id) && this.pw.equals(target.pw);
	}
	
	

}


public class MapExe {
	public static void main(String[] args) {
		// Map: 키와 값 쌍으로 저장
		Map<String, Integer> map = new HashMap<>(); // 앞은 키 뒤는 값
		
		map.put("Hong", 80);
		map.put("Kim", 85);
		map.put("Park", 90);
		
		Integer val = map.get("Hong"); // Hong의 80이라는 값을 반환해줌
		System.out.println(val);
		
		
		List<User> users = new ArrayList<User>();
		users.add(new User("user1", "1234"));
		
		
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("user2", "1111");
		userMap.put("user3", "2222");
		userMap.put("user4", "3333");
		
		if(userMap.containsKey("user2")) { // 해당되는 key가 있는지
			System.out.println(userMap.get("user2"));
		}
		
		// key 반환. 메소드 써야함
		Set<String> keyset = userMap.keySet(); // set 컬렉션에 받아옴
		// key값이 string이라서 set<String>
		
		for(String key : keyset) {
			String value = userMap.get(key);
			System.out.printf("key: %s, val: %s\n", key, value);
		}
		
		// map
		Map<User, String> umap = new HashMap<>();// User가 클래스 이므로 키가 될 수 있다.
		umap.put(new User("user1", "1111"), "HONG");
		umap.put(new User("user1", "2222"), "KIM");
		umap.put(new User("user1", "3333"), "PARK");
		
		String name = umap.get(new User("user1", "1111"));
		System.out.println(name);
	}
	
	
	
}












