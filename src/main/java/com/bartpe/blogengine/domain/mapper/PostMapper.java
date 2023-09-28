package com.bartpe.blogengine.domain.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bartpe.blogengine.domain.dto.PostDto;
import com.bartpe.blogengine.domain.enity.Post;
@Component
public class PostMapper {
    public static Post toPost(PostDto postDto){
        return Post.builder()
                .title(postDto.title())
                .averageRating(postDto.averageRating())
                .content(postDto.content())
                .build();
    }
    public static PostDto toPostDto(Post post){
        return PostDto.builder()
                .id(post.getId())
                .averageRating(post.getAverageRating())
                .content(post.getContent())
                .reviews(post.getReviews())
                .title(post.getTitle())
                .build();
    }

    public List<Post> toPostList(List<PostDto> postDtos){
        return  postDtos.stream()
                .map(PostMapper::toPost)
                .toList();
    }
    public static List<PostDto> toPostDtoList(List<Post> posts){
        return  posts.stream()
                .map(PostMapper::toPostDto)
                .toList();
    }
}
