package azaz.nong.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import azaz.nong.model.ReplyDTO;
import azaz.nong.model.SellDTO;

public interface SellService {
	
	//게시글 작성
	public void insert(SellDTO dto) throws Exception;
	
	public int getMaxNum() throws Exception;
	//파일 업로드
	public void fileUpdate(SellDTO dto) throws Exception;
	//게시물 리스트
	public List selectAll(int startRow,int endRow) throws Exception;
	//게시글 상세보기
	public SellDTO content(int num) throws Exception;
	//조회수
	public void readcount(int num) throws Exception;
	//게시글 수정
	public void update(SellDTO dto) throws Exception;
	//게시글 삭제
	public void delete(int num) throws Exception;
	//댓글 리스트
	public List<ReplyDTO> reply(int num) throws Exception;
	// 댓글 작성
	public void insertReply(ReplyDTO rdto) throws Exception;
	//댓글 수정
	public void updateReply(ReplyDTO rdto) throws Exception;
	//댓글 삭제
	public void deleteReply(int re_no) throws Exception;
	//전체 게시글 수
	public int totcontent() throws Exception;
	//검색된 게시글 수
	public int totsearch(String col, String search) throws Exception;
	//검색된 게시물 리스트
	public List searchList(String col, String search,int startRow,int endRow)throws Exception;
	
	
	
}
