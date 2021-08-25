package azaz.nong.model;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import azaz.nong.model.service.BoardService;
import azaz.nong.model.service.user;
import azaz.nong.model.service.NewsService;
import azaz.nong.model.service.NewsServiceImpl;

@Controller
@RequestMapping("/news/")
public class NewsBean {

	@Autowired
	private NewsService newsDAO = null;
	
	@RequestMapping("content.do")
	public String content(int num, Model model) throws Exception{
		newsDAO.readcount(num);
		
		NewsDTO dto = newsDAO.content(num);
	 	model.addAttribute("dto",dto);
	 	
	 	List<NreplyDTO> reply = newsDAO.reply(num);
	 	model.addAttribute("reply",reply);
	 	
		return "news/content";
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue = "1")int pageNum) throws Exception{
		 int pageSize = 10;
	     int currentPage = pageNum;
	     int startRow = (currentPage - 1) * pageSize + 1;
	     int endRow = currentPage * pageSize;
	     int count = 0;
	     int number=0;
	     
	     count = newsDAO.totcontent();
	     List list = null; 
	     if (count > 0) {
	            list = newsDAO.selectAll(startRow, endRow);
	        }
	
		ModelAndView model = new ModelAndView();
		model.setViewName("news/list");
		model.addObject("list",list);
		model.addObject("pageSize",pageSize);
		model.addObject("currentPage",currentPage);
		model.addObject("startRow",startRow);
		model.addObject("endRow",endRow);
		model.addObject("count",count);
		model.addObject("number",number);
	
		return model;
	}
	
	
	
	@RequestMapping("replyinsert.do")
	public String replyinsert(ReplyDTO rdto,Model model) throws Exception {
		newsDAO.insertReply(rdto);
		model.addAttribute("dto",rdto);
		return "news/replyinsert";
	}
	@RequestMapping("replydelete.do")
	public String replydelete( @RequestParam int re_no, @RequestParam int num,Model model) throws Exception{
		newsDAO.deleteReply(re_no);
		model.addAttribute("dto",num);
		
		return "news/replydelete";
	}
	
	
	
	
	
	
	@RequestMapping("RecCount.do")
	public String RecCount(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시글 총 추천수를 구함
		int count = newsDAO.recCount(no);
		// 뷰페이지(boardContent.jsp)에 추천수를 출력하도록 하는 역할
		out.println(count);
		out.close();
		return null;
	}
	
	@RequestMapping("RecUpdate.do")
	public String RecUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		// no와 id값을 map에 저장
		Map<String, Object> m = new HashMap<>();
		m.put("no", request.getParameter("no"));
		m.put("id", request.getParameter("id"));
		
		// 동일 게시글에 대한 이전 추천 여부 검색
		int result = newsDAO.recCheck(m);
		
		if(result == 0){ // 추천하지 않았다면 추천 추가
			newsDAO.recUpdate(m);
		}else{ // 추천을 하였다면 추천 삭제
			newsDAO.recDelete(m);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
