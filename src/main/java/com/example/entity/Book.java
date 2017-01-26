package com.example.entity;
/**
 * @author sharmila
 */
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_book")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="id")
	private int id;
	@Column(name="book_name")
	private String bookName;
	private Author author;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	public Author getAuthor(){
		return author;
	}
	
	public void setAuthor(Author author){
		this.author = author;
	}
	
}