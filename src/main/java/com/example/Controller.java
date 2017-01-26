package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.service.AuthorService;
import com.example.api.service.BookService;
import com.example.entity.Author;
import com.example.entity.Book;


@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;

	@RequestMapping("/")
	public String home(){
		Author author = insertAuthor();
		authorService.save(author);
		Book book=insert(1, author);
		bookService.save(book);
		Book book2 = insert(2, author);
		bookService.save(book2);
		return "home";
	}
	@RequestMapping("/update")
	public void update(Author author){
	Book book=insert(1, author);
		bookService.update(book);
		
	}
	
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
	@RequestMapping("/delete")
	public void delete(Integer id){
		bookService.delete(1);
	}
	
	@RequestMapping("/all")
	public void getAll(){
		System.out.println("get all method called");
	
		Iterable<Book> result=bookService.getAll();
	
		for(Book r:result){
			
			System.out.println(r.getId()+","+r.getBookName());
		}
	}
}
