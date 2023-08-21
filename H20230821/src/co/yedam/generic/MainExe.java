package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("Hello");
		String result = box.get();	// 오브젝트 타입을 String 타입으로 케스팅
		
		Box<Integer> ibox = new Box<Integer>();
		ibox.set(10); // 10 (Integer) 값이다
		Integer iresult =  ibox.get();
		
		System.out.println(iresult);
	}
}
