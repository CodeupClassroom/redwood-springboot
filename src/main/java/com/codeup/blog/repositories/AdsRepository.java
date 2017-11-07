package com.codeup.blog.repositories;

import com.codeup.blog.models.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdsRepository extends CrudRepository<Ad, Long> {
}
