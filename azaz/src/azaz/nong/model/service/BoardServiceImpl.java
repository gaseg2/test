package azaz.nong.model.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import azaz.nong.model.BoardDTO;
import azaz.nong.model.BreplyDTO;
@Service("boardDAO")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSessionTemplate dao = null;
	
	@Override
	public void insert(BoardDTO dto) throws Exception {
		dao.insert("board.insert",dto);
		
	}
	public int getMaxNum() throws Exception {
		
		return dao.selectOne("board.maxNum");
	}
	public void fileUpdate(BoardDTO dto) throws Exception {
		dao.update("board.fileUpdate",dto);
		
	}

	@Override
	public List selectAll(int startRow, int endRow) throws Exception {
		
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return dao.selectList("board.selectAll",map);
	}

	@Override
	public BoardDTO content(int num) throws Exception {
		
		return dao.selectOne("board.content",num);
	}

	@Override
	public void readcount(int num) throws Exception {
		dao.selectOne("board.readcount",num);
		
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		dao.update("board.update",dto);
		
	}

	@Override
	public void delete(int num) throws Exception {
		dao.delete("board.delete",num);
		
	}

	@Override
	public List<BreplyDTO> reply(int num) throws Exception {
		
		return dao.selectList("board.reply",num);
	}

	@Override
	public void insertReply(BreplyDTO rdto) throws Exception {
		dao.insert("board.insertReply",rdto);
		
	}

	@Override
	public void updateReply(BreplyDTO rdto) throws Exception {
		dao.update("board.updateReply",rdto);
		
	}

	@Override
	public void deleteReply(int re_no) throws Exception {
		dao.delete("board.deleteReply",re_no);
		
	}

	@Override
	public int totcontent() throws Exception {
		
		return dao.selectOne("board.allCount");
	}
	
	@Override
	public List searchList(String col, String search,int startRow,int endRow) throws Exception {
		HashMap map = new HashMap();
		map.put("col", col);
		map.put("search", search);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		return dao.selectList("board.search",map);
	}

	@Override
	public int totsearch(String col, String search) throws Exception {
		HashMap map = new HashMap();
		map.put("col", col);
		map.put("search", search);
		return dao.selectOne("board.searchCount",map);
	}


}
