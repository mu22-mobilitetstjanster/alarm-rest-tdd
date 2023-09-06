package com.example.springtestservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmDetails {
  private List<Alarm> alarms;
  private Alarm latestAlarm;
}
