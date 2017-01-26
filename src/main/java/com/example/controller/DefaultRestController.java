package com.example.controller;
/**
 * @author sharmila
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;

@RestController
public class DefaultRestController {

	//example for rest controller
	@RequestMapping(value="/about")
	public Book aboutBook(Book book){
		
		book.setId(1);
		book.setBookName("newbook");
		return book;
	}
	
}
