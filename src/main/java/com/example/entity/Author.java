package com.example.entity;
/**
 * @author sanjay
 */
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//tbl_author is the table name of the Author Entity
@Entity
@Table(name="tbl_author")
public class Author implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="id")
	private int id;
	@Column(name="author_name")
	private String authorName;
	private Set<Book> book;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="author")
	public Set<Book> getBook(){
		return book;
	}
	
	public void setBook(Set<Book> book){
		this.book = book;
	}
	
	
}
