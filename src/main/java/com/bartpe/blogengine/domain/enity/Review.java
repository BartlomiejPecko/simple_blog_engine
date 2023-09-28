package com.bartpe.blogengine.domain.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Create a blog post: title, content, publish date
//View blog post: title, content, average rating, list of reviews
//Archive blog post
//Read archive
//Add blog post review: title, content, rating
//Delete blog post review
//Count average article rating
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String content;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Post post;
}

