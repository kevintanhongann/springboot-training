package com.example.springboottrainingproject.controller;

import com.example.springboottrainingproject.MyResponse;
import com.example.springboottrainingproject.domain.Journal;
import com.example.springboottrainingproject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class JournalApiController {

  @Autowired
  JournalRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/journal")
  public List<Journal> getJournalEntries(){
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/journal/{id}")
  public Journal get(@PathVariable  Long id){
    return repo.findOne(id);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/journal/create")
  public MyResponse create(){
    Journal journal = new Journal();
    journal.setCreated(Calendar.getInstance().getTime());
    journal.setTitle("title 1");
    journal.setSummary("summary 1");
    repo.save(journal);

    Journal journal2 = new Journal();
    journal2.setTitle("title 2");
    journal2.setSummary("");
    journal2.setCreated(Calendar.getInstance().getTime());
    repo.save(journal2);

    return new MyResponse("success");
  }
}
