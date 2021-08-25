package azaz.nong.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import azaz.nong.model.service.SellService;
import azaz.nong.model.service.user;

@Controller
@RequestMapping("/user/")
public class userBean {

	@Autowired
	private user userDAO = null;
	@Autowired
	private SellService dao = null;
	
	@RequestMapping("insertUserForm.do")	// ������ ȸ������ ��
	public String insertUserForm() {
		return "user/insertUserForm";
	}
	
	@RequestMapping("insertUserForm2.do")	// ������ ȸ������ ��
	public String insertUserForm2() {
		return "user/insertUserForm2";
	}
	
	@RequestMapping(value="insertUserPro.do" , method=RequestMethod.POST)	// ������ ȸ������
	public String insertUserPro(userDTO dto) throws Exception{
		userDAO.insertUser(dto);
		return "user/insertUserPro";
	}
	
	@RequestMapping(value="insertUserPro2.do" , method=RequestMethod.POST)	// ������ ȸ������
	public String insertUserPro2(userDTO dto) throws Exception{
		userDAO.insertUser2(dto);
		return "user/insertUserPro2";
	}
	
	@RequestMapping("confirmId.do")
	   public String confirmId(userDTO dto , Model model)throws Exception {
	      int check = userDAO.confirmId(dto);
	      model.addAttribute("check",check);
	      model.addAttribute("id",dto.getId());
	      return "user/confirmId";
	   }
	   
	   @RequestMapping("confirmId2.do")
	   public @ResponseBody String confirmId2(userDTO dto , Model model)throws Exception {
	      int check = userDAO.confirmId(dto);
	      return check+"";
	   }
	
	@RequestMapping("loginForm.do")	//�α��� ��
	public String loginForm() {
		return "user/loginForm";
	}
	
	@RequestMapping("loginPro.do")	//������ �α��� üũ
	public String loginPro(userDTO dto ,HttpSession session , Model model) throws Exception{
		
		int check = userDAO.userCheck(dto);
	      if(check == 1) {
	         session.setAttribute("memId", dto.getId());
	      }
	      model.addAttribute("check", check);
		
		
		return "user/loginPro";
	}
	
	@RequestMapping("main.do")	//���� ������
	public String logon_main(HttpSession session , Model model) throws Exception {
		String id = (String)session.getAttribute("memId");
		userDTO c = userDAO.getUser(id);
		List list = userDAO.mainList();
				
 		model.addAttribute("list",list);
		model.addAttribute("c",c);
		return "user/main";
	}
	
	@RequestMapping("logout.do")	//�α׾ƿ�
	public String logon_logout(HttpSession session) {   
		session.invalidate();
		return "user/logout";
	}
	
	@RequestMapping("myPage.do")	//���� ������
	public String logon_myPage(HttpSession session , Model model) throws Exception {   
		String id = (String)session.getAttribute("memId");
		userDTO c = userDAO.getUser(id);
		model.addAttribute("c",c);
		return "user/myPage";
	}
	
	@RequestMapping("deleteForm.do")
	   public String logon_deleteForm(HttpSession session ) throws Exception {
	      return "user/deleteForm";
	}
	
	@RequestMapping("deletePro.do")
		public String logon_deletePro(HttpSession session , userDTO dto ,Model model) throws Exception {
			String id = (String)session.getAttribute("memId");
			dto.setId(id);
			int check = userDAO.userDelete(dto);
			
			if(check==1){
				session.invalidate();
			}
			
			model.addAttribute("check",check);
			
			return "user/deletePro";
		}
	
	@RequestMapping("modifyForm.do")
		public String logon_modifyForm(HttpSession session , Model model) throws Exception{

			String id = (String)session.getAttribute("memId");
			userDTO c = userDAO.getUser(id);
			model.addAttribute("c",c);
			return "user/modifyForm";
		}
	   
	@RequestMapping("modifyPro.do")
		public String logon_modifyPro(HttpSession session, userDTO dto) throws Exception {
			userDAO.updateUser(dto);
			return "user/modifyPro";
		}
	
	@RequestMapping("modifyForm2.do")
	public String logon_modifyForm2(HttpSession session , Model model) throws Exception{

		String id = (String)session.getAttribute("memId");
		userDTO c = userDAO.getUser(id);
		model.addAttribute("c",c);
		return "user/modifyForm2";
	}
   
	@RequestMapping("modifyPro2.do")
	public String logon_modifyPro2(HttpSession session, userDTO dto) throws Exception {
		userDAO.updateUser2(dto);
		return "user/modifyPro2";
	}
	
	@RequestMapping("searchId.do")	// ���̵� ã��
	public String searchId() {
		return "user/searchId";
	}
	
	@RequestMapping("searchIdPro.do")
		public String searchIdPro(@RequestParam String phone, Model model)throws Exception {
		userDTO c = userDAO.searchId(phone);
			userDAO.searchId(phone);
			model.addAttribute("c",c);
		return "user/searchIdPro";
	}
	
	@RequestMapping("searchPw.do")	//��й�ȣ ã��
	public String searchPw() {
		return "user/searchPw";
	}
	
	@RequestMapping("searchPwPro.do")
		public String searchPwPro(userDTO dto, Model model)throws Exception {
		userDTO c = userDAO.searchPw(dto);
			model.addAttribute("c",c);
		return "user/searchPwPro";
	}
	
	
	
	@RequestMapping("myWrite.do")
	public ModelAndView list() throws Exception{
		List list = userDAO.selectWriter();
		ModelAndView model = new ModelAndView();
		model.setViewName("sell/list");
		model.addObject("list",list);
		return model;
		
	}
	
	@RequestMapping("azazMap.do")	//��й�ȣ ã��
	public String azazMap(@RequestParam String id, Model model) throws Exception {
		userDTO c = userDAO.searchMap(id);
		userDAO.searchId(id);
		model.addAttribute("c",c);
		return "user/azazMap";
	}
	
	
	
	
	
}
