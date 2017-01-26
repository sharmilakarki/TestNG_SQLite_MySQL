package com.example.api;
/**
 * @author sharmila
 */
import org.springframework.data.repository.CrudRepository;

import com.example.entity.Book;

//extending CrudRepository by custom Repository so all the method's can be overridden for CRUD operations .
public interface BookRepositoryCustom extends CrudRepository<Book, Integer>{
	Book findById(Integer id);
	
}
