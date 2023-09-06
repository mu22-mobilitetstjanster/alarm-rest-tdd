package com.example.springtestservices.service;

import com.example.springtestservices.model.Alarm;
import com.example.springtestservices.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

  @Autowired
  private AlarmRepository alarmRepository;

  @Override
  public void addAlarm(Alarm alarm) {
    alarmRepository.save(alarm);
  }

  @Override
  public List<Alarm> getAll() {
    return alarmRepository.findAll();
  }
}
