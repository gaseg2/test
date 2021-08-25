package azaz.nong.model.service;

import java.util.List;

import azaz.nong.model.MylistDTO;

public interface MylistService {

	public void insert(MylistDTO dto) throws Exception;
	
	public List selectAll(String my_id,int startRow,int endRow) throws Exception;
	
	public void delete(String name ,String my_id) throws Exception;

	public int totcontent() throws Exception;
	
	public int confirmId(MylistDTO dto) throws Exception;
}
