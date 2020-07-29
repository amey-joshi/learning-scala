package org.apde.jpa.bookstore.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	@Override
	Optional<Book> findById(Long id);

	List<Book> findByTitle(String title);
}
