package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {
    // empty interface body
    // we can define custom methods here, but for the exercise, all we need
    // are the methods that come from CrudRepository
}
