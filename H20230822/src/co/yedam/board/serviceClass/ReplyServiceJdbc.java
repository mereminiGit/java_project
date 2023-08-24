package co.yedam.board.serviceClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.service.ReplyService;
import co.yedam.board.vo.Reply;

public class ReplyServiceJdbc implements ReplyService{

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	// DB 연결 종료
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
	
	
	// 등록 -------------------------------------------
	@Override
	public boolean replyadd(Reply reply) {
		query = "INSERT INTO reply\r\n"
				+ "VALUES ((select nvl(max(reply_no), 0) + 1 from reply), ?, ?, ?)";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, reply.getBrdNo()); // 원본 글 번호
			psmt.setString(2, reply.getReplyContent()); // 댓글 내용
			psmt.setString(3, reply.getReplyWriter()); // 댓글 작성자
			int r = psmt.executeUpdate();
			
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 목록 ----------------------------------------
	@Override
	public List<Reply> replyList(int brdNo) {
		List<Reply> replyList = new ArrayList<Reply>();
		conn = Dao.conn();
		
		query = "SELECT *\r\n"
				+ "FROM reply\r\n"
				+ "WHERE brd_no = ? "
				+ "ORDER BY reply_no";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setReplyContent(rs.getString("reply_content"));
				reply.setReplyWriter(rs.getString("reply_writer"));
				
				replyList.add(reply);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return replyList;
	}

	// 삭제 --------------------------------------------
	@Override
	public boolean replyDelete(int replyNo) {
		query = "delete from reply where reply_no =" + replyNo;
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return false;
	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
	
	
}
