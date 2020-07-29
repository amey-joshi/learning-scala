package org.apde.jpa.bookstore.service;

import java.util.List;

import org.apde.jpa.bookstore.model.Book;

public interface BookShopService {
	List<Book> getByAuthorLastName(String lastname);
}
