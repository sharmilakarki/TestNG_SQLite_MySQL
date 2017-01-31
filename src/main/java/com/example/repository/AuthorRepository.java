package com.example.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Author;

@Transactional(readOnly = true)
public interface AuthorRepository extends CrudRepository<Author, Integer> {
	Author findByAuthorName(String authorName);
	void deleteByAuthorName(String authorName);
}
