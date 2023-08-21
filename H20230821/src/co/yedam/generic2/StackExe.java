package co.yedam.generic2;

import java.util.Stack;

// Stack : LastInFirstOut 후입선출
// push, pop
public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		// 추가 메소드
		stack.push("One");
		stack.push("Two");
		stack.push("Three");

		// 빼는 메소드
//		String val = stack.pop(); // 뒤에서 부터 하나씩 빼기

		while (!stack.isEmpty()) { // 비어있지 않으면 출력 , isEmpty 비어있는지 스택이 
			String val = stack.pop();
			System.out.println(val);
		}
	}

}
