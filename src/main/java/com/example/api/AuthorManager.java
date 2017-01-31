package com.example.api;
/**
 * 
 * @author Sanjay
 * 
 */

import com.example.entity.Author;

//extending CrudRepository by custom Repository so all the method's can be overridden for CRUD operations .
public interface AuthorManager extends CrudManager<Author, Integer>{
	//custom method 
	Author findByName(String name);	
	void deleteByAuthorName(String name);

}
