package H20230821_Home.generic;

public class BoxMainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.set("Hello");
		String result = box.get();
		
		System.out.println(result);
	}
}
