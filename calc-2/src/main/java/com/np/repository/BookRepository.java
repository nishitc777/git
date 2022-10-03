package com.np.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.np.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public List<Book> findByName(String name);

}