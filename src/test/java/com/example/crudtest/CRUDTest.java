package com.example.crudtest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.api.service.BookService;
import com.example.entity.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Transactional
@TestPropertySource(locations="classpath:application-mysql.properties")
public class CRUDTest  extends AbstractTestNGSpringContextTests{
	
	@Autowired
	BookService bookService;
	
	

	@Test
	public void insertOperation(){
		Book book =new Book();
		
		book.setBookName("spring tutorials");
		this.bookService.save(book);
		
		System.out.println(book.getId());
		
		int bookId=2;
		Book bookTest=this.bookService.findByBookId(bookId);
		
		
		
		Assert.assertEquals(bookTest.getBookName(), book.getBookName());
	}
}
