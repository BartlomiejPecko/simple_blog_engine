package com.bartpe.blogengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.bartpe.blogengine.domain.dto.PostDto;
import com.bartpe.blogengine.domain.dto.ReviewDto;
import com.bartpe.blogengine.domain.enity.Post;
import com.bartpe.blogengine.domain.enity.Review;
import com.bartpe.blogengine.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;
    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return blogService.getAllPosts();
    }

    @GetMapping("/reviews")
    public List<ReviewDto> getAllReviews() {
        return blogService.getAllReview();
    }

    @GetMapping("/post/{id}")
    public PostDto getPostById(@PathVariable long id) {
        return blogService.getPostById(id);
    }

    @GetMapping("/review/{id}")
    public ReviewDto getReviewById(@PathVariable long id) {
        return blogService.getReviewById(id);
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody PostDto postDto) {
        return blogService.addPost(postDto);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody ReviewDto reviewDto) {
        return blogService.addReview(reviewDto);
    }

    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable long id) {
        blogService.deletePost(id);
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable long id) {
        blogService.deleteReview(id);
    }

    @GetMapping("/averageReview/{id}")
    public double countAverageReview(@PathVariable long id) {
        return blogService.countAverage(id);
    }
}
