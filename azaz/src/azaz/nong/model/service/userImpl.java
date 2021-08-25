package azaz.nong.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import azaz.nong.model.SellDTO;
import azaz.nong.model.userDTO;

@Service("userDAO")
public class userImpl implements user{

	@Autowired
	private SqlSessionTemplate dao = null;

	@Override
	public void insertUser(userDTO dto) {
		dao.insert("user.insert_user",dto);
	}
	
	@Override
	public void insertUser2(userDTO dto) {
		dao.insert("user.insert_user2",dto);
	}
	
	@Override
	public int userCheck(userDTO dto) {
		return dao.selectOne("user.userCheck",dto);
	}

	@Override
	public int userDelete(userDTO dto) throws Exception {
		int check = dao.selectOne("user.userCheck", dto);
		if(check == 1) {
			dao.delete("user.userDelete", dto);
		}
		return check;
	}

	@Override
	public int confirmId(userDTO dto) throws Exception {
		return dao.selectOne("user.userCheck", dto);
	}

	@Override
	public userDTO getUser(String id) throws Exception {
		return dao.selectOne("user.user",id);
	}

	@Override
	public void updateUser(userDTO dto) throws Exception {
		dao.update("user.updateUser",dto);
	}
	
	@Override
	public void updateUser2(userDTO dto) throws Exception {
		dao.update("user.updateUser2",dto);
	}

	@Override
	public userDTO searchId(String phone) throws Exception {
		return dao.selectOne("user.searchId",phone);
	}

	@Override
	public userDTO searchPw(userDTO dto) throws Exception {
		return dao.selectOne("user.searchPw",dto);
	}

	@Override
	public List selectWriter() throws Exception {
		return dao.selectList("user.selectWriter");
	}

	@Override
	public userDTO searchMap(String business_name) throws Exception {
		return dao.selectOne("user.searchMap", business_name);
	}

	@Override
	public List<SellDTO> mainList() throws Exception {
		
		return dao.selectList("user.mainList"); 
	}

	

	
	
	
	
}
