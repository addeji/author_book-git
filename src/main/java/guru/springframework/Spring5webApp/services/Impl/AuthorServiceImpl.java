package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        log.info("getAllAuthors");
        return authorRepository.findAll();
    }

    @Override
    public Author addAuthor(Author author) {
        log.info("Adding author: {}", author);
        return authorRepository.save(author);
    }
    @Override
    public Author getAuthorById(Long id) {return authorRepository.findById(id).orElse(null);}

    @Override
    public Author editAuthorName(Long authorId, String newName) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.setAuthorName(newName);
        log.info("Author updated{}", author);
        return authorRepository.save(author); }

    @Override
    public Author addAuthortoBook(Long authorId, BookDto bookdto) {
        log.info("Adding BookToAuthor: {}", bookdto);
        Author author = authorRepository.findById(authorId).orElseThrow();
        Book book = new Book();
        book.setAuthor(author);
        return  author;
    }


    @Override
    public void deleteAuthor(Long id) {
        log.info("Deleting author: {}", id);
        authorRepository.deleteById(id);
    }



}
