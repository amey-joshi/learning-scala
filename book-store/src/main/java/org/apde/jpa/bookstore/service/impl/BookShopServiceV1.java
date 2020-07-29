package org.apde.jpa.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apde.jpa.bookstore.model.Author;
import org.apde.jpa.bookstore.model.AuthorRepository;
import org.apde.jpa.bookstore.model.Book;
import org.apde.jpa.bookstore.model.BookRepository;
import org.apde.jpa.bookstore.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookShopServiceV1 implements BookShopService {
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getByAuthorLastName(String lastName) {
		List<Author> authors = authorRepository.findByLastName(lastName);
		List<Book> books = new ArrayList<>();

		if (!authors.isEmpty()) {
			bookRepository.findAll().forEach(book -> filter(book, authors, books));
		}

		return books;
	}

	private void filter(Book book, List<Author> authors, List<Book> books) {
		List<Author> currAuthors = book.getAuthor();

		currAuthors.forEach(a -> {
			if (authors.contains(a))
				books.add(book);
		});
	}
}
