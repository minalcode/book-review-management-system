package com.bookreview.book_review_management.Service;

import com.bookreview.book_review_management.Model.Book;
import com.bookreview.book_review_management.Model.Review;
import com.bookreview.book_review_management.Repository.BookRepository;
import com.bookreview.book_review_management.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public Review createReview(Long bookId, Review review) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        review.setBook(book);

        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBook(Long bookId) {

        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("Book not found");
        }

        return reviewRepository.findByBookId(bookId);
    }

    public void deleteReview(Long id) {

        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found");
        }

        reviewRepository.deleteById(id);
    }
}