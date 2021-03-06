package com.example.springboottrainingproject.repository;

import com.example.springboottrainingproject.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "/entry", collectionResourceRel = "entries")
public interface JournalRepository extends PagingAndSortingRepository<Journal, Long> {

}
