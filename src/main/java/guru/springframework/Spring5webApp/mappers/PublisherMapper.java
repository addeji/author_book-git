package guru.springframework.Spring5webApp.mappers;


import guru.springframework.Spring5webApp.Dto.PublisherDto;
import guru.springframework.Spring5webApp.domain.Publisher;
import org.mapstruct.Mapper;

@Mapper
public interface PublisherMapper {
    Publisher publisherDtoToPublisher(PublisherDto publisherDto);
    PublisherDto publisherToPublisherDto(Publisher publisher);
}
