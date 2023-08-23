package H20230822_File.board;

import java.util.List;

public interface BoardService {
	public boolean add(Board board);
	
	public List<Board> list(int page);
	
	public int getTotal();
	
	public boolean modify(Board board);
	
	public boolean remove(int brdNo);
	
	public Board search(int brdNo);
	
	public void save();
}
