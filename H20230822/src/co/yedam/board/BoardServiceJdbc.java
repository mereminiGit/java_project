package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService {

	// Connection 객체. 필요 - db 접근(연결)하기 위한 객체
	// PreparedStatement 객체 - sql 쿼리 실행하기 위한 객체
	// ResultSet 객체. - 조회한(쿼리 실행한) 정로를 잠시 담아두는 객체
	// String 쿼리. - 문자열 타입에 쿼리 담아두고 활용

	// 필드 선언
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs; // set 컬렉션
	String query;

	@Override
	public boolean add(Board board) {
		return false;
	}

	// 목록
	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();

		conn = Dao.conn(); // db연결
		query = "select * from board"; // sql

		try {
			psmt = conn.prepareStatement(query); // 쿼리를 해석해서 받아오는 객체
			rs = psmt.executeQuery(); // 쿼리 해석한 결과를 가져오겟다는 의미

			while (rs.next()) { // 담겨있는 갯수만큼 반복
				// rs -> list로 변환
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no")); // 컬럼 이름
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // conn객체가 가지고 있는

		return list;
	}

	@Override
	public int getTotal() {
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		return false;
	}

	// 삭제
	@Override
	public boolean remove(int brdNo) {
		query = "delete from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 사용하는 / r에 처리된 건수를 반환해준다.
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 세부조회
	@Override
	public Board search(int brdNo) {
		query = "select * from board where brd_no = " + brdNo;
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select 경우
			if(rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void save() {

	}

}
