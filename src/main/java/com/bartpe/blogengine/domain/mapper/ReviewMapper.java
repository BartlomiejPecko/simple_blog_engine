package com.bartpe.blogengine.domain.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bartpe.blogengine.domain.dto.ReviewDto;
import com.bartpe.blogengine.domain.enity.Review;
@Component
public class ReviewMapper {
    public static Review toReview(ReviewDto reviewDto){
        return Review.builder()
                .content(reviewDto.content())
                .post(reviewDto.post())
                .title(reviewDto.title())
                .rating(reviewDto.rating())
                .build();
    }
    public static ReviewDto toReviewDto(Review review){
        return ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .post(review.getPost())
                .rating(review.getRating())
                .title(review.getTitle())
                .build();
    }

    public static List<Review> toReviewList(List<ReviewDto> reviewDtos){
        return reviewDtos.stream()
                .map(ReviewMapper::toReview)
                .toList();
    }
    public static List<ReviewDto> toReviewDtos(List<Review> reviews){
        return reviews.stream()
                .map(ReviewMapper::toReviewDto)
                .toList();
    }
}
