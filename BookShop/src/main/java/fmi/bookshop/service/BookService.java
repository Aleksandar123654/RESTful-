package fmi.bookshop.service;

import fmi.bookshop.model.Book;
import fmi.bookshop.repository.BookRepository;
import fmi.bookshop.request.BookRequest;
import fmi.bookshop.response.BookResponse;

public class BookService {

	private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse findBookById(Long id) {
        java.util.Optional<Book> result = bookRepository.findById(id);
        return result.map(this::mapToBookResponse).orElse(null);
    }

    public BookResponse createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());

        book = bookRepository.save(book);
        return mapToBookResponse(book);
    }

    public BookResponse updateBook(BookRequest bookRequest, Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookRequest.getTitle());
            book.setAuthor(bookRequest.getAuthor());

            book = bookRepository.save(book);
            return mapToBookResponse(book);
        }
        return null;
    }

    public Boolean deleteBook(Long id) {
        java.util.Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            bookRepository.delete(result.get());
            return true;
        }
        return false;
    }

    private BookResponse mapToBookResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());

        return response;
    }

	
}
