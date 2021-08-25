package azaz.nong.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import azaz.nong.model.service.MylistService;
import azaz.nong.model.service.user;

@Controller
@RequestMapping("/mylist/")
public class MylistBean {
	
	@Autowired
	private MylistService dao = null;
	@Autowired
	private user userDAO = null;
	//즐겨찾기 추가
	@RequestMapping("listInsert.do")
	public String insert(MylistDTO dto,Model model) throws Exception{
		
		dao.insert(dto);
		model.addAttribute("num",dto.getMnum());
		return "mylist/listInsert";
	}
	//즐겨찾기 목록 리스트화
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue = "1")int pageNum,HttpSession session) throws Exception{
		String my_id = (String)session.getAttribute("memId");
		int pageSize = 10;
	     int currentPage = pageNum;
	     int startRow = (currentPage - 1) * pageSize + 1;
	     int endRow = currentPage * pageSize;
	     int count = 0;
	     int number=0;
	     
	     count = dao.totcontent();
	     List list = null; 
	     if (count > 0) {
	            list = dao.selectAll(my_id, startRow, endRow);
	        }
	
		ModelAndView model = new ModelAndView();
		model.setViewName("mylist/list");//酉곕��  list.jsp濡� �꽕�젙
		model.addObject("list",list);//�뜲�씠�꽣 ���옣
		model.addObject("pageSize",pageSize);//�뜲�씠�꽣 ���옣
		model.addObject("currentPage",currentPage);//�뜲�씠�꽣 ���옣
		model.addObject("startRow",startRow);//�뜲�씠�꽣 ���옣
		model.addObject("endRow",endRow);//�뜲�씠�꽣 ���옣
		model.addObject("count",count);//�뜲�씠�꽣 ���옣
		model.addObject("number",number);//�뜲�씠�꽣 ���옣
		model.addObject("my_id",my_id);//�뜲�씠�꽣 ���옣
		
		return model;
	}
	//목록 삭제
	@RequestMapping("deletelist.do")
	public String delete(String name ,String my_id, Model model,HttpSession session) throws Exception{
		String id = (String)session.getAttribute("memId");
		model.addAttribute("name",name);
		model.addAttribute("my_id",my_id);
		return "mylist/deletelist";
	}
	//삭제 처리
	@RequestMapping("deletelistPro.do")
	public String deletePro(String name ,String my_id,HttpSession session) throws Exception{
		String id = (String)session.getAttribute("memId");
		dao.delete(name, my_id);
		return "mylist/deletelistPro";
	}
	@RequestMapping("confirmId.do")
	public String confirmId(MylistDTO dto,Model model) throws Exception{
		int check = dao.confirmId(dto);
		model.addAttribute("check",check);
		model.addAttribute("name",dto.getName());
		
		return "sell/content";
	}
}



















