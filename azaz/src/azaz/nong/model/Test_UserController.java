package azaz.nong.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import azaz.nong.model.service.Test_UserService;

@Controller
@RequestMapping("/cjm/")
public class Test_UserController {

	@Autowired
	private Test_UserService dao = null;
	
	@RequestMapping("insert.do")
	public String insert() throws Exception{
		return "test/insert";
	}
	
	@RequestMapping("insertPro.do")
	public String insertPro(Test_userDTO dto) throws Exception{
		dao.insert(dto);
		return "test/insertPro";
	}
	
	@RequestMapping("userCheck.do")
	@ResponseBody
	public int userCheck(@RequestParam("id") String id) throws Exception{
		
		return dao.userCheck(id);
	}
	
}
