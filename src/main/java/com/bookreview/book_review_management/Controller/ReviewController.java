package com.bookreview.book_review_management.Controller;

import com.bookreview.book_review_management.Model.Review;
import com.bookreview.book_review_management.Service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/book/{bookId}")
    public Review createReview(
            @PathVariable Long bookId,
            @RequestBody Review review) {

        return reviewService.createReview(bookId, review);
    }

    @GetMapping("/book/{bookId}")
    public List<Review> getReviewsByBook(
            @PathVariable Long bookId) {

        return reviewService.getReviewsByBook(bookId);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {

        reviewService.deleteReview(id);

        return "Review deleted successfully";
    }
}