package com.iu.s1.board.qna;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.file.FileDTO;
import com.iu.s1.member.MemberFileDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board") // 타이틀 이름에 notice, qna구분하는메서드
	public String board() {
		return "qna";
	}
	
	
	//fileDown
	@RequestMapping(value = "fileDown", method = RequestMethod.GET)
	public ModelAndView fileDown(QnaFileDTO qnaFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaFileDTO =qnaService.detailFile(qnaFileDTO);
		
	
		mv.setViewName("fileDown");  //파일 다운로드하는 클래스로감 원래는 jsp경로였음
		mv.addObject("file",qnaFileDTO);
		
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)  
	public ModelAndView reply(QnaDTO qnaDTO,ModelAndView mv)throws Exception{  //답글이라 DB안가도 됨, 폼으로만 감
		mv.addObject("dto", qnaDTO); //부모글번호가 여기있음
		mv.setViewName("board/reply");
		
		return mv;
	}
	
	
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO,Model model)throws Exception{
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto",boardDTO);
		return "board/update";
	}
	
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public ModelAndView update(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.update(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	

	
	

	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public ModelAndView add(QnaDTO qnaDTO,MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.add(qnaDTO,files);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public ModelAndView add()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
	}
	
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model)throws Exception{
		BoardDTO boardDTO = qnaService.detail(qnaDTO); //부모형이라서 qnaDTO도 되고 BOARD도 됨,근데 운반할때는 부모 객체Board로 운반
		model.addAttribute("dto",boardDTO);
		
		return "board/detail";
	}
	
	//list
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list(Pager pager,Model model)throws Exception{
		List<BoardDTO> ar= qnaService.list(pager);
		
		model.addAttribute("list",ar);
		
		return "board/list";
	}
	
}
