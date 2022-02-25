package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankbook.BankBookDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	//update
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";

	}
	
	// update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception {
		System.out.println(noticeDTO.getNum());

		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	// delete
		@RequestMapping("delete")
		public String delete(NoticeDTO noticeDTO) throws Exception {
			int result = noticeService.delete(noticeDTO); // 숫자리턴하니까, 성공여부
			return "redirect:./list";
		}
	
	
	//detail
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public void detail(NoticeDTO noticeDTO,Model model)throws Exception{
		noticeDTO=noticeService.detail(noticeDTO);
		model.addAttribute("dto",noticeDTO);
	}
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv,Pager pager) throws Exception{
		List<NoticeDTO> ar =noticeService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("notice/list");
		return mv;
	}
	
	// DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);

		return "redirect:./list"; // 현재위치의 리스트, 앞으로 포워드하지말고 리다이렉트하세요, 인서트 후 리스트로 가기로 했으니 리스트적음
	}

	// insert form으로 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}
	
}
