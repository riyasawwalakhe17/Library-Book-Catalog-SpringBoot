package com.practice.controller;

import com.practice.entity.Book;
import com.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBookData(@RequestBody Book book){
        bookService.saveBook(book);
        return new ResponseEntity<>("Book Data Saved Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllData")
public ResponseEntity<List<Book>> getAllData(){
        List<Book> bookList = bookService.getAllBook();
        return new ResponseEntity<>(bookList,HttpStatus.OK);
}

@GetMapping("/getDataById/{id}")
public ResponseEntity<Book> getDataById(@PathVariable("id") int id){
      Book book=bookService.getBookById(id);
      return new ResponseEntity<>(book,HttpStatus.OK);
}

@DeleteMapping("/deleteDataById/{id}")
public ResponseEntity<String> deleteBookById(@PathVariable("id")int id){
        String msg= bookService.deleteBookById(id);
        return new ResponseEntity<>("Book deleted Successfully",HttpStatus.OK);
}

@PutMapping("/updateDataById/{id}")
public ResponseEntity<Book> updateBookById(@PathVariable("id")int id, @RequestBody Book book){
        Book updateBook = bookService.updateBookById(id,book);
        return new ResponseEntity<>(updateBook,HttpStatus.OK);
}

@PostMapping("/addListOfData")
public ResponseEntity<List<Book>> saveListOfData(@RequestBody List<Book> bookList){
        bookService.saveListOfData(bookList);
        return new ResponseEntity<>(bookList, HttpStatus.CREATED);
}
}
