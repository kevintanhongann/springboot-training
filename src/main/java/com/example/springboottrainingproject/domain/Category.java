package com.example.springboottrainingproject.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private Set<Journal> entries;

  public Set<Journal> getEntries() {
    return entries;
  }

  public void setEntries(Set<Journal> entries) {
    this.entries = entries;
  }
}
