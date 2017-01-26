package com.example.controller;

/**
 * @author sharmila
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.service.AuthorService;
import com.example.service.BookService;


@Controller
@RequestMapping("/book")
public class DefaultController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;

	@RequestMapping(method=RequestMethod.POST)
	public String insertBook(){
		Author author = insertAuthor();
		authorService.save(author);
		Book book=insert(1, author);
		bookService.save(book);
		Book book2 = insert(2, author);
		bookService.save(book2);
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
		bookService.delete(1);
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	//get all data from tbl_book
	@RequestMapping(method=RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public ModelAndView getAll(Model model){
		System.out.println("get all method called");
	
		//Iterating througth all data from tbl_book 
		Iterable<Book> result=bookService.getAll();
	
		System.out.println(result);
		for(Book r:result){
			
			System.out.println(r.getId()+","+r.getBookName());
		}
		model.addAttribute("result",result);
		
		return new ModelAndView("index");
	}
	
	
}
