package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestService {

	//필드
	@Autowired
	private GuestBookDao guestBookDao;
	
	//메소드 - 일반
	public List<GuestBookVo> guestBookList() {
		
		List<GuestBookVo> guestList = guestBookDao.guestBookList();
		
		return guestList;
	}
	
	public GuestBookVo guestBookList(int no) {
		
		GuestBookVo guestList = guestBookDao.guestBookList(no);
		
		return guestList;
	}
	
	public int guestBookInsert(GuestBookVo guestBookVo) {
		int count = guestBookDao.guestBookInsert(guestBookVo);
		
		return count;
	}
	
	public int guestBookDelete(GuestBookVo guestBookVo) {
		int count = guestBookDao.guestBookDelete(guestBookVo);
		
		return count;
	}
	
	
	
}
