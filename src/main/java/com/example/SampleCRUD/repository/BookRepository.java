package com.example.SampleCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SampleCRUD.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
}
