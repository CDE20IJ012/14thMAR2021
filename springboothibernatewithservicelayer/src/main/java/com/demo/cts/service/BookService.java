package com.demo.cts.service;

import java.util.List;

import com.demo.cts.domain.Book;

public interface BookService {
  public Book addBook(Book book);
  public Book getBook(int id);
  public List<Book> getBooks();
  public Book deleteBook(int id);
  public Book updateBook(Book book);
  
}
