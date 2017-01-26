package com.example.api;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Author;

public interface AuthorRepositoryCustom extends CrudRepository<Author, Integer>{
	
	Author findById(Integer authorId);

}
