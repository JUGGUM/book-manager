package Toy.bookmanager.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book updateBook(Long bookId, Book book) {
        Optional<Book> existingBook = bookRepository.findById(bookId);

        if (existingBook.isPresent()) {
            book.setId(existingBook.get().getId());
            return bookRepository.save(book);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
