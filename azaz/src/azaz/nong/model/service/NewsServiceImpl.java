package azaz.nong.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import azaz.nong.model.NewsDTO;
import azaz.nong.model.NreplyDTO;
import azaz.nong.model.ReplyDTO;

@Service("newsDAO")
public class NewsServiceImpl implements NewsService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public List selectAll(int startRow, int endRow) throws Exception {
		
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return dao.selectList("news.selectAll",map);
	}

	@Override
	public NewsDTO content(int num) throws Exception {

		return dao.selectOne("news.content",num);
	}
	
	@Override
	public int totcontent() throws Exception {
		
		return dao.selectOne("news.allCount");
	}

	@Override
	public void readcount(int num) throws Exception {
		dao.selectOne("news.readcount",num);
		
	}

	
	
	@Override
	public List<NreplyDTO> reply(int num) throws Exception {
		
		return dao.selectList("news.reply",num);
	}

	@Override
	public void insertReply(ReplyDTO rdto) throws Exception {
		dao.insert("news.insertReply",rdto);
		
	}

	@Override
	public void updateReply(ReplyDTO rdto) throws Exception {
		dao.update("news.updateReply",rdto);
		
	}

	@Override
	public void deleteReply(int re_no) throws Exception {
		System.out.println(re_no);
		dao.delete("news.deleteReply",re_no);
		
	}

	
	
	
	
	
	
	
	@Override
	public int recCheck(Map<String, Object> m) throws Exception {
		
		int result = 0;
		result = (Integer) dao.selectOne("news.rec_check", m);
		return result;
	}

	@Override
	public void recUpdate(Map<String, Object> m) throws Exception {
		dao.insert("news.rec_update", m);
		
	}

	@Override
	public void recDelete(Map<String, Object> m) throws Exception {
		dao.insert("news.rec_delete", m);
		
	}

	@Override
	public int recCount(int no) throws Exception {
		
		int count = 0;
		count = (Integer) dao.selectOne("news.rec_count", no);

		return count;
	}
}
