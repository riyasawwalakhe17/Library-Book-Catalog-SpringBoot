package com.practice.service;

import com.practice.entity.Book;

import java.util.List;

public interface BookService {

    String saveBook(Book book);

    List<Book> getAllBook();

    Book getBookById(int id);

    String deleteBookById(int id);

    Book updateBookById(int id, Book newBook);

    List<Book> saveListOfData(List<Book> bookList);
}
