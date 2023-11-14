package fmi.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import fmi.bookshop.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
