package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestController {
	
	//등록폼 메소드
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("Controller > addList");
		
		//GuestDao만들기
		GuestBookDao guestBookDao = new GuestBookDao();
		List<GuestBookVo> guestBookVo = guestBookDao.guestBookList();
		
		model.addAttribute("gList",guestBookVo);
		
		return "/WEB-INF/views/addList.jsp";
	}

	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo guestBookVo) {
		System.out.println("Controller > add");
		
		//Dao만들기
		GuestBookDao guestBookDao = new GuestBookDao();
		guestBookDao.guestBookInsert(guestBookVo);
		
		return "redirect:/addList";
	}
	
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("Controller > deleteForm");
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		System.out.println("Controller > delete");
		
		//Dao만들기
		GuestBookDao guestBookDao = new GuestBookDao();
		GuestBookVo guestBookVo = guestBookDao.guestBookList(no);
		
		if(password.equals(guestBookVo.getPassword())) {
			
			guestBookDao.guestBookDelete(guestBookVo);
			System.out.println("삭제되었습니다.");
			return "redirect:/addList";	
		}else {
			System.out.println("패스워드가 틀렸습니다.");
			return "redirect:/addList";
		}
		
		
	}
	
	
	
	
	
	
}
