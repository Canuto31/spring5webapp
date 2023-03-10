package com.springframeworkcourse.spring5webapp.bootstrap;

import com.springframeworkcourse.spring5webapp.model.Author;
import com.springframeworkcourse.spring5webapp.model.Book;
import com.springframeworkcourse.spring5webapp.repositories.AuthorRepository;
import com.springframeworkcourse.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Divine Comedy", "12345");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author juan = new Author("Juan", "Moya");
        Book aaa = new Book("Video games History", "54321");

        juan.getBooks().add(aaa);
        aaa.getAuthors().add(juan);

        authorRepository.save(juan);
        bookRepository.save(aaa);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
    }
}
