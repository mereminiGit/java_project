package H20230821_Home.generic;

public class Box <T> {
	// <T> 제너릭
	// 선언되는 시점에 타입을 정하겠다.
	
	// 필드
	T obj;
	
	//get set
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
