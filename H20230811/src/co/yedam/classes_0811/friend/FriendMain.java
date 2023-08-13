package co.yedam.classes_0811.friend;

public class FriendMain {
	public static void main(String[] args) { 
		// public 다른 패키지에서도 사용가능
		// static FriendMain이 가상으로 선언되면 바로 불러올 수 있음
		// void 반환되는 값 없습니다.
		// main 실행되는 메소드 / 클래스가 불러지면 가장 먼저 실행됨
		
		//String[] 매게 값 
		System.out.println(args[0] + args[1]);
		// Run configuration 아규먼트에서 값을 넣을때 나오게 하는 값
		
		FriendApp.start(); // 정적 메소드
		// 인스턴스 메소드 static이 없으면
		// 인스턴스 할당하고 
		
		/*
		 * FriendApp app = new FriendApp()
		 * app.start(); 
		 *
		 * static이 아닐때
		 */
		
		//Menu menu = new Menu();
		
		
	}
}
