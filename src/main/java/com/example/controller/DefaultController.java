package com.example.controller;

/**
 * @author sharmila
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.service.AuthorManagerImpl;
import com.example.service.BookManagerImpl;


@Controller
@RequestMapping("/book")
public class DefaultController {

	@Autowired
	BookManagerImpl bookService;
	
	@Autowired
	AuthorManagerImpl authorService;

	@RequestMapping(method=RequestMethod.POST)
	public String insertBook(){
		Author author = insertAuthor();
		authorService.addNew(author);
		Book book=insert(1, author);
		bookService.addNew(book);
		Book book2 = insert(2, author);
		bookService.addNew(book2);
		return "home";
	}
//	@RequestMapping(method=RequestMethod.POST)
//	public void insertAuthor(Author author){
//	Book book=insert(1, author);
//		bookService.update(book);
//		
//	}
	
	public Author insertAuthor(){
		Author author = new Author();
		author.setId(1);
		author.setAuthorName("Sanjay");
		return author;
	}
	
	
	public Book insert(int bookId, Author author){
		
		Book book=new Book();
		book.setId(bookId);
		book.setAuthor(author);
		book.setBookName("journal dev " + bookId);
		return book;
	}
	
	//delete a row from tbl_book by passing id
	@RequestMapping(value="/{id}/delete",method=RequestMethod.POST)
	public void delete(Integer id){
		bookService.removeBy(1);
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	//get all data from tbl_book
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(Model model){
		System.out.println("get all method called");
	
		//Iterating through all data from tbl_book 
		Iterable<Book> result=bookService.findAll();
	
		System.out.println(result);
		for(Book r:result){
			
			System.out.println(r.getId()+","+r.getBookName());
		}
		model.addAttribute("result",result);
		
		return new ModelAndView("index");
	}
	
	
}
