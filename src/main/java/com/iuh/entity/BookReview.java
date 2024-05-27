package com.iuh.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookReview {

    @Id
    private String reviewBookId;
    private String bookName;
    private String reviewName;
    private int rating;
    private Long bookId;
    private List<UserReview> userReviews;

}
