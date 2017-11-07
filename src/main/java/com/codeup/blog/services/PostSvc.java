/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostSvc {
    private final PostsRepository postDao;

    // Autowire an instance of our PostsRepository in
    @Autowired
    public PostSvc(PostsRepository postDao) {
        this.postDao = postDao;
    }

    /**
     * All the methods in this service are thin wrappers around interacting with the postDao
     * That is, they will all pass their parameters to the instance of the PostsRepository,
     * and return whatever it returns
     */

    public Post findById(long id) {
        return postDao.findOne(id);
    }

    // Iterable is a superclass of List, that is, a more generic type
    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
        return postDao.save(post);
    }

    public void delete(long id) {
        postDao.delete(id);
    }
}
