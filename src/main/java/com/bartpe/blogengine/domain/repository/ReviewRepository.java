package com.bartpe.blogengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bartpe.blogengine.domain.enity.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Review findAllById(long id);

    void delete(long id);
    @Query("select Sum(r.id) from Review r where r.id = :id")
    double countAverageReview(@Param("id") long id);
}
