package com.demo.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cts.dao.BookRepository;
import com.demo.cts.domain.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book) {
		     bookRepository.save(book);
             return book; 
	}

	@Override
	public Book getBook(int id) {
		Book book=null;
		Optional<Book> searchedBook=bookRepository.findById(id);
		if(searchedBook.isPresent())
		{
			book=searchedBook.get();
		}
		return book;
	}

	@Override
	public List<Book> getBooks() {
		List<Book> bookList=(List<Book>)bookRepository.findAll();
		return bookList;
	}

	@Override
	public Book deleteBook(int id) {
		Book book=null;
		Optional<Book> searchedBook=bookRepository.findById(id);
		if(searchedBook.isPresent())
		{
			book=searchedBook.get();
			bookRepository.delete(book);
		}
         return book;
	}

	@Override
	public Book updateBook(Book book) {
		bookRepository.save(book);
        return book; 
	}

}
