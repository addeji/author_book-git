package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.Dto.PublisherDto;
import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.domain.Publisher;
import guru.springframework.Spring5webApp.mappers.PublisherMapper;
import guru.springframework.Spring5webApp.repositories.PublisherRepository;
import guru.springframework.Spring5webApp.services.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private PublisherMapper mapper;


    private final PublisherRepository publisherRepository;


    @Override
    public List<PublisherDto> getAllPublishers() {
        log.info("getAllPublishers");
        List<Publisher> publisher = publisherRepository.findAll();
        return publisher.stream()
                .map(mapper::publisherToPublisherDto)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDto addPublisher(PublisherDto dto) {
        log.info("Add Publisher{}", dto);
        Publisher publisher = mapper.publisherDtoToPublisher(dto);
        publisherRepository.save(publisher);
        return mapper.publisherToPublisherDto(publisher);
    }


    @Override
    public PublisherDto getPublisherById(Long id) {
        log.info("getCategoryById");
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        return  mapper. publisherToPublisherDto(publisher);
    }

    @Override
    public void deletePublisher(Long id) {
        log.info("delete book{}", id);
        publisherRepository.deleteById(id);
    }
    @Override
    public PublisherDto updatePublisher(Long id, PublisherDto dto) {
        log.info("Edit Publisher Name: {}", id);
         Publisher publisher = publisherRepository.findById(id).orElseThrow();
        publisher.setPublisherName(dto.getPublisherName());
        publisher.setBooks(dto.getBooks());
        publisherRepository.save(publisher);
        return  mapper.publisherToPublisherDto(publisher);
    }
}
