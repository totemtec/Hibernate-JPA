package com.bookstore.service;

import com.bookstore.repository.BookRepository;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository,
            BookRepository bookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // 必须带事务声明，否则出错
    @Transactional
    public void newBookOfAuthor() {

        Author author = authorRepository.findById(2L).orElseThrow(RuntimeException::new);

        Book book = new Book();
        book.setTitle("A History of Ancient Prague");
        book.setIsbn("001-JN");
        book.setPrice(123);
        // this will set the id of the book as the id of the author
        book.setAuthor(author);

        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book fetchBookByAuthorId() {

        Author author = authorRepository.findById(2L).orElseThrow(RuntimeException::new);

        return bookRepository.findById(2L).orElseThrow(RuntimeException::new);
    }
}
