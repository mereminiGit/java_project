package co.yedam.interfaces;

public class OracleDao implements Dao{
	// 오라클 DB로 변경되어서 프로그램을 다 변경해야할 때
	// 인터페이스를 두고 거기에 필수적으로 사용하라는 메소드를 이용하여 프로그램 기능을 구현하면 된다.

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 입력기능");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 수정기능");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 삭제기능");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 조회기능");
	}
}
