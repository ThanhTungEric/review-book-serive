package com.iuh.service;

import com.iuh.entity.BookReview;
import com.iuh.entity.UserReview;
import com.iuh.repository.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookReviewServiceImpl implements BookReviewService {
    @Autowired
    private BookReviewRepository repository;

    public List<BookReview> getAllReviews() {
        return repository.findAll();
    }

    public Optional<BookReview> getReviewById(String id) {
        return repository.findById(id);
    }

    public BookReview addReview(BookReview review) {
        return repository.save(review);
    }

    public void deleteReview(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<BookReview> getReviewByBookId(Long bookId) {
        return repository.findByBookId(bookId);
    }

    @Override
    public BookReview addUserReviewToBook(Long bookId, UserReview userReview) {
        Optional<BookReview> bookReviewOpt = repository.findByBookId(bookId);
        if (bookReviewOpt.isPresent()) {
            BookReview bookReview = bookReviewOpt.get();
            List<UserReview> userReviews = bookReview.getUserReviews();
            if (userReviews == null) {
                userReviews = new ArrayList<>();
            }
            userReviews.add(userReview);
            bookReview.setUserReviews(userReviews);
            return repository.save(bookReview);
        }
        return null;
    }

}
