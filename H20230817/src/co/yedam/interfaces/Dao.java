package co.yedam.interfaces;

// 인터페이스
public interface Dao {
	// 규칙을 정하는게 목적 - 규칙선언.
	static final double pi = 3.14; // 상수라서 값을 선언해야함
	// static final이 기본으로 붙게 된다 - 인터페이스에서
	// 필드 자체가 상수
	
	// 인터페이스에서는 abstract를 안 적어도 기본적으로 추상메소드로 설정됨
	void insert();
	void update();
	void delete();
	void select();
}
