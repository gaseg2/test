package azaz.nong.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import azaz.nong.model.Test_userDTO;
@Service("testDAO")
public class Test_UserServiceImpl implements Test_UserService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public void insert(Test_userDTO dto) throws Exception {
		dao.insert("test.insert",dto);
		
	}

	@Override
	public int userCheck(String id) throws Exception {
		
		
		return dao.selectOne("test.userCheck",id);
	}

}
