package com.practice.serviceImpl;

import com.practice.entity.Book;
import com.practice.repository.BookRepository;
import com.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "Book Data Saved Successfully";
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    @Override
    public Book getBookById(int id) {
        Book book =bookRepository.findById(id).orElseThrow(()->new NullPointerException("Book with id does not found"+id));
        return book;
    }

    @Override
    public String deleteBookById(int id) {
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }

    @Override
    public Book updateBookById(int id, Book newBook) {
        Book book = bookRepository.findById(id).orElseThrow(()->new NullPointerException("Updated Developer in db does not found with id"+id));
        System.err.println("Old Book from db"+book);
        System.err.println("Book object with value to be updated"+newBook);

        book.setAuthor(newBook.getAuthor());
        book.setIsbn(newBook.getIsbn());
        book.setTitle(newBook.getTitle());
        book.setAvailableCopies(newBook.getAvailableCopies());

        Book updateBook = bookRepository.save(book);
        System.err.println("Book with updated value"+updateBook);
        return updateBook;
    }

    @Override
    public List<Book> saveListOfData(List<Book> bookList) {
        bookRepository.saveAll(bookList);
        return bookList;
    }
}
