package com.bookstore;

import com.bookstore.entity.Author;
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
    }
    
    @Bean
    public ApplicationRunner init() {
        return args -> {
            Author author = bookstoreService.fetchAuthorById(1L);            
            author.setAge(author.getAge() + 1);
            System.out.println("\n\nUpdate via EntityManager#merge(): 效率低下");
            bookstoreService.updateAuthorViaMerge(author);
            
            System.out.println("\n\n-----------------------------------------\n\n");
            
            author = bookstoreService.fetchAuthorById(1L);           
            author.setAge(author.getAge() + 1);
            System.out.println("\n\nUpdate via Session#update(): 高效更新");
            bookstoreService.updateAuthorViaUpdate(author);
        };
    }
}
