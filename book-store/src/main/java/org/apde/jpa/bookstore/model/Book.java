package org.apde.jpa.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@ManyToMany
	private List<Author> authors;

	protected Book() {

	}

	public Book(String title, List<Author> authors) {
		this.title = title;
		this.authors = new ArrayList<>();

		authors.forEach(this.authors::add);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthor() {
		return authors;
	}

	public void setAuthor(List<Author> authors) {
		authors.forEach(this.authors::add);
	}
}
