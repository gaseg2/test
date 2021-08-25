package azaz.nong.model.service;

import java.util.List;
import java.util.Map;

import azaz.nong.model.BoardDTO;
import azaz.nong.model.BreplyDTO;
import azaz.nong.model.ReplyDTO;
import azaz.nong.model.SellDTO;
import azaz.nong.model.NewsDTO;
import azaz.nong.model.NreplyDTO;

public interface NewsService {

	public List selectAll(int startRow,int endRow) throws Exception;
	
	public NewsDTO content(int num) throws Exception;

	public int totcontent() throws Exception;
	
	public void readcount(int num) throws Exception;
	
	
	public List<NreplyDTO> reply(int num) throws Exception;
	
	public void insertReply(ReplyDTO rdto) throws Exception;
	
	public void updateReply(ReplyDTO rdto) throws Exception;
	
	public void deleteReply(int re_no) throws Exception;
	
	
	public int recCheck(Map<String, Object> m) throws Exception;
	public void recUpdate(Map<String, Object> m) throws Exception;
	public void recDelete(Map<String, Object> m) throws Exception;
	public int recCount(int no) throws Exception;
	
}
