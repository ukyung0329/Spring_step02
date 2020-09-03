package bit.com.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.Human;
import bit.com.a.dto.MyClass;

@Controller
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	
	//1번 
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info(" hello " + new Date());	//hello는 메소드
		
		MyClass cls = new MyClass(1001, "홍길동");
		model.addAttribute("mycls", cls);	//setAttribute와 동일, 짐싸  
		
		return "hello";	//가야 될 .jsp파일 
	}
	
	
	//2번
	@RequestMapping(value = "move.do", method = RequestMethod.GET)
	public String move() {
		logger.info(" move " + new Date());
		
		
		//	이동만 
		return "redirect:/hello.do";	//sendRedirect와 동일하며 컨드롤러->컨트롤러 이동방법 
		
		//	짐가지고 이동 		
		//return "forward:/hello.do"; //forward
	}
		
		
	//3번  
	@ResponseBody	//ajax 사용시 반드시 추가할 것 
	@RequestMapping(value = "idcheck.do", method = RequestMethod.GET,
				produces = "application/String; charset=utf-8")
	public String idcheck(String id) {
		logger.info(" idcheck " + new Date());
		logger.info(" id: " + id);
		
		String str = "오케이";
		return str;
	}
	
	
	
	// 4번  
	@ResponseBody
	@RequestMapping(value = "account.do", method = RequestMethod.POST)
	public Map<String, Object> account(Human my){
		logger.info("account" + new Date());
		logger.info(my.toString());		//콘솔에 
		
		//DB로 접근하는 처리
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "내가보낸 메세지입니다");
		map.put("name", "정수동");
		
		
		return map;
	}
	
	
	
	//5번 
	@ResponseBody
	@RequestMapping(value = "updateUser.do", method = RequestMethod.POST)
	public Map<String, Object> updateUser(@RequestBody Map<String, Object> map){	//map으로 받아 들이는데 필요함
		logger.info("updateUser"+ new Date());
		
		logger.info(map.get("name")+"");	//name은 Object라서 ""로 info에 문자열로 넣어줌
		logger.info(map.get("tel")+"");
		logger.info(map.get("email")+"");
		logger.info(map.get("birth")+"");
		
		
		//DB로 접근하는 처리
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("message", "내가보낸 메세지2");
		rmap.put("test", "리멥");
		
		
		return rmap;
	}
		
		
		
	
	@ResponseBody
	@RequestMapping(value = "pass.do", method = RequestMethod.POST)
	public List<MyClass> mylist(MyClass mycls){
		logger.info(mycls.toString());
		
		List<MyClass> list = new ArrayList<MyClass>();
		
		//list.add(index, element);
		list.add(0, new MyClass(1,"a"));
		
		
		return list;
		
	}
		
	
}
