package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.service.BookService;
import com.example.entity.Book;

@Controller
public class TestingController {

	@Autowired
	BookService bookService;
	
//	@RequestMapping(value="/all")
//	@SuppressWarnings("unchecked")
//	public ModelAndView getAll(Model model){
//		System.out.println("get all method called");
//	
//		
//		Iterable<Book> result=bookService.getAll();
//	
//		System.out.println(result);
//		for(Book r:result){
//			
//			System.out.println(r.getId()+","+r.getBookName());
//		}
//	
//		model.addAttribute("result", result);
//		return new ModelAndView("index");
//	}
	
}
