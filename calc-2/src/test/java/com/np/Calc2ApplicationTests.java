package com.np;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.np.entity.Book;
import com.np.repository.BookRepository;
import com.np.service.BookService;

@SpringBootTest(classes=Calc2Application.class)
public class Calc2ApplicationTests {
	
	@Mock 
	BookRepository bookRepo;
	
	@InjectMocks
	BookService bookService = new BookService();
	
	@Test
	public void testGetAllBooks() {
		
		List<Book> books = new ArrayList<>();
		Book b1 = new Book(1, "Learn Java", "Abc", 100, "borrowed");
		Book b2 = new Book(2, "Learn Python", "Def", 150, "borrowed");
		Book b3 = new Book(3, "Learn C#", "Ghi", 90, "available");
		books.add(b1);
		books.add(b2);
		books.add(b3);
		when(bookRepo.findAll()).thenReturn(books);
		List<Book> result = bookService.getAllBooks();
		
		Assertions.assertNotEquals(null, result);
		Assertions.assertTrue(result.get(0).getName().endsWith("-b"));
		Assertions.assertEquals("Learn Java-b", result.get(0).getName());
		Assertions.assertTrue(result.get(0).getName().endsWith("-b"));
		Assertions.assertEquals("Learn Python-b", result.get(1).getName());
		Assertions.assertTrue(result.get(0).getName().endsWith("-b"));
		Assertions.assertEquals("Learn C#-b", result.get(2).getName());
		Assertions.assertEquals("Abc", result.get(0).getAuthor());
	}
}