package fmi.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import fmi.bookshop.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
