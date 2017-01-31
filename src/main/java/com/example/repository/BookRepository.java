package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	 Book findByBookName(String bookName);
	 Book deleteByBookName(String bookName);
}
