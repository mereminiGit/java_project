package co.yedam.board.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	
	// 필드
	static Connection conn;
	
	// 메소드
	public static Connection conn(){ // 메소드가 정적으로 되면 반환하는 값도 정적으로 바꿔야함
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // oracleDriver 사용하겟다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj"); // 오라클 주소 url , hr,			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
