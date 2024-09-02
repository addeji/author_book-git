package guru.springframework.Spring5webApp.Controllers;



import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publisher;
import guru.springframework.Spring5webApp.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    private final PublisherService publisherService;
    @GetMapping
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {

        publisherService.deletePublisher(id);
    }

    @PostMapping("/add-publisher")
    public ResponseEntity<Publisher> addAuthor(@RequestBody Publisher publisher , Book book) {
        Publisher newpublisher = publisherService.addPublisher(publisher , book);
        return ResponseEntity.ok(newpublisher);
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        Publisher publisher = publisherService.getPublisherById(id);
        return ResponseEntity.ok(publisher);
    }

}
