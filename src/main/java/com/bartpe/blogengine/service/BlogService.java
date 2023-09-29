package com.bartpe.blogengine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bartpe.blogengine.domain.dto.PostDto;
import com.bartpe.blogengine.domain.dto.ReviewDto;
import com.bartpe.blogengine.domain.entity.Post;
import com.bartpe.blogengine.domain.entity.Review;
import com.bartpe.blogengine.domain.mapper.PostMapper;
import com.bartpe.blogengine.domain.mapper.ReviewMapper;
import com.bartpe.blogengine.domain.repository.PostRepository;
import com.bartpe.blogengine.domain.repository.ReviewRepository;
//Create a blog post: title, content, publish date
//View blog post: title, content, average rating, list of reviews
//Archive blog post
//Read archive
//Add blog post review: title, content, rating
//Delete blog post review ok
//Count average article rating ok
@Service
public class BlogService {

    private final PostRepository postRepository;
    private final ReviewRepository reviewRepository;
    public BlogService(
                       PostRepository postRepository,
                       ReviewRepository reviewRepository
    ) {
        this.postRepository = postRepository;
        this.reviewRepository = reviewRepository;
    }
    public List<PostDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return PostMapper.toPostDtoList(posts);
    }
    public List<ReviewDto> getAllReview(){
        List<Review> reviews = reviewRepository.findAll();
        return  ReviewMapper.toReviewDtos(reviews);
    }
    public PostDto getPostById(long id){
        Post post =  postRepository.findAllById(id);
        return PostMapper.toPostDto(post);
    }
    public ReviewDto getReviewById(long id){
        Review review = reviewRepository.findAllById(id);
        return  ReviewMapper.toReviewDto(review);
    }
    public Post addPost(PostDto postDto){
        Post post = PostMapper.toPost(postDto);
        return postRepository.save(post);
    }
    public Review addReview(ReviewDto reviewDto){
        Review review = ReviewMapper.toReview(reviewDto);
        return reviewRepository.save(review);
    }
    public void deletePost(long id){//cascade
        postRepository.deleteById(id);
    }
    public void deleteReview(long id){
        reviewRepository.deleteById(id);
    }
    public double countAverage(long id){
        return reviewRepository.countAverageReview(id);
    }


}
