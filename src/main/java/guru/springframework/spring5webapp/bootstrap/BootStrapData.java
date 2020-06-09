package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component is to tell is a annotation SpringFramwork to management component

// ComandLineRuner tells the Springboot if find this is to run in,
// Then takes a string of arguments and get those two properties here to initialize in those constructors
// with the instances that they have. Having two objects saved inside and underneath the covers, JPA is using
// Hibertnate to save those in memory H2 database


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

//this make an injection of the dependencies in the constructor for n instance of Author and Book repository

    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-: Stared in Bootstrap :-");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publising");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println( "Publisher Count: " + publisherRepository.count());
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        // this will save these in database
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rob = new Author("Rob", "Jhonson");
        Book noEJB = new Book("J2EE Development without JPE", "3456742342");
        noEJB.getAuthors().add(rob);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        // this will save these in database
        authorRepository.save(rob);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Numbers of Books: " + publisher.getBooks().size());
     }
}
