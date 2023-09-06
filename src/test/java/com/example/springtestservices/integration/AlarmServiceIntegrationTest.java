package com.example.springtestservices.integration;

import com.example.springtestservices.model.Alarm;
import com.example.springtestservices.service.AlarmService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlarmServiceIntegrationTest {

  @Autowired
  private AlarmService alarmService;

  @BeforeAll
  static void addEntries(@Autowired AlarmService alarmService) {
    alarmService.addAlarm(new Alarm("Work", "08:00"));
    alarmService.addAlarm(new Alarm("Gym", "15:00"));
  }

  @Test
  void verifyThatReturnedListIsInitialized() {
    assertNotNull(alarmService.getAll());
  }

  @Test
  void verifyInitializationOfTwoEntriesAddedInBeforeAll() {
    assertEquals(2, alarmService.getAll().size());
  }
}