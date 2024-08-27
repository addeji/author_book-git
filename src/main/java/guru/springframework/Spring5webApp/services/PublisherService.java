package guru.springframework.Spring5webApp.services;


import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publisher;

import java.util.List;


public interface PublisherService {


    List<Publisher> getAllPublishers() ;
    Publisher addPublisher(Publisher publisher, Book book);

     Publisher getPublisherById(Long id);
     void deletePublisher(Long id);

}
