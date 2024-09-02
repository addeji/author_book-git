package guru.springframework.Spring5webApp.Controllers;



import guru.springframework.Spring5webApp.Dto.PublisherDto;
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
    public List<PublisherDto> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {

        publisherService.deletePublisher(id);
    }

    @PostMapping
    public PublisherDto addPublisher(@RequestBody PublisherDto publisherDTO) {
        return publisherService.addPublisher(publisherDTO);
    }

    @GetMapping("/{id}")
    public PublisherDto getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }
    @PutMapping("/{id}")
    public PublisherDto updatePublisher(@PathVariable Long id, @RequestBody PublisherDto publisherDTO) {
        return publisherService.updatePublisher(id, publisherDTO);
    }

}
