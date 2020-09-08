package bit.com.a.contoller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login() {		// (외부로부터 들어오는 값(object, string), Model, HttpServletRequest)
		logger.info(" login " + new Date());
		
		return "login.tiles";	// -> *.jsp
	}
	
	@RequestMapping(value = "regi.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String regi() {
		return "regi.tiles";
	}
	
	@RequestMapping(value = "regiAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String regiAf(MemberDto dto) {
		logger.info(" regiAf " + new Date());
		
		boolean b = service.addmember(dto);
		if(b) {
			logger.info("회원 가입되었습니다");
			
		//	return "redirect:/login.do";			
			return "login.tiles";
		}
		logger.info("가입되지 않았습니다");
		return "regi.tiles";				
	}
	
	@RequestMapping(value = "loginAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginAf(MemberDto dto, HttpServletRequest req) {
		logger.info(" loginAf " + new Date());
		
		MemberDto login = service.login(dto);
		
		if(login != null && !login.getId().equals("")) {
			logger.info(" login success " + new Date());
			// session 저장
			req.getSession().setAttribute("login", login);
			//req.getSession().setMaxInactiveInterval(60 * 60);
			
			// 이동
			return "redirect:/bbslist.do";
			
		}else {
			logger.info(" login fail " + new Date());
			return "redirect:/login.do";
		}
		
	}
	
	
}









