package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publisher;
import guru.springframework.Spring5webApp.repositories.PublisherRepository;
import guru.springframework.Spring5webApp.services.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAllPublishers() {
        List<Publisher> publishers =  publisherRepository.findAll();
        log.info("get all books");
        return ResponseEntity.ok(publishers).getBody();

    }

    @Override
    public Publisher addPublisher(Publisher publisher , Book book) {
        log.info("addedPublisher{}", publisher);
        Publisher savedPub = publisherRepository.save(publisher);
        book.setPublisher(savedPub);
        return savedPub;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePublisher(Long id) {
        log.info("delete book" + id);
        publisherRepository.deleteById(id);
    }
}
