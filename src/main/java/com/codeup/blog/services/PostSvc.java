/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {
    private List<Post> posts;

    public PostSvc() {
        posts = new ArrayList<>();
        createDummyPosts();
    }

    public Post findById(long id) {
        return posts.get((int) id - 1);
    }

    public List<Post> findAll() {
        return posts;
    }

    private void createDummyPosts() {
        posts.add(new Post("Title 1", "Body 1"));
        posts.add(new Post("Title 2", "Body 2"));
        posts.add(new Post("Title 3", "Body 3"));
        posts.add(new Post("Title 4", "Body 4"));
        posts.add(new Post("Example 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));
        posts.add(new Post("Example 2", "QWE Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));
        posts.add(new Post("Example 3", "ASD Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));
    }
}
