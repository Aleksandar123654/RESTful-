package fmi.bookshop.service;

import fmi.bookshop.model.Author;
import fmi.bookshop.repository.AuthorRepository;
import fmi.bookshop.request.AuthorRequest;
import fmi.bookshop.response.AuthorResponse;

public class AuthorService {

	
	 private final AuthorRepository authorRepository;

	    public AuthorService(AuthorRepository authorRepository) {
	        this.authorRepository = authorRepository;
	    }

	    public AuthorResponse findAuthorById(Long id) {
	        java.util.Optional<Author> result = authorRepository.findById(id);
	        return result.map(this::mapToAuthorResponse).orElse(null);
	    }

	    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
	        Author author = new Author();
	        author.setName(authorRequest.getName());
	        author.setBirthDate(authorRequest.getBirthDate());
	        author = authorRepository.save(author);
	        return mapToAuthorResponse(author);
	    }

	    public AuthorResponse updateAuthor(AuthorRequest authorRequest, Long id) {
	        Author author = authorRepository.findById(id).orElse(null);
	        if (author != null) {
	            author.setName(authorRequest.getName());
	            author.setBirthDate(authorRequest.getBirthDate());
	            author = authorRepository.save(author);
	            return mapToAuthorResponse(author);
	        }
	        return null;
	    }

	    public Boolean deleteAuthor(Long id) {
	        java.util.Optional<Author> result = authorRepository.findById(id);
	        if (result.isPresent()) {
	            authorRepository.delete(result.get());
	            return true;
	        }
	        return false;
	    }

	    private AuthorResponse mapToAuthorResponse(Author author) {
	        AuthorResponse response = new AuthorResponse();
	        response.setId(author.getId());
	        response.setName(author.getName());
	        response.setBirthDate(author.getBirthDate());

	        return response;
	    }
}
