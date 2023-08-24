package co.yedam.board.serviceClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.service.UserService;
import co.yedam.board.vo.User;

// UserService 인터페이스 구현 클래스
public class UserServicejdbc implements UserService{
	// 로그인 하는데 DB에 있는 아이디와 패스워드가 똑같은지 비교하는 쿼리 만들어야함
	
	// DB연결 필드 선언
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs; // 여러건을 넣어두기 위한
	String query; // 쿼리 담아두는
	
//	List<User> userList = new ArrayList<>();
	
	void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User checkLogin(User user) {
		query = "SELECT * FROM users "
				+ "WHERE user_id IN (?) "
				+ "AND user_pw IN (?)";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			rs = psmt.executeQuery();
			
			if(rs.next()) { // id는 PK라서 if로 하는게 좋다 while 할 필요없음 중복값이 들어올 수 없기 때문
				User dbUser = new User();
				dbUser.setId(rs.getString("user_id"));
				dbUser.setPw(rs.getString("user_pw"));
				dbUser.setName(rs.getString("user_name"));
				return dbUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return null;
	}

}




