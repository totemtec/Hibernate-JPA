package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.exit(0);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\n\nfetchBooksAuthorsInnerJoinBad: ");
            bookstoreService.fetchBooksAuthorsInnerJoinBad();
            
            System.out.println("\n\nfetchBooksAuthorsInnerJoinGood: ");
            bookstoreService.fetchBooksAuthorsInnerJoinGood();

            System.out.println("\n\nfetchBooksAuthorsJoinFetch: ");
            bookstoreService.fetchBooksAuthorsJoinFetch();

            System.out.println("\n\nfetchAuthorsBooksByPriceInnerJoin (获取了每个作者的所有书，每个作者都再做一次查询): ");
            bookstoreService.fetchAuthorsBooksByPriceInnerJoin();

            System.out.println("\n\nfetchAuthorsBooksByPriceJoinFetch: ");
            bookstoreService.fetchAuthorsBooksByPriceJoinFetch();
        };
    }
}
