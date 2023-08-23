package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReplyServiceImpl implements ReplyService{
	
	List<Reply> replyList = new ArrayList<>();
	
	public ReplyServiceImpl() {
		init();
	}

	// 파일 있는거 불러오기
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/reply.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			replyList = (List<Reply>) ois.readObject();
			
			ois.close();
			fis.close();
			
		} catch (Exception e) {
			// 처음 시작할 때 오류 안 뜨게
//			e.printStackTrace();
		}
	}
	
	// 글 번호 생성 메소드
	private int getMaxNo() {
		int replyNo = 0;
		
		for(int i = 0; i < replyList.size(); i++) {
			if(replyList.get(i).getReplyNo() > i) {
				replyNo = replyList.get(i).getReplyNo();
			}
		}
		return replyNo + 1;
	}
	
	// 등록 ------------------------------------
	@Override
	public boolean replyadd(Reply reply) {
		reply.setReplyNo(getMaxNo());
		
		return replyList.add(reply);
	}

	// 목록 -------------------------------------
	@Override
	public List<Reply> replyList(int brdNo) {
		List<Reply> outputList = new ArrayList<Reply>();
		
		for(int i = 0; i < replyList.size(); i++) {
			if(replyList.get(i).getBrdNo() == brdNo) {
				outputList.add(replyList.get(i));
			}
		}
		return outputList;
	}

	// 삭제 -------------------------------------
	@Override
	public boolean replyDelete(int replyNo) {
		for(int i = 0; i < replyList.size(); i++) {
			if(replyList.get(i).getBrdNo() == replyNo) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}

	// 파일 저장
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/reply.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(replyList);
			
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


















