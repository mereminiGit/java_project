package H20230821_Home.generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayList2Exe {
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<>();
		memList.add(new Member(1001, "Lee"));
		
		Member tmp = new Member(1010, "Park");
		memList.add(tmp);
		
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberId() == 1001) {
				memList.get(i).setMemberName("Hong");
			}
		}
		
		for(Member mem : memList) {
			System.out.println("이름: " + mem.getMemberName());
		}
		
	}
}
