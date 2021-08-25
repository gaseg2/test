package azaz.nong.model.service;

import azaz.nong.model.Test_userDTO;

public interface Test_UserService {

	
	public void insert (Test_userDTO dto) throws Exception;
	
	public int userCheck(String id) throws Exception;
	
	
}
