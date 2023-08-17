package co.yedam.interfaces;

public class MysqlDao implements Dao{ // 인터페이스
	// 인터페이스에서 가지고 있는 메소드들을 반드시 구현하기 위해 사용

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 입력기능");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 수정기능");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 삭제기능");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 조회기능");
	}  

}
