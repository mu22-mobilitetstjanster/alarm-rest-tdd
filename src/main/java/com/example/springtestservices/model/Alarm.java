package com.example.springtestservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

@Entity // enable jpa
@Data // enable getters n' setters
@NoArgsConstructor
public class Alarm {

  public Alarm(String title, String date) {
    this.title = title;
    this.date = date;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private String date;
}
