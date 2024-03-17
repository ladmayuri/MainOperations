package com.example.SampleCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SampleCRUD.Service.BookService;
import com.example.SampleCRUD.model.Book;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@PostMapping("/book/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book request){
		return new ResponseEntity<>(bookService.save(request),HttpStatus.CREATED);
	}
	@GetMapping("/book")
	public ResponseEntity<List<Book>> findBook(){
		return new ResponseEntity<List<Book>>(bookService.findBook(),HttpStatus.OK);
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> findByBookId(@PathVariable Long id){
		return new ResponseEntity<Book>(bookService.findByBookId(id),HttpStatus.OK);
	}
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book request){
		Book book=bookService.findByBookId(id);
		book.setName(request.getName());
		book.setPrice(request.getPrice());
		book.setTitle(request.getTitle());
		return new ResponseEntity<Book>(bookService.save(book),HttpStatus.OK);
	}
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable Long id){
		bookService.delete(id);
	}
}
