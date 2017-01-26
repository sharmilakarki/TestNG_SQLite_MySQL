package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.BookRepositoryCustom;
import com.example.entity.Book;

@Service
public class BookService {

	@Autowired
	BookRepositoryCustom bookRepositoryCustom;
	
	

	public Book save(Book book){
		
		bookRepositoryCustom.save(book);
		return book;
		
	}
	
	public Book  update(Book book){
		
		bookRepositoryCustom.save(book);
		return book;
	}
	
	public void delete(Integer bookId){
		bookRepositoryCustom.delete(bookId);
	}
	
	public Iterable getAll(){
	
		return  bookRepositoryCustom.findAll();
	}
	
	public Book findByBookId(int bookId){
		return bookRepositoryCustom.findById(bookId);
	}
}
