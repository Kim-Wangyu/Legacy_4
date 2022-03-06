package com.iu.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.notice.NoticeDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value ="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(QnaDTO qnaDTO, Model model)throws Exception{
		System.out.println(qnaDTO.getNum());
		
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
	}

	
	//delete
	@RequestMapping("delete")
	public String delete(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.delete(qnaDTO); //숫자리턴하니까, 성공여부
		return "redirect:./list";
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(QnaDTO qnaDTO, Model model)throws Exception{
		qnaDTO= qnaService.detail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		
	}
	
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception{
		List<QnaDTO> ar =qnaService.list();
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		return mv;
	}
	
	
	//DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.add(qnaDTO);
		
		return "redirect:./list";		//현재위치의 리스트, 앞으로 포워드하지말고 리다이렉트하세요, 인서트 후 리스트로 가기로 했으니 리스트적음
	}
	
	//insert form으로 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
		
	}

}

