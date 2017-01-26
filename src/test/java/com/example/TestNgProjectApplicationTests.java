package com.example;
/**
 * @author sharmila
 */

import javax.transaction.Transactional;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;

import com.example.api.BookDao;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

/*Test annotation which indicates that the ApplicationContext 
associated with a test is dirty and should therefore be closed and removed from the context cache.
*/

@DirtiesContext

@SuppressWarnings("deprecation")
public class TestNgProjectApplicationTests extends AbstractTestNGSpringContextTests{

	@Autowired
	private BookDao test1;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
//	@Test
//	public void something(){
//	
//
//	
//		int actualValue=1;
//		int value=test1.test1(actualValue);
//		int expectedValue=1;
//		Assert.assertEquals(actualValue, expectedValue, "right");
//	
//		
//	}
//	
//	@Test
//	public void testMethod1(){
//		String actual="adfadsf";
//		String expected=test1.test("adfadsf");
//		
//	//	Assert.assertEquals(actual, expected, "");
//		Assert.assertNull(expected);
//	}
//	
//	@Test
//	public void restTemplateTest(){
//		
//		ResponseEntity<String> entity=this.restTemplate.getForEntity("http://localhost:8080/about", String.class);
//		
//		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(entity.getBody()).isEqualTo("");
//		assertThat(entity.getBody()).isNull();
//
//		
//	}

}
