package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Reply;

public interface ReplyService {
	// 댓글 등록
	public boolean replyadd(Reply reply);
	
	// 댓글 목록
	public List<Reply> replyList(int brdNo);
	
	// 댓글 삭제
	public boolean replyDelete(int replyNo);
	
	// 저장
	public void save();
}
