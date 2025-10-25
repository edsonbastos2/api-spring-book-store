package com.bookstore.services;

import com.bookstore.dtos.BookDto;
import com.bookstore.entity.BookEntity;
import com.bookstore.entity.ReviewEntity;
import com.bookstore.repositories.AuthorRepository;
import com.bookstore.repositories.BookRepository;
import com.bookstore.repositories.PublisherRepository;
import com.bookstore.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public BookEntity saveBook(BookDto dto) {
        BookEntity book = new BookEntity();
        book.setTitle(dto.title());
        book.setPublisher(publisherRepository.findById(dto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(dto.authorsId()).stream().collect(Collectors.toSet()));

        ReviewEntity review = new ReviewEntity();
        review.setComment(dto.reviewComment());
        review.setBook(book);
        book.setReview(review);

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        var book = bookRepository.findById(id);
        if(book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
