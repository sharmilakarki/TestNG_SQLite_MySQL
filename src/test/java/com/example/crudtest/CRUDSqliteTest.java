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
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.service.AuthorManagerImpl;
import com.example.service.BookManagerImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

/*Test annotation which indicates that the ApplicationContext 
associated with a test is dirty and should therefore be closed and removed from the context cache.
*/
@DirtiesContext
@Transactional
//use application-sqlite.properties in order to use sqlite for the database
@TestPropertySource(locations="classpath:application-sqlite.properties")
public class CRUDSqliteTest  extends AbstractTestNGSpringContextTests{
	
	@Autowired
	BookManagerImpl bookService;
	
	@Autowired
	AuthorManagerImpl authorService;
	
	public static final String AUTHORNAME = "William Wordsworth";
	
	public static final String BOOKNAME = "The Prelude";
	
	public static final String ANOTHERAUTHORNAME = "William Shakespeare";
	
	public static final String ANOTHERBOOKNAME = "Hamlet";
	
	public Integer authorId, bookId;
	
	@Test
	public void insertAuthorTest(){
		Author author = new Author();
		author.setAuthorName(AUTHORNAME);
		Author authorTest = authorService.addNew(author);
		
		this.authorId = authorTest.getId();
		
		AssertJUnit.assertEquals(authorTest.getAuthorName(), author.getAuthorName());
	}

	@Test(dependsOnMethods={"insertAuthorTest"})
	public void findOneAuthor(){
		Author authorTest = authorService.find(this.authorId);
		AssertJUnit.assertEquals(AUTHORNAME,authorTest.getAuthorName());
	}
	
	@Test(dependsOnMethods={"insertAuthorTest"})
	public void insertBookTest(){
		Book book =new Book();
		
		Author author = authorService.find(this.authorId);
		
		book.setAuthor(author);
		book.setBookName(BOOKNAME);
		Book bookTest = bookService.addNew(book);
		
		this.bookId = bookTest.getId();
		
		AssertJUnit.assertEquals(bookTest.getBookName(), book.getBookName());
	}
	
	@Test(dependsOnMethods={"insertBookTest"})
	public void findOneBook(){
		Book bookTest = bookService.find(this.bookId);
		AssertJUnit.assertEquals(BOOKNAME, bookTest.getBookName());
	}
	
	@Test(dependsOnMethods={"findOneAuthor"})
	public void updateAuthorTest(){
		Author author = authorService.find(this.authorId);
		if(!(author.equals(null))){
			author.setAuthorName(ANOTHERAUTHORNAME);
			Author authorTest = authorService.update(author);
			AssertJUnit.assertEquals(authorTest.getAuthorName(), ANOTHERAUTHORNAME);	
		}
	}
	
	@Test(dependsOnMethods={"findOneBook"})
	public void updateBookTest(){
		Book book = bookService.find(this.bookId);
		if(!(book.equals(null))){
			book.setBookName(ANOTHERBOOKNAME);
			Book bookTest = bookService.update(book);
			AssertJUnit.assertEquals(bookTest.getBookName(), ANOTHERBOOKNAME);
		}
	}
	
	@Test(dependsOnMethods={"updateBookTest"})
	public void deleteBookTest(){
		AssertJUnit.assertNotNull(bookService.find(this.bookId));
		bookService.removeBy(this.bookId);
		AssertJUnit.assertNull(bookService.find(this.bookId));
	}
	
	@Test(dependsOnMethods={"deleteBookTest"})
	public void deleteAuthorTest(){
		AssertJUnit.assertNotNull(authorService.find(this.authorId));
		authorService.removeBy(this.authorId);
		AssertJUnit.assertNull(authorService.find(this.authorId));
	}
	
}
