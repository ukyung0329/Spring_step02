package bit.com.a.contoller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {

	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "bbslist.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbslist(Model model) {
		logger.info(" bbslist " + new Date());
		
		List<BbsDto> bbslist = service.getBbsList();
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist.tiles";		
	}
	
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite() {
		logger.info(" bbswrite " + new Date());
		return "bbswrite.tiles";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto dto) {
		logger.info(" bbswriteAf " + new Date());
		
		boolean b = service.writeBbs(dto);
		if(b) {
			logger.info("글 추가 성공!");
			return "redirect:/bbslist.do";	
		}else {
			logger.info("글 추가 실패");
			return "redirect:/bbslist.do";	
		}		
	}
	
	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(int seq, Model model) {
		logger.info(" bbsdetail " + new Date());
		
		BbsDto bbs = service.getBbs(seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value = "bbsSearchList.do", method = RequestMethod.GET)
	public String bbsSearchList(BbsParam param, Model model) {
		logger.info(" bbsSearchList " + new Date());
		
		List<BbsDto> bbslist = service.getBbsList(param);
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist.tiles";
	}
	
	
}








