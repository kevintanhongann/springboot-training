package com.example.springboottrainingproject.repository;

import com.example.springboottrainingproject.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/category", collectionResourceRel = "categories")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
