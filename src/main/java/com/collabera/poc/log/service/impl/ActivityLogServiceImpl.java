package com.collabera.poc.log.service.impl;

import com.collabera.poc.log.entity.ActivityLog;
import com.collabera.poc.log.repository.ActivityLogRepository;
import com.collabera.poc.log.service.ActivityLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    /**
     * Save Activity Log
     *
     * @param message
     */
    @Override
    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group.id}")
    public void saveActivityLog(final String message) {
        log.info(message);
        activityLogRepository.save(this.convertStringToActivityLog(message));
        log.info("ActivityLog successfully save.");
    }

    /**
     * Get All Activity Log
     * @return
     */
    @Override
    public List<ActivityLog> getAll() {
        return activityLogRepository.findAll();
    }

    /**
     * Convert String to Activity Log
     *
     * @param activityLog
     * @return
     */
    @Override
    @SneakyThrows
    public ActivityLog convertStringToActivityLog(final String activityLog) {
        log.info("Converting String to ActivityLog...");
        return new ObjectMapper().readValue(activityLog, ActivityLog.class);
    }
}
