package com.bartpe.blogengine.domain.dto;

import com.bartpe.blogengine.domain.entity.Post;

import lombok.Builder;

@Builder
public record ReviewDto(Long id,
          String title,
          String content,
          double rating,
          Post post
) {
}
