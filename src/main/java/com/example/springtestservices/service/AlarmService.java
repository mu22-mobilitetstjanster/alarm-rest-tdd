package com.example.springtestservices.service;

import com.example.springtestservices.model.Alarm;

import java.util.List;

public interface AlarmService {

  void addAlarm(Alarm alarm);
  List<Alarm> getAll();
}
