package com.iuh.controller;

import com.iuh.entity.BookReview;
import com.iuh.entity.UserReview;
import com.iuh.service.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;
    @GetMapping
    public List<BookReview> getAllReviews() {
        return bookReviewService.getAllReviews();
    }
    @GetMapping("/{id}")
    public BookReview getReviewById(@PathVariable String id) {
        return bookReviewService.getReviewById(id).orElse(null);
    }
    @PostMapping("/add")
    public BookReview addReview(@RequestBody BookReview review) {
        return bookReviewService.addReview(review);
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id) {
        bookReviewService.deleteReview(id);
    }
    @GetMapping("/by-book-id/{bookId}")
    public BookReview getReviewByBookId(@PathVariable Long bookId) {
        Optional<BookReview> review = bookReviewService.getReviewByBookId(bookId);
        return review.orElse(null);
    }
    @PostMapping("/by-book-id/{bookId}/add-user-reivew")
    public BookReview addUserReviewToBook(@PathVariable Long bookId, @RequestBody UserReview userReview) {
        return bookReviewService.addUserReviewToBook(bookId, userReview);
    }
}
