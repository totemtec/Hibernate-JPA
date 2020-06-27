package com.bookstore.repository;

import java.util.List;
import com.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // INNER JOIN, 如果读取books，会做n+1次查询，books会包含此作者的所有书
    @Transactional(readOnly = true)
    @Query(value = "SELECT a, b FROM Author a INNER JOIN a.books b WHERE b.price > ?1")
    List<Author> fetchAuthorsBooksByPriceInnerJoin(int price);

    // JOIN FETCH, 1次查询，books里面只包含符合条件的书，如果1个作者符合条件的书有多本，会产生多条作者
    @Transactional(readOnly = true)
    @Query(value = "SELECT a FROM Author a JOIN FETCH a.books b WHERE b.price > ?1")
    List<Author> fetchAuthorsBooksByPriceJoinFetch(int price);
}
