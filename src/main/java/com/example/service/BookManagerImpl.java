package com.example.service;
/**
 * @author sharmila
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.BookManager;
import com.example.entity.Book;
import com.example.repository.BookRepository;

//Service layer for Book
@Service
@Transactional
public class BookManagerImpl implements BookManager{

	@Autowired
	BookRepository bookRepository;

	public Book addNew(Book t) {
		return bookRepository.save(t);
	}
	
	public Book findByName(String name){
		return bookRepository.findByBookName(name);
	}
	
	@Override
	public Book update(Book t) {
		return bookRepository.save(t);
	}

	@Override
	public void addAll(List<Book> list) {
		
	}

	@Override
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public List<Book> findWithPaging(int page, int size) {
		return null;
	}

	@Override
	public Long countRecord() {
		return bookRepository.count();
	}

	@Override
	public void remove(Book t) {
		bookRepository.delete(t);
	}

	@Override
	public void removeBy(Integer id) {
		bookRepository.delete(id);
	}

	@Override
	public Book findByBookName(String bookName) {
		return bookRepository.findByBookName(bookName);
	}

	@Override
	public void deleteByBookName(String bookName) {
		bookRepository.deleteByBookName(bookName);
	}

	@Override
	public Book find(Integer id) {
		return bookRepository.findOne(id);
	}

}
