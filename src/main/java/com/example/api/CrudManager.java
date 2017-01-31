package com.example.api;

import java.io.Serializable;
import java.util.List;

public interface CrudManager <T extends Serializable, Pk extends Serializable> {
	
	public T addNew(T t);
	
	public void addAll(List<T> list);
	
	public T update(T t);
	
	public void remove(T t);
	
	public void removeBy(Pk id);
	
	public T find(Pk id);
	
	public List<T> findAll();
	
	public List<T> findWithPaging(int page, int size);
	
	public Long countRecord();
	
}
