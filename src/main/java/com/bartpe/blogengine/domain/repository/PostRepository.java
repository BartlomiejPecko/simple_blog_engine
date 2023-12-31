package com.bartpe.blogengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bartpe.blogengine.domain.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Post findAllById(long id);
    void deleteById(Long id);
}
