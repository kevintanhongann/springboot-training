package com.example.springboottrainingproject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class MyResponse {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public MyResponse(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "MyResponse{" +
            "message='" + message + '\'' +
            '}';
  }
}
