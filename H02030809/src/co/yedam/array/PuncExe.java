package co.yedam.array;

public class PuncExe {
	public static void main(String[] args) {
//		printStar();
		printStar(3);
		printString(3, "Hello");

		int n3 = sum(5, 7);
		System.out.println(n3);

		int[] intArr = { 5, 6, 7, 8, 9, 10 };
		int n4 = sum(intArr);
		System.out.println(n4);
		
		Friend fo = getFriend("aaa", "000-0000-0000", Gender.MEN);
		fo.showInfo();
	}
	
	
	public static void printStar() {
		System.out.println("*");
	}

	public static void printStar(int times) { // ()안에 들어있는걸 메개변수
		for (int i = 0; i < times; i++)
			System.out.println("*");
	}

	public static void printString(int times, String str) {
		for (int i = 0; i < times; i++)
			System.out.println(str);
	}

	public static int sum(int n1, int n2) { // int 타입으로 반환
		return n1 + n2;
	}

	public static int sum(int[] arr) { // 배열 반환
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) { // 반환하는 타입은 Friend
		Friend f = new Friend();
		f.name = name;
		f.phone = phone;
		f.gender = gender;
		
		return f;
	}
}
