package com.example.SampleCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SampleCRUD.model.Book;
import com.example.SampleCRUD.repository.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}

	public Book save(Book request) {
		return bookRepository.save(request);
	}
	public Book findByBookId(Long id) {
		
		Optional<Book> optDb=bookRepository.findById(id);
		if(optDb.isPresent())
			return optDb.get();
		else
			throw new RuntimeException("Record with Id: "+id+" not forund");
	}
	
	public List<Book> findBook() {
		return bookRepository.findAll();
	}
	
	public void delete(Long id) {
	 bookRepository.deleteById(id);
	}
	
}
