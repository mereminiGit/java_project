package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		// ArrayList, HashSet: 중복된 값은 저장 불가
		
		Set<String> set = new HashSet<>();
		set.add("Hong");
		set.add("Hwang");
		set.add("Kim");
		set.add("Hong");
		
		for(String str : set) { // 순서없이 무작위로 가져옴 (순서로 나올때도 잇고)
			System.out.println(str);
		}
		
		Set<Member> memberSet = new HashSet<>();
		memberSet.add(new Member(101, "Hong"));
		memberSet.add(new Member(101, "Hong"));
		memberSet.add(new Member(102, "Hwang"));
		memberSet.add(new Member(103, "Kim"));
		// 동일한 값이 출력됨 -> 논리적으로 동일한 값이다라는걸 hashCode, equals같이 쓴다
		
		for(Member str : memberSet) { 
			System.out.println(str);
		}
	}
}
