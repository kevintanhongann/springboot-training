package com.example.springboottrainingproject.controller;

import com.example.springboottrainingproject.domain.Journal;
import com.example.springboottrainingproject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/journal")
public class JournalController {

  @Autowired
  JournalRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public List<Journal> getJournals(){
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/journal/{id}")
  public Journal get(@PathVariable  Long id){
    return repo.findOne(id);
  }

}
