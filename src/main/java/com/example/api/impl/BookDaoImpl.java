package com.example.api.impl;

/**
 * @author sharmila
 */
import org.springframework.stereotype.Service;

import com.example.api.BookDao;


@Service
public class BookDaoImpl implements BookDao {
// overridding all the methods from BookDao
	@Override
	public String test(String value) {
		
		//return value;
		return "wrong valued";
	}

	@Override
	public int test1(int value) {
		
		//System.out.println("This is the test1 method \n");
		return value;
	}
	
	

}
