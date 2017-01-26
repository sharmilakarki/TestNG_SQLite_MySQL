package com.example.api;
/**
 * @author sanjay
 */

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Author;


//extending CrudRepository by custom Repository so all the method's can be overridden for CRUD operations .
public interface AuthorRepositoryCustom extends CrudRepository<Author, Integer>{
	//custom method 
	Author findById(Integer authorId);

}
