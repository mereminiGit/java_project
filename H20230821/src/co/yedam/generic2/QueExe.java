package co.yedam.generic2;

import java.util.LinkedList;
import java.util.Queue;

// Queue : FirstInFirstOut
public class QueExe {
	public static void main(String[] args) {
		//큐는 링크드리스트로
		Queue<String> que = new LinkedList<>();
		
		que.offer("one");
		que.offer("two");
		que.offer("three");
		
		while (!que.isEmpty()) {
			String val = que.poll();
			System.out.println(val);
		}
	}
}
