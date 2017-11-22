package com.example.springboottrainingproject.domain;

import com.example.springboottrainingproject.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name = "entry")
public class Journal {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String title;
  private Date created;
  private String summary;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;


  public Journal() {

  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Transient
  private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

  @JsonIgnore
  public String getCreatedAsShort(){
    return format.format(created);
  }

  @JsonSerialize(using=JsonDateSerializer.class)
  public Date getCreated() {
    return created;
  }

  public Long getId(){
    return id;
  }

  public String getTitle(){
    return title;
  }

  public String getSummary(){
    return summary;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }
}
