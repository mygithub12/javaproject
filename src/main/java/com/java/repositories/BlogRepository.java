package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
