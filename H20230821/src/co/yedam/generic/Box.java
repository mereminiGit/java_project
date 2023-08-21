package co.yedam.generic;

// T : type parameter
// <T> 제너릭
// 선언되는 시점에 데이터 타입을 정하겟다

public class Box <T>{
//	Object obj; // 오브젝트의 하위 다 가져올 수 있게 선언
				// 모든 데이터 타입으로 받기 위해
	
	T obj; // 박스가 사용될 때 타입을 정하는 것 - 제너릭
	
//	Object get() {
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
