package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.service.GuestService;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	
	//등록폼 메소드
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("Controller > addList");
		
		//GuestDao만들기
		//GuestBookDao guestBookDao = new GuestBookDao();
		List<GuestBookVo> guestBookVo = guestService.guestBookList();
		
		model.addAttribute("gList",guestBookVo);
		
		return "addList";
	}

	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo guestBookVo) {
		System.out.println("Controller > add");
		
		//Dao만들기
		//GuestBookDao guestBookDao = new GuestBookDao();
		int count = guestService.guestBookInsert(guestBookVo);
		System.out.println(count);
		
		return "redirect:/addList";
	}
	
	@RequestMapping(value="/deleteForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(Model model, @PathVariable ("no") int no) {
		System.out.println("Controller > deleteForm");
		
		model.addAttribute("no",no);
		
		return "deleteForm";
	}
	
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		System.out.println("Controller > delete");
		
		//Dao만들기
		//GuestBookDao guestBookDao = new GuestBookDao();
		GuestBookVo guestBookVo = guestService.guestBookList(no);
		
		if(password.equals(guestBookVo.getPassword())) {
			
			int count = guestService.guestBookDelete(guestBookVo);
			System.out.println(count);
			System.out.println("삭제되었습니다.");
			return "redirect:/addList";	
		}else {
			System.out.println("패스워드가 틀렸습니다.");
			return "redirect:/addList";
		}
		
		
	}
	
	
	
	
	
	
}
