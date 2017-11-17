package com.example.springboottrainingproject.repository;

import com.example.springboottrainingproject.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JournalRepository extends JpaRepository<Journal, Long>{

}
