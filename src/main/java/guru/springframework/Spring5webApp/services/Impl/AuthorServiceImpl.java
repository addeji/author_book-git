package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.Dto.AuthorDto;
import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.mappers.AuthorMapper;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    private AuthorMapper mapper;

    @Override
    public List<AuthorDto> getAllAuthors() {
        log.info("getAllAuthors");
        List<Author> author = authorRepository.findAll();
        return author.stream()
                .map(mapper::AuthorToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto addAuthor(AuthorDto dto) {
        log.info("Add Author{}", dto);
        Author author = mapper.AuthorDtoToAuthor(dto);
        authorRepository.save(author);
        return mapper.AuthorToAuthorDto(author);
    }
    @Override
    public AuthorDto getAuthorById(Long id) {
        log.info("getAuthorById");
        Author author = authorRepository.findById(id).orElseThrow();
        return mapper.AuthorToAuthorDto(author);
    }

    @Override
    public AuthorDto editAuthorName(Long id, AuthorDto dto) {
        log.info("Edit Author Name: {}", id);
        Author author = authorRepository.findById(id).orElseThrow();
        author.setAuthorName(dto.getAuthorName());
        author.setBooks(dto.getBooks());
        authorRepository.save(author);
        return mapper.AuthorToAuthorDto(author);
    }



    @Override
    public void deleteAuthor(Long id) {
        log.info("Deleting author: {}", id);
        authorRepository.deleteById(id);
    }



}
