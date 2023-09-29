package com.bartpe.blogengine.domain.dto;

import java.util.List;

import com.bartpe.blogengine.domain.entity.Review;

import lombok.Builder;

@Builder
public record PostDto(Long id,
          String title,
          String content,
          double averageRating,
          List<Review> reviews
) {
}
