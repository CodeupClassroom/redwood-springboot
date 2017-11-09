package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
    // Query methods -> finder methods
    User findByUsername(String username);
}
