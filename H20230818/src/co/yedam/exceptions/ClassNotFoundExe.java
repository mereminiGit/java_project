package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

// 일반 예외 (컴파일러가 빨간줄 뜨는)
public class ClassNotFoundExe {
	public static void main(String[] args) {
		// db 연결처리할 때 발생할 수 있는 예외
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // oracleDriver 사용하겟다
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // 오라클 주소 url , hr,
																									// hr(패스워드)
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			while (rs.next()) {
				System.out.println("사원번호: " + rs.getInt("employee_id") + " 이름: " + rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog.");
	}
}
