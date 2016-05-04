package org.hanja.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hanja.domain.HanjaVO;
import org.hanja.persistence.WriteDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/writer")
public class WriterController {
	
	private static final Logger logger = LoggerFactory.getLogger(WriterController.class);
	
	@Inject
	WriteDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public void getWriter(HttpServletRequest request, Model model){
		logger.info("writerGet.........");
		
	}
	
	@RequestMapping(value = "/{Wnum}", method=RequestMethod.GET)
	public ResponseEntity<List<HanjaVO>> registerPOST(@PathVariable("Wnum") int Wnum, Model model, HttpServletRequest request)throws Exception{
		
		logger.info("registerPOST.........");
		
		logger.info("획수 "+Wnum);		
	
		List<HanjaVO> list = dao.getLetter(Wnum);
		
		for (HanjaVO vv : list) {
			System.out.println(vv);
		}
		model.addAttribute("Hanjas", list);
		
		return new ResponseEntity<List<HanjaVO>>(list, HttpStatus.OK);	
	}

}
