package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.Dto.AuthorDto;
import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.mappers.AuthorMapper;
import guru.springframework.Spring5webApp.mappers.BookMapper;
import guru.springframework.Spring5webApp.mappers.CategoryMapper;
import guru.springframework.Spring5webApp.mappers.PublisherMapper;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import guru.springframework.Spring5webApp.repositories.PublisherRepository;
import guru.springframework.Spring5webApp.services.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    private  BookMapper mapper;

    private  AuthorMapper authorMapper;

    private  PublisherMapper publisherMapper;

    private  CategoryMapper categoryMapper;

    @Override
    public List<BookDto> getAllBooks() {
        log.info("getAllBooks");
        List<Book> book = bookRepository.findAll();
        return book.stream()
                .map(mapper::booktobookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto addBook(BookDto dto) {
        log.info("Adding new book: {}", dto);
        Book book = mapper.boookDtoToBook(dto);
         bookRepository.save(book);
        return mapper.booktobookDto(book);
    }



    @Override
    public BookDto getBookById(Long id) {
        log.info("getBookById");
        Book book = bookRepository.findById(id).orElseThrow();
        return mapper.booktobookDto(book);
    }

    @Override
    public void deleteBook(Long id) {
        log.info("delete book{}", id);
        bookRepository.deleteById(id);
    }
    @Override
    public BookDto editBook(Long id, BookDto dto) {
        log.info("edit book{}", id);
        Book book = bookRepository.findById(id).orElseThrow();
        book.setBookname(dto.getBookname());
        book.setIsbn(dto.getIsbn());
        book.setAuthor(authorMapper.AuthorDtoToAuthor(dto.getAuthor()));
        book.setPublisher(publisherMapper.publisherDtoToPublisher(dto.getPublisher()));
        book.setCategory(categoryMapper.categoryDtoToCategory(dto.getCategory()));
        bookRepository.save(book);
        return mapper.booktobookDto(book);
    }
}
