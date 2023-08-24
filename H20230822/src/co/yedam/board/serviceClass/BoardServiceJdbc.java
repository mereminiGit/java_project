package co.yedam.board.serviceClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.service.BoardService;
import co.yedam.board.vo.Board;

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
	
	// 추가 --------------------------------------------------------
	@Override
	public boolean add(Board board) {
		query = "insert into board (brd_no, brd_title, brd_content, brd_writer) " 
				 + "values ((select nvl(max(brd_no), 0) + 1 from board) , ?, ?, ?)"; // psmt로 쿼리 실행할때 나중에 값을 넣어주겠다. ? ?
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdTitle()); // 1번째 ?에 해당 값을 넣겟다
			psmt.setString(2, board.getBrdContent()); // 2번째 ?에 해당 값을 넣겟다
			psmt.setString(3, board.getBrdWriter()); // 3번째 ?에 해당 값을 넣겠다
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 사용하는 / r에 처리된 건수를 반환해준다. -> 쿼리 실행 부분 -> 쿼리가 이상하다 의미
			// 쿼리가 오류날때 디벨로퍼에 복사해서 쿼리 샐행해보고 쿼리 수정해 다시 query 구문에 넣어준다.
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 목록 --------------------------------------------------------
	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();

		conn = Dao.conn(); // db연결
		query = "SELECT *\r\n"
				+ "FROM(   SELECT rownum AS rn, a.*\r\n"
				+ "        FROM (  SELECT * \r\n"
				+ "                FROM board\r\n"
				+ "                ORDER BY brd_no) a \r\n"
				+ "        WHERE rownum <= (? * 5)) b \r\n"
				+ "WHERE b.rn > (? - 1) * 5"; // sql

		try {
			psmt = conn.prepareStatement(query); // 쿼리를 해석해서 받아오는 객체
			psmt.setInt(1, page);
			psmt.setInt(2, page);
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
		finally {
			disconn();
		}

		return list;
	}

	@Override
	public int getTotal() {
		int count = 0;
		query = "SELECT  COUNT(*) as cnt\r\n"
			  + "FROM    board";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return count;
	}

	// 수정 ---------------------------------------------------
	@Override
	public boolean modify(Board board) {
//		query = "update board set brd_content = '" + board.getBrdContent() + "' where brd_no = " + board.getBrdNo();
		// 위에처럼 처리하면 입력하기 불편해서 파라메타로 값을 넘겨주겠다로 처리할 수 있음
		// ''도 신경써야해서 오류나기 쉬움

		query = "update board set brd_content = ? where brd_no = ?"; // psmt로 쿼리 실행할때 나중에 값을 넣어주겠다. ? ?
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdContent()); // 1번째 ?에 해당 값을 넣겟다
			psmt.setInt(2, board.getBrdNo()); // 2번째 ?에 해당 값을 넣겠다
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 사용하는 / r에 처리된 건수를 반환해준다.
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
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
		} finally {
			disconn();
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
			if (rs.next()) {
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
		} finally {
			disconn();
		}

		return null;
	}

	@Override
	public void save() {

	}

	// 글번호 입력하면 작성자가 나오도록
	@Override
	public String getResponseUser(int brdNo) {
		query = "select * from board where brd_no = " + brdNo;
		conn = Dao.conn();
	
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select
			if(rs.next()) {
				return rs.getString("brd_writer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return null;
	}

}
