package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankbook.BankBookDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	
	@RequestMapping(value = "fileDown",method = RequestMethod.GET)
	public ModelAndView fileDown(NoticeFileDTO noticeFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeFileDTO = noticeService.detailFile(noticeFileDTO);
		
		mv.setViewName("fileDown"); //객체이름
		mv.addObject("file",noticeFileDTO);
		
		return mv;
		
	}
	
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO,Model model)throws Exception{
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto",boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public ModelAndView update(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.update(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(NoticeDTO noticeDTO) throws Exception{
		int result=	noticeService.delete(noticeDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		return mv;
	}

	
	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO,MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.add(noticeDTO,files);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public ModelAndView add()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
	}
	
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		mv.addObject("dto", boardDTO);  //조회해서 dto란 이름으로 보드 보내줌
		mv.setViewName("board/detail");
		return mv;
	}
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv,Pager pager) throws Exception{
		List<BoardDTO> ar =noticeService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}
}