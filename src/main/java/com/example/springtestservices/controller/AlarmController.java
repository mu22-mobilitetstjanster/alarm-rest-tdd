package com.example.springtestservices.controller;

import com.example.springtestservices.model.Alarm;
import com.example.springtestservices.model.AlarmDetails;
import com.example.springtestservices.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alarm/*")
public class AlarmController {

  @Autowired
  private AlarmService alarmService;

  @GetMapping
  public ResponseEntity<List<Alarm>> getAllAlarms() {
    return ResponseEntity.ok(alarmService.getAll());
  }

  @GetMapping("/details")
  public ResponseEntity<AlarmDetails> getAlarmDetails() {
    List<Alarm> alarms = alarmService.getAll();
    AlarmDetails details = new AlarmDetails(alarms, alarms.get(alarms.size() - 1));

    return ResponseEntity.ok(details);
  }

  // Extra övning!
  // lägg till en put metod för att skapa nytt alarm
  // skapa test, tänk på gränsfallet!
}
