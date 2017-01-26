package com.example.api;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Book;

public interface BookRepositoryCustom extends CrudRepository<Book, Integer>{
	Book findById(Integer id);
	
}
