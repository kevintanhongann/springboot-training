package com.example.springboottrainingproject.domain;

import com.example.springboottrainingproject.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "entry")
public class Journal {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String title;
  private Date created;
  private String summary;

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

}
