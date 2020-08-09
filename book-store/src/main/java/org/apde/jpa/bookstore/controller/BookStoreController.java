package org.apde.jpa.bookstore.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apde.jpa.bookstore.model.Author;
import org.apde.jpa.bookstore.model.AuthorRepository;
import org.apde.jpa.bookstore.model.Book;
import org.apde.jpa.bookstore.model.BookRepository;
import org.apde.jpa.bookstore.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apde")
public class BookStoreController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookShopService bookShopService;

	@GetMapping("/book/title/{title}")
	public List<Book> getByTitle(@PathVariable(name = "title") String title) {
		return bookRepository.findByTitle(title);
	}

	@GetMapping("/book/id/{id}")
	public Book getById(@PathVariable(name = "id") Long id) {
		Optional<Book> opt = bookRepository.findById(id);

		return opt.get();
	}

	@PostMapping("/init")
	public String initializeRepo() {
		addAuthors();
		addBooks();

		return String.format("Added %d authors and %s books.", authorRepository.count(), bookRepository.count());
	}

	private List<Author> getAuthorList(long id) {
		List<Author> authors = new ArrayList<>();

		Optional<Author> oa = authorRepository.findById(id);
		if (oa.isPresent()) {
			authors.add(oa.get());
		}

		return authors;
	}

	private void addAuthors() {
		authorRepository.save(new Author("Walter", "Rudin"));
		authorRepository.save(new Author("Fritz", "John"));
		authorRepository.save(new Author("Lawrence", "Evans"));
		authorRepository.save(new Author("Terence", "Tao"));
		authorRepository.save(new Author("Michael", "Spivak"));
	}

	private void addBooks() {
		bookRepository.save(new Book("Principles of Mathematical Analysis", getAuthorList(1)));
		bookRepository.save(new Book("Real and Complex Analysis", getAuthorList(1)));
		bookRepository.save(new Book("Functional Analysis", getAuthorList(1)));
		bookRepository.save(new Book("Partial Differential Equations", getAuthorList(2)));
		bookRepository.save(new Book("Partial Differential Equations", getAuthorList(3)));
		bookRepository.save(new Book("Analysis I", getAuthorList(4)));
		bookRepository.save(new Book("Analysis II", getAuthorList(4)));
		bookRepository.save(new Book("Analysis III", getAuthorList(4)));
	}

	@GetMapping("/authors")
	public List<Author> allAuthors() {
		LinkedList<Author> authors = new LinkedList<>();

		authorRepository.findAll().forEach(a -> authors.add(a));

		return authors;
	}

	@GetMapping("/books")
	public List<Book> showAll() {
		LinkedList<Book> books = new LinkedList<>();

		bookRepository.findAll().forEach(b -> books.add(b));

		return books;
	}

	@GetMapping("/greet")
	public String greet() {
		return "Welcome to the book shop";
	}

	@GetMapping("/author/{lastname}")
	public List<Book> byAuthor(@PathVariable(name = "lastname") String lastname) {
		return bookShopService.getByAuthorLastName(lastname);
	}
}
