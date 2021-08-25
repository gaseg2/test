package azaz.nong.model.service;

import java.util.HashMap;
import java.util.List;

import javax.print.DocFlavor.READER;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import azaz.nong.model.Pagin;
import azaz.nong.model.ReplyDTO;
import azaz.nong.model.SellDTO;

@Service("sellDAO")
public class SellImpl implements SellService{

	@Autowired
	private SqlSessionTemplate dao2 = null;
	
	@Override
	public void insert(SellDTO dto) throws Exception {
		dao2.insert("sell.insert",dto);
		
	}
	
	public int getMaxNum() throws Exception{
		return dao2.selectOne("sell.maxNum");
	}
	public void fileUpdate(SellDTO dto) throws Exception{
		dao2.update("sell.fileUpdate",dto);
	}

	@Override
	public List selectAll(int startRow, int endRow) throws Exception {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return dao2.selectList("sell.selectAll",map);
	}

	@Override
	public void readcount(int num) throws Exception {
		
		 dao2.selectOne("sell.readcount", num);
	}

	@Override
	public void update(SellDTO dto) throws Exception {
		
		dao2.update("sell.update",dto);
	}

	@Override
	public void delete(int num) throws Exception {
		
		dao2.delete("sell.delete",num);
	}

	@Override
	public SellDTO content(int num) throws Exception {
		
		return dao2.selectOne("sell.content",num);
	}

	@Override
	public List<ReplyDTO> reply(int num) throws Exception {
		
		return dao2.selectList("sell.reply",num);
	}

	@Override
	public void insertReply(ReplyDTO rdto) throws Exception {
		dao2.insert("sell.insertReply",rdto);
		
	}

	@Override
	public void updateReply(ReplyDTO rdto) throws Exception {
		dao2.update("sell.updateReply",rdto);
		
	}

	@Override
	public void deleteReply(int re_no) throws Exception {
		System.out.println(re_no);
		dao2.delete("sell.deleteReply",re_no);
		
	}

	@Override
	public int totcontent() throws Exception {
		
		return dao2.selectOne("sell.allCount");
	}

	@Override
	public List searchList(String col, String search,int startRow,int endRow) throws Exception {
		HashMap map = new HashMap();
		map.put("col", col);
		map.put("search", search);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		return dao2.selectList("sell.search",map);
	}

	@Override
	public int totsearch(String col, String search) throws Exception {
		HashMap map = new HashMap();
		map.put("col", col);
		map.put("search", search);
		return dao2.selectOne("sell.searchCount",map);
	}

	

	

	

	

}
