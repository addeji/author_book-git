package guru.springframework.Spring5webApp.services;


import guru.springframework.Spring5webApp.Dto.PublisherDto;
import java.util.List;

public interface PublisherService {
    


    List<PublisherDto> getAllPublishers();
    PublisherDto getPublisherById(Long id);
    PublisherDto addPublisher(PublisherDto publisherDTO);
    PublisherDto updatePublisher(Long id, PublisherDto publisherDTO);
    void deletePublisher(Long id);

}
