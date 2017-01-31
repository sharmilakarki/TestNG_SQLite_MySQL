package com.example.api;
/**
 * @author sharmila
 */

import com.example.entity.Book;

//extending CrudRepository by custom Repository so all the method's can be overridden for CRUD operations .
public interface BookManager extends CrudManager<Book, Integer>{
	Book findByBookName(String bookName);
	void deleteByBookName(String bookName);
}
