package com.iuh.repository;

import com.iuh.entity.BookReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookReviewRepository extends MongoRepository<BookReview, String> {
    Optional<BookReview> findByBookId(Long bookId);
}
