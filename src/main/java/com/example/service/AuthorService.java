package com.example.service;
/**
 * @author sanjay
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.AuthorRepositoryCustom;
import com.example.entity.Author;

@Service
public class AuthorService {

	@Autowired
	AuthorRepositoryCustom authorRepositoryCustom;
	
	public Author save(Author author){
		authorRepositoryCustom.save(author);
		return author;
	}
	
	public Author update(Author author){
		authorRepositoryCustom.save(author);
		return author;
	}
	
	public void delete(Integer authorId){
		authorRepositoryCustom.delete(authorId);
	}
	
	public Iterable getAll(){
		return authorRepositoryCustom.findAll();
	}
	
	public Author findByAuthorId(int authorId){
		return authorRepositoryCustom.findById(authorId);
	}
	
}