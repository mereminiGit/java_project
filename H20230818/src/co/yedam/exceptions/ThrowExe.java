package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 예외 떠넘기기
public class ThrowExe {
	public static void main(String[] args) {
		
		try {
			dbSearch();
		} catch (ClassNotFoundException | SQLException e) {	// catch되어 처리되는것이 같으면 | 로 연결해서 예외처리 할 수 있다.
			e.printStackTrace();
		}
		
		// 발생하는 모든 예외를 가장 상위에 있는 Exception으로 적어두어도 된다 -> 어떤한 예외도 상관없이 예외 발생하면 처리하겟다
	}
	
	public static void dbSearch() throws ClassNotFoundException, SQLException {	// 두 개의 예외가 발생해도 예외처리하지 않고 호출한 곳에서 예외처리하도록 하겠다.
		Class.forName("oracle.jdbc.OracleDriver");	// 여기서 예외 발생하면 호출한 곳에서 예외처리하도록 떠넘기는것
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from employees");
		while (rs.next()) {
			System.out.println("사원번호: " + rs.getInt("employee_id") + " 이름: " + rs.getString("first_name"));
		}
	}
}
