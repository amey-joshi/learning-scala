package org.apde.jpa.bookstore.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findByLastName(String lastName);
	Optional<Author> findById(Long id);
}
