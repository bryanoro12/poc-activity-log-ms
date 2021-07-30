package com.collabera.poc.log.service;

import com.collabera.poc.log.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    void saveActivityLog(String message);

    List<ActivityLog> getAll();

    ActivityLog convertStringToActivityLog(String activityLog);
}
