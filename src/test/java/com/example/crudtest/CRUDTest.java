package com.example.crudtest;
/**
 * @author sharmila
 */
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

/*Test annotation which indicates that the ApplicationContext 
associated with a test is dirty and should therefore be closed and removed from the context cache.
*/
@DirtiesContext
@Transactional

//use application-mysql.properties in order to use mysql for the database
@TestPropertySource(locations="classpath:application-mysql.properties")
public class CRUDTest  extends AbstractTestNGSpringContextTests{
	
	@Autowired
	BookService bookService;
	
	private static int bookId;

	@Test
	public void insertOperation(){
		Book book =new Book();
		
		book.setBookName("spring tutorials");
		this.bookService.save(book);
		
		System.out.println(book.getId());
		
		bookId=2;
		Book bookTest=this.bookService.findByBookId(bookId);
		
		
		//check whether the expected value of id 2 of book is equal to the value passed
		Assert.assertEquals(bookTest.getBookName(), book.getBookName());
	}
	
	@Test(dependsOnMethods={"insertOperation"})
	public void delete(){
		Book bookTest=this.bookService.findByBookId(bookId);
	}
	
	
	
}
