package com.example.service;
/**
 * @author sanjay
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.AuthorManager;
import com.example.entity.Author;
import com.example.repository.AuthorRepository;

@Service
@Transactional
public class AuthorManagerImpl implements AuthorManager{

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public void addAll(List<Author> list) {
	}
	
	@Override
	public Author findByName(String name){
		return authorRepository.findByAuthorName(name);
	}

	@Override
	public Long countRecord() {
		return authorRepository.count();
	}

	public Author addNew(Author t) {
		return authorRepository.save(t);
	}
	
	public Author update(Author t) {
		return authorRepository.save(t);
	}

	public void remove(Author t) {
		authorRepository.delete(t);;
	}

	public Author find(Integer id) {
		return authorRepository.findOne(id);
	}

	@Override
	public void removeBy(Integer id) {
		authorRepository.delete(id);
	}
	
	@Override
	public List<Author> findAll() {
		return (List<Author>) authorRepository.findAll();
	}

	@Override
	public List<Author> findWithPaging(int page, int size) {
		return null;
	}

	@Override
	public void deleteByAuthorName(String name) {
		authorRepository.deleteByAuthorName(name);
	}
	
}