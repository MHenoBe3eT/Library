package ru.vlasov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlasov.models.Book;
import ru.vlasov.models.Person;
import ru.vlasov.repositories.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;
    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }
    @Transactional
    public void release(int id) {
        Book book = booksRepository.findById(id).orElse(null);
        if (book != null) {
            book.setOwner(null);
            booksRepository.save(book);
        }
    }
    @Transactional
    public void assign(int id, Person selectedPerson) {
        Book book = booksRepository.findById(id).orElse(null);
        if (book != null) {
            book.setOwner(selectedPerson);
            booksRepository.save(book);
        }
    }

}
