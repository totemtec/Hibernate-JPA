package com.bookstore.repository;

import com.bookstore.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT b FROM Book b LEFT JOIN FETCH b.author")
    //LEFT JOIN 也可以
//    @Query(value = "SELECT b, a FROM Book b LEFT JOIN b.author a")
    // JOIN肯定是不行的
//    @Query(value = "SELECT b FROM Book b JOIN b.author")
    List<Book> fetchBookWithAuthor();
}
