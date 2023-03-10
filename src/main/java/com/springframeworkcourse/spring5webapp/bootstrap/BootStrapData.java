package com.springframeworkcourse.spring5webapp.bootstrap;

import com.springframeworkcourse.spring5webapp.model.Author;
import com.springframeworkcourse.spring5webapp.model.Book;
import com.springframeworkcourse.spring5webapp.model.Publisher;
import com.springframeworkcourse.spring5webapp.repositories.AuthorRepository;
import com.springframeworkcourse.spring5webapp.repositories.BookRepository;
import com.springframeworkcourse.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Divine Comedy", "12345");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author juan = new Author("Juan", "Moya");
        Book aaa = new Book("Video games History", "54321");

        juan.getBooks().add(aaa);
        aaa.getAuthors().add(juan);
        aaa.setPublisher(publisher);
        publisher.getBooks().add(aaa);

        authorRepository.save(juan);
        bookRepository.save(aaa);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Publisher with bookd: " + publisher.getBooks().size());
    }
}
