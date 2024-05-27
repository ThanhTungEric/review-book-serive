package com.iuh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReview {
    private String userId;
    private String userName;
    private String review;
}
