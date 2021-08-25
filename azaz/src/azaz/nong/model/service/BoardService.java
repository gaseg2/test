package azaz.nong.model.service;

import java.util.List;

import azaz.nong.model.BoardDTO;
import azaz.nong.model.BreplyDTO;
import azaz.nong.model.ReplyDTO;
import azaz.nong.model.SellDTO;

public interface BoardService {

public void insert(BoardDTO dto) throws Exception;
	
	public int getMaxNum() throws Exception;
	
	public void fileUpdate(BoardDTO dto) throws Exception;
	
	public List selectAll(int startRow,int endRow) throws Exception;
	
	public BoardDTO content(int num) throws Exception;
	
	public void readcount(int num) throws Exception;
	
	public void update(BoardDTO dto) throws Exception;
	
	public void delete(int num) throws Exception;
	
	public List<BreplyDTO> reply(int num) throws Exception;
	
	public void insertReply(BreplyDTO rdto) throws Exception;
	
	public void updateReply(BreplyDTO rdto) throws Exception;
	
	public void deleteReply(int re_no) throws Exception;
	
	public int totcontent() throws Exception;
	
	public int totsearch(String col, String search) throws Exception;
	
	public List searchList(String col, String search, int startRow, int endRow)throws Exception;
}
