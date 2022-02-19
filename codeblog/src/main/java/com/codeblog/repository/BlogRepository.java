package com.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeblog.model.BlogModel;

public interface BlogRepository extends JpaRepository<BlogModel, Long>{

}
