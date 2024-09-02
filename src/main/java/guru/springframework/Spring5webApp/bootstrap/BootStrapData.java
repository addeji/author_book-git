package guru.springframework.Spring5webApp.bootstrap;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.domain.Publisher;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.repositories.BookRepository;

import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import guru.springframework.Spring5webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository
            , PublisherRepository publisherRepository, CategoryRepository categoryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;

    }


    @Override
    public void run(String... args) {
        System.out.println("Started in BootStrap");
        Publisher publishers = new Publisher();
        publishers.setPublisherName("Epic");
        publishers.setAddressline("ikorodu,erunwen");
        publishers.setCity("Lagos");
        publishers.setZip("174333");
        publisherRepository.save(publishers);
        System.out.println(" name:" + publishers.getPublisherName());









        Author eric = new Author("eric","aurthur");
        Book Got = new Book("Book of Ice","2456876453");
        Category category = new Category("Horror");
        Category comedy = new Category("Comedy");
        Category science = new Category("Sci-Fi");



        eric.getBooks().add(Got);
        Got.setPublisher(publishers);
        publishers.getBooks().add(Got);





        authorRepository.save(eric);
        bookRepository.save(Got);
        publisherRepository.save(publishers);
        categoryRepository.save(category);
        categoryRepository.save(comedy);
        categoryRepository.save(science);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("EA");
        publisher.setAddressline("ikeja,mainland ,lagos");
        publisher.setCity("Lagos");
        publisher.setZip("100001");
        publisherRepository.save(publisher);
        System.out.println(" name:" + publisher.getPublisherName());



        Author rod = new Author("Rod","james");
        Book ToG = new Book("Throne of Glass","1443876453");

        rod.getBooks().add(ToG);
        ToG.setPublisher(publisher);
        publisher.getBooks().add(ToG);




        authorRepository.save(rod);
        bookRepository.save(ToG);
        publisherRepository.save(publisher);
        System.out.println(" books published:" + publishers.getBooks().size());
        System.out.println(" books published:" + publisher.getBooks().size());



        System.out.println("Total");
        System.out.println("Number of Books :" + bookRepository.count());
        System.out.println("Number of Authors :" + authorRepository.count());
        System.out.println(" Number of Publisher:" + publisherRepository.count());
        System.out.println("Number of Category" + categoryRepository.count());





    }

}
