package azaz.nong.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import azaz.nong.model.MylistDTO;
@Service("myDAO")
public class MylistImpl implements MylistService {

	@Autowired
	private SqlSessionTemplate dao3 = null;
	
	
	@Override
	public void insert(MylistDTO dto) throws Exception {
		dao3.insert("mylist.insert",dto);
		
	}
	
	
	@Override
	public void delete(String name, String my_id) throws Exception {
		Map map = new HashMap();
		map.put("name", name);
		map.put("my_id", my_id);
		
		dao3.delete("mylist.delete",map);
	}



	@Override
	public List selectAll(String my_id, int startRow, int endRow) throws Exception {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("my_id", my_id);
		return dao3.selectList("mylist.selectAll",map);
		
	}


	@Override
	public int totcontent() throws Exception {
		
		return dao3.selectOne("mylist.allCount");
	}


	@Override
	public int confirmId(MylistDTO dto) throws Exception {
		
		return dao3.selectOne("mylist.userCheck",dto);
	}

}
