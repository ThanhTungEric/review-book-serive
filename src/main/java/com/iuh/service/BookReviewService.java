package com.iuh.service;

import com.iuh.entity.BookReview;
import com.iuh.entity.UserReview;

import java.util.List;
import java.util.Optional;

public interface BookReviewService {

    List<BookReview> getAllReviews();

    Optional<BookReview> getReviewById(String id);

    BookReview addReview(BookReview review);

    void deleteReview(String id);
    Optional<BookReview> getReviewByBookId(Long bookId);

    BookReview addUserReviewToBook(Long bookId, UserReview userReview);
}
