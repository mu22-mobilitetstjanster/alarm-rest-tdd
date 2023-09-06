package com.example.springtestservices.endtoend;

import com.example.springtestservices.model.Alarm;
import com.example.springtestservices.service.AlarmService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AlarmEndToEndTests {

  @BeforeAll
  static void addAlarms(@Autowired AlarmService alarmService) {
    alarmService.addAlarm(new Alarm("Groceries", "18:00"));
    alarmService.addAlarm(new Alarm("Pick up kids", "17:00"));
  }


  @Autowired
  private MockMvc mockMvc;

  @Test
  void testEndToEndAlarmListHasBeenInitialized() throws Exception {
    mockMvc
            .perform(get("/alarm/"))
            .andExpect(status().is(200))
            .andExpect(jsonPath("$").isArray()); // "$" --> root element i json, dvs. listan som skickas i AlarmController
  }

  @Test
  void testEndToEndForAlarmDetailsWithListAndLatestAlarm() throws Exception {
    mockMvc
            .perform(get("/alarm/details"))
            .andExpect(status().is2xxSuccessful()) //testar en range av 200-299
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("alarms").isArray())
            .andExpect(jsonPath("latestAlarm").isEmpty());
  }
}
